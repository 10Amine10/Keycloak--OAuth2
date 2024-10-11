package com.codewithAmine.OAuth2_keycloak.service;

import com.codewithAmine.OAuth2_keycloak.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

     }

