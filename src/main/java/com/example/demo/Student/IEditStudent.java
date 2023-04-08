package com.example.demo.Student;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IEditStudent extends PagingAndSortingRepository<Student, String> {

    @Modifying
    @Query("update Student s set s.name = ?1, s.dateOfBirth = ?2 where s.id = ?3")
    void setUserInfoById(String name, LocalDate date, Integer id);
}

//@Query("Insert into")