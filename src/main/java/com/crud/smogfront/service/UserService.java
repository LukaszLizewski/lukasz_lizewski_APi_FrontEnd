package com.crud.smogfront.service;

import com.crud.smogfront.client.ApiClient;
import com.crud.smogfront.domain.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private static UserService userService;
    private List<User> listOfUsers;

    private UserService() {
        this.listOfUsers = exampleData();
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public List<User> getUsers() {
        return new ArrayList<>(listOfUsers);
    }

    public void addUser(User user) {
        this.listOfUsers.add(user);
    }

    public List<User> findByFinder(String finder) {
        return listOfUsers.stream()
                .filter(user -> user.getFirstName().concat(user.getLastName()).contains(finder))
                .collect(Collectors.toList());
    }

    public void save(User user) {
        this.listOfUsers.add(user);
    }

    public void delete(User user) {
        this.listOfUsers.remove(user);
    }

    private List<User> exampleData() {
        ApiClient apiClient = new ApiClient();
        listOfUsers = apiClient.getUsers();
//        List<User> listOfUsers = new ArrayList<>();
//        listOfUsers.add(new User(1L, "firsName1", "lastName1","Gdańsk", "Grunwaldzka", "Pomorskie"));
//        listOfUsers.add(new User(2L, "firsName2", "lastName2", "Wrocław", "Grunwaldzka", "Dolnośląskie"));
//        listOfUsers.add(new User(3L, "firsName3", "lastName3", "Koszalin", "Grunwaldzka", "Zachodniopomorskie"));
        return listOfUsers;
    }
}
