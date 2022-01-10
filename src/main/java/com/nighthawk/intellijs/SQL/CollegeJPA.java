package com.nighthawk.intellijs.SQL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CollegeJPA extends JpaRepository<College, Long> {


    // Custom JPA query
    @Query(
            value = "SELECT * FROM College c WHERE c.name LIKE ?1",
            nativeQuery = true)
    List<College> findByLikeTermNative(String term);
    /*
        https://www.baeldung.com/spring-data-jpa-query
     */
}