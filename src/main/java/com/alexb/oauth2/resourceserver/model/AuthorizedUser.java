package com.alexb.oauth2.resourceserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizedUser {
    @Id
    private String id;
    private String name;
    private String password;
    private List<String> roles;
}
