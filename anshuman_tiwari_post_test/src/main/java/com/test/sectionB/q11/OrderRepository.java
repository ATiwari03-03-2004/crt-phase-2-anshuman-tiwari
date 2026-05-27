package com.test.sectionB.q11;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
 * Q11 - 11 SQL queries instead of 1.
 *
 * PROBLEM NAME: the N+1 select problem.
 *
 * LINE THAT CAUSES IT (in the caller):
 *     List<Order> orders = orderRepo.findAll();          // 1 query for the orders
 *     for (Order o : orders) {
 *         System.out.println(o.getItems().size());       // +1 query per order = N (10 here)
 *     }
 *     // 1 + 10 = 11 queries.
 *
 * ONE-LINE FIX: replace findAll() with a JOIN FETCH query that loads orders and
 * their items together in a single query:
 *     List<Order> orders = orderRepo.findAllWithItems();
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT DISTINCT o FROM Order o JOIN FETCH o.items")
    List<Order> findAllWithItems();
}
