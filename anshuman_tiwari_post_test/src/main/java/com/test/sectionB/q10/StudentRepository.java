package com.test.sectionB.q10;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // (a) find by city
    List<Student> findByCity(String city);

    // (b) find by name and city
    List<Student> findByNameAndCity(String name, String city);

    // (c) find by email containing a keyword
    List<Student> findByEmailContaining(String keyword);

    // (d) count students in a city
    long countByCity(String city);
}
