package com.example.rushtutorial.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
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
}
