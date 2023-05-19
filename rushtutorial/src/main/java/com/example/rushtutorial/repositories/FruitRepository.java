package com.example.rushtutorial.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.rushtutorial.entities.FruitEntity;

@Repository // помечаем что этот бин - репозиторий
public interface FruitRepository extends JpaRepository<FruitEntity, Integer> {
    // репозиторий является интерфейсом, который наследуется от другого интерфейса JpaRepository<>
    // для него необходимо указать с какой сущностью он должен работать, у нас это FruitEntity
    // и тип данных у поля id данной сущности, у нас это Integer

    // все необходимые методы наследуются от PagingAndSortingRepository<t,""> и QueryByExampleExecutor<> 
    // paging - divide (a piece of software or data) into sections, keeping the most frequenty
    // accessed in main memory and storing the rest in virtual memory.
    List<FruitEntity> findByProviderCodeBetween(Integer from, Integer to);


    // SELECT экземпляр1.поле_класса, экземпляр2.поле_класса 
    // FROM сущность1 экземпляр1 
    // LEFT JOIN сущность2 экземпляр2 ON экземпляр1.поле_сущности = экземпляр2.поле_сущности 
    // ON f.providerCode = p.id
    // полный список FruitEntity, экземпляры которые не подошли по условию будут выведены с "null"
    @Query("SELECT f.fruitName, p.providerName FROM FruitEntity f LEFT JOIN ProviderEntity p ON f.providerCode = p.id")
    List<String> joinString();

    // из списка будут лишь те элементы которые подойдут по условию
    @Query("SELECT f FROM FruitEntity f JOIN ProviderEntity p ON f.providerCode = p.id")
    List<FruitEntity> joinFruit();

    // Для сложных запросов все равно используется стандартный SQL 
    @Query(
        value = "SELECT fruit_table.fruit_name, provider_table.provider_name FROM fruit_table JOIN provider_table ON fruit_table.provider_code = provider_table.id_provider", 
        nativeQuery = true 
    )
    List<String> joinSqlFruit();
    
    // custom query
    @Query("SELECT a FROM FruitEntity a WHERE a.fruitName LIKE 'Fruit4'")
    List<FruitEntity> getAllFruitName();
}
