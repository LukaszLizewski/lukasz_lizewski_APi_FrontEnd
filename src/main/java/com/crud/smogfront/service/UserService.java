package com.crud.smogfront.service;

import com.crud.smogfront.client.ApiClient;
import com.crud.smogfront.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private static UserService userService;
    private List<User> listOfUsers;
    private ApiClient apiClient;

    private UserService() {
        this.apiClient = new ApiClient();
        this.listOfUsers = getData();

    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }
    public List<User> findByFinder(String finder) {
        return listOfUsers.stream()
                .filter(user -> user.getFirstName().concat(user.getLastName()).concat(user.getAddressCity()).concat(user.getAddressProvince()).contains(finder))
                .collect(Collectors.toList());
    }

    public void postUser(User user) {
        apiClient.postUser(user);
    }

    public void deleteUser (User user) {
        apiClient.deleteUser(user);
    }

    public List<User> getData() {
        listOfUsers = apiClient.getUsers();
        return listOfUsers;
    }
}
