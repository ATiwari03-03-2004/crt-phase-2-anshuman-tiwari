package com.test.sectionA.q2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * MISTAKE:
 *   The original line built the ResponseEntity with only a status:
 *       return new ResponseEntity<>(HttpStatus.OK);
 *   That constructor sets the status code but NO body, so the response body is
 *   always empty even though "u" was fetched.
 *
 * CORRECTED LINE (only line that needed to change):
 *       return new ResponseEntity<>(u, HttpStatus.OK);
 *
 * (Also changed @Controller to @RestController so the User is serialized to JSON.
 *  With a plain @Controller you would need @ResponseBody on the method.)
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User u = service.findById(id);
        return new ResponseEntity<>(u, HttpStatus.OK); // CORRECTED: body "u" now included
    }
}
