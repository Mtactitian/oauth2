package com.alexb.oauth2.resourceserver.service;

import com.alexb.oauth2.resourceserver.repository.AuthUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class AuthUserDetailsService implements UserDetailsService {

    private final AuthUserRepository authUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return authUserRepository.findByName(username)
                .map(authUser -> new User(authUser.getName(), authUser.getPassword(),
                        AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils.collectionToCommaDelimitedString(authUser.getRoles()))))
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
