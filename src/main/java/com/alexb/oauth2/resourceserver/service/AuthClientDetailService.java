package com.alexb.oauth2.resourceserver.service;

import com.alexb.oauth2.resourceserver.repository.AuthClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import static org.springframework.util.StringUtils.collectionToCommaDelimitedString;

@Service
@RequiredArgsConstructor
public class AuthClientDetailService implements ClientDetailsService {

    private final AuthClientRepository authClientRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        return authClientRepository.findByClientId(clientId)
                .map(authClient -> {
                    BaseClientDetails baseClientDetails = new BaseClientDetails(clientId,
                            null,
                            collectionToCommaDelimitedString(authClient.getScopes()),
                            collectionToCommaDelimitedString(authClient.getGrantTypes()),
                            collectionToCommaDelimitedString(authClient.getAuthorities()),
                            "/");
                    baseClientDetails.setClientSecret(authClient.getSecret());
                    return baseClientDetails;
                })
                .orElseThrow(() -> new UsernameNotFoundException(clientId));
    }
}
