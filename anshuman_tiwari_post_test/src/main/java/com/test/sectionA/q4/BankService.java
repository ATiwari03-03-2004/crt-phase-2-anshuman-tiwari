package com.test.sectionA.q4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * ANNOTATION TO ADD: @Transactional  (on the transfer() method).
 *
 * WHY / WHAT HAPPENS IF MISSING:
 *   transfer() performs TWO updates (debit "from" + credit "to"). @Transactional
 *   makes them one atomic unit - either both commit or both roll back.
 *   Without it, if the second save fails (or the app crashes between them), the
 *   debit is already committed while the credit never happens -> money disappears
 *   and the database is left in an inconsistent state.
 */
@Service
public class BankService {

    @Autowired
    AccountRepository repo;

    @Transactional
    public void transfer(Long fromId, Long toId, double amount) {
        Account from = repo.findById(fromId).orElseThrow();
        Account to = repo.findById(toId).orElseThrow();
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
        repo.save(from);
        repo.save(to);
    }
}
