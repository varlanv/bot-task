package com.task.bottask.repository;

import com.task.bottask.domain.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LectorRepository extends JpaRepository<Lector, Integer> {

    @Query(value = "SELECT l FROM Lector l " +
            "WHERE UPPER(l.firstName) " +
            "LIKE UPPER(CONCAT('%',:template, '%')) " +
            "OR " +
            "UPPER(l.lastName) " +
            "LIKE UPPER(CONCAT('%',:template, '%'))")
    List<Lector> findByTemplate(@Param("template") String template);


    @Query("SELECT l FROM Lector l " +
            "JOIN l.departments d " +
            "WHERE d.name = :department " +
            "AND l.headOfDepartment = true ")
    Optional<Lector> headOfDepartment(@Param("department") String department);
}
