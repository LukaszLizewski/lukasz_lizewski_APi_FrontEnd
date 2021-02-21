package com.crud.smogfront.client;

import com.crud.smogfront.config.ApiConfig;
import com.crud.smogfront.domain.User;
import com.crud.smogfront.domain.UserDto;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//@Component
//@Configurable
public class ApiClient {
//    @Autowired
//    private RestTemplate restTemplate = new RestTemplate();
//    @Autowired
//    private ApiConfig apiConfig = new ApiConfig();

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiClient.class);

    public List<User> getUsers() {
        RestTemplate restTemplate = new RestTemplate();
        ApiConfig apiConfig = new ApiConfig();
        try {
            LOGGER.info("REST API Smog-> getUsers");
            Optional<User[]> listResponse = Optional.ofNullable(restTemplate.getForObject(apiConfig.getApiEndpointUserGet(), User[].class));
            return Arrays.asList(listResponse.orElse(new User[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>();
        }
    }
    public UserDto postUser(final User user) {
        RestTemplate restTemplate = new RestTemplate();
        ApiConfig apiConfig = new ApiConfig();
        LOGGER.info("REST API Smog-> postUser");

        Gson gson = new Gson();
        String jsonContent = gson.toJson(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(jsonContent, headers);

        return restTemplate.postForObject(apiConfig.getApiEndpointUserPost(), request, UserDto.class);

    }
    public void deleteUser (final User user) {
        RestTemplate restTemplate = new RestTemplate();
        ApiConfig apiConfig = new ApiConfig();
        URI url = UriComponentsBuilder.fromHttpUrl(apiConfig.getApiEndpointUserDelete())
                .queryParam("Id", user.getId())
                .build().encode().toUri();
        restTemplate.delete(url);
    }
}
