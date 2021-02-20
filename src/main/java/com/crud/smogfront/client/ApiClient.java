package com.crud.smogfront.client;

import com.crud.smogfront.config.ApiConfig;
import com.crud.smogfront.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class ApiClient {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ApiConfig apiConfig;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiClient.class);
    public List<User> getUsers() {
        try {
            Optional<User[]> listResponse = Optional.ofNullable(restTemplate.getForObject(apiConfig.getApiEndpointUserGet(), User[].class));
            return Arrays.asList(listResponse.orElse(new User[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>();
        }
    }
}
