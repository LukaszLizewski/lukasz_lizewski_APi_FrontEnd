package com.crud.smogfront.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
//@Component
public class ApiConfig {
//    @Value("${api.endpoint.user.get}")
    private final String apiEndpointUserGet = "https://floating-shore-50400.herokuapp.com/v1/smog/user";
//    @Value("${api.endpoint.user.post}")
    private final String apiEndpointUserPost = "https://floating-shore-50400.herokuapp.com/v1/smog/user/createUser";
    private final String apiEndpointUserDelete = "https://floating-shore-50400.herokuapp.com/v1/smog/user/deleteUser/";
}
