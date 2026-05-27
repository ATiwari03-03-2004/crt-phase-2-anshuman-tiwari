package com.test.sectionB.q9;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // JPQL equivalent of the "second highest salary" subquery.
    // Returns the highest salary that is strictly less than the maximum salary.
    @Query("SELECT MAX(e.salary) FROM Employee e " +
           "WHERE e.salary < (SELECT MAX(e2.salary) FROM Employee e2)")
    Double findSecondHighestSalary();
}
