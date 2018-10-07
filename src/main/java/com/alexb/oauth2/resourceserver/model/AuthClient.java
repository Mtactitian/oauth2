package com.alexb.oauth2.resourceserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
public class AuthClient {

    @Id
    private String id;
    private String secret;
    private String clientId;
    private List<String> scopes;
    private List<String> grantTypes;
    private List<String> authorities;
}
