package com.alexb.oauth2.resourceserver.controller;

import com.alexb.oauth2.resourceserver.model.AuthorizedUser;
import com.alexb.oauth2.resourceserver.repository.AuthUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class InitDataController {

    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/init")
    public void initData() {
        authUserRepository.save(new AuthorizedUser(null, "ALEX581",
                passwordEncoder.encode("asd581"),
                Collections.singletonList("ROLE_USER")));
    }
}
