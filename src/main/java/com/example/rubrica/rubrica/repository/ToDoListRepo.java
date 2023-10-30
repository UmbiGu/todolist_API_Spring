package com.example.rubrica.rubrica.repository;

import com.example.rubrica.rubrica.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ToDoListRepo extends JpaRepository<ToDoList, Long> {

    List<ToDoList>findByNameToDo(String nameToDo);
    List<ToDoList>findByCreationDate(LocalDate creationDate);
    List<ToDoList>findByExpiredDate(LocalDate expiredDate);
    List<ToDoList>findByNameToDoAndCreationDate(String nameToDo, LocalDate creationDate);
    List<ToDoList>findByNameToDoAndExpiredDate(String nameToDo, LocalDate expiredDate);
    List<ToDoList>findByCreationDateAndExpiredDate(LocalDate creationDate, LocalDate expiredDate);

    List<ToDoList>findByNameToDoAndCreationDateAndExpiredDate(String nameToDo, LocalDate creationDate, LocalDate expiredDate);


//    @Query(nativeQuery = true, value = "SELECT * FROM to_do_list WHERE creation_date = :query")
//    List<ToDoList>searchFromStartDate(String query);
//
//    @Query(nativeQuery = true, value = "SELECT * FROM to_do_list WHERE expired_date = :query")
//    List<ToDoList>searchFromEndDate(String query);


}
