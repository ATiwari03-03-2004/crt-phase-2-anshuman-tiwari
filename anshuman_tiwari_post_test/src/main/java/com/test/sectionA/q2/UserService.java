package com.test.sectionA.q2;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User findById(Long id) {
        // In a real app this would come from a repository / database.
        return new User(id, "Anshuman");
    }
}
