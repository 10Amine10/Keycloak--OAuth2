package com.codewithAmine.OAuth2_keycloak.service.impl;

import com.codewithAmine.OAuth2_keycloak.entities.UserEntity;
import com.codewithAmine.OAuth2_keycloak.model.NewUserRecord;
import com.codewithAmine.OAuth2_keycloak.service.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity findUserEntityById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not___Found !!?!!"));
    }



    @Override
    public NewUserRecord createUser(NewUserRecord newUserRecord) {
       UserEntity userEntity = new UserEntity();
       userEntity.setUsername(newUserRecord.username());
       userEntity.setFirstName(newUserRecord.firstName());
       userEntity.setLastName(newUserRecord.lastName());
       userEntity.setPassword(newUserRecord.password());
       userRepository.save(userEntity);

       return new NewUserRecord(
               userEntity.getUsername(),
               newUserRecord.password(),
               userEntity.getFirstName(),
               userEntity.getLastName()
       );
    }
}
