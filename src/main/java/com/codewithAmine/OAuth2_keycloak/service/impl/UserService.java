package com.codewithAmine.OAuth2_keycloak.service.impl;

import com.codewithAmine.OAuth2_keycloak.entities.UserEntity;
import com.codewithAmine.OAuth2_keycloak.model.NewUserRecord;

public interface UserService {
    NewUserRecord createUser(NewUserRecord newUserRecord);
    UserEntity findUserEntityById(Long id);
}
