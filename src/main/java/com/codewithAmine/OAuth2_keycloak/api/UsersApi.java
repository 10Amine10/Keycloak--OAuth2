package com.codewithAmine.OAuth2_keycloak.api;


import com.codewithAmine.OAuth2_keycloak.model.NewUserRecord;
import com.codewithAmine.OAuth2_keycloak.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersApi {

    private final UserService userService;
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody NewUserRecord newUserRecord) {

        userService.createUser(newUserRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created success-fully");

    }
}
