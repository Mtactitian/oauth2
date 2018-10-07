package com.alexb.oauth2.resourceserver.repository;

import com.alexb.oauth2.resourceserver.model.AuthClient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AuthClientRepository extends MongoRepository<AuthClient, String> {
    Optional<AuthClient> findByClientId(String s);
}
