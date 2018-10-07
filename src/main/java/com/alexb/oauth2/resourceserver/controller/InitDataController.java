package com.alexb.oauth2.resourceserver.controller;

import com.alexb.oauth2.resourceserver.model.AuthClient;
import com.alexb.oauth2.resourceserver.model.AuthorizedUser;
import com.alexb.oauth2.resourceserver.repository.AuthClientRepository;
import com.alexb.oauth2.resourceserver.repository.AuthUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

import static java.util.Collections.singletonList;

@RestController
@RequiredArgsConstructor
public class InitDataController {

    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthClientRepository authClientRepository;

    @GetMapping("/init")
    public void initData() {

        authClientRepository.deleteAll();
        authUserRepository.deleteAll();

        authUserRepository.save(new AuthorizedUser(null, "ALEX581",
                passwordEncoder.encode("asd581"),
                singletonList("ROLE_USER")));

        authClientRepository.save(new AuthClient(null,
                passwordEncoder.encode("asd581"),
                "client581",
                Arrays.asList("access", "access2"),
                Arrays.asList("password", "refresh_token"),
                singletonList("ROLE_USER")));
    }
}