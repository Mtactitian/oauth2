package com.alexb.oauth2.resourceserver.repository;

import com.alexb.oauth2.resourceserver.model.AuthorizedUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AuthUserRepository extends MongoRepository<AuthorizedUser, String> {
    Optional<AuthorizedUser> findByName(String name);
}
