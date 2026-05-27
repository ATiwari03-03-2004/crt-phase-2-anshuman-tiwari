-- Q9 - Second highest salary
-- Table: employees(id, name, salary)

-- ============================================================
-- Approach 1: Subquery (find the max salary below the overall max)
-- ============================================================
SELECT MAX(salary) AS second_highest_salary
FROM employees
WHERE salary < (SELECT MAX(salary) FROM employees);

-- ============================================================
-- Same logic written as a JPQL @Query in the JPA repository
-- (see EmployeeRepository.java in this folder):
-- ============================================================
-- @Query("SELECT MAX(e.salary) FROM Employee e " +
--        "WHERE e.salary < (SELECT MAX(e2.salary) FROM Employee e2)")
-- Double findSecondHighestSalary();
