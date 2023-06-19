package com.solovev.simplecrmfx.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solovev.simplecrmfx.model.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * repo to read users from file
 */
public class UserRepository {
    private Set<User> users = new HashSet<>();
    ObjectMapper objectMapper = new ObjectMapper();

    public UserRepository() {
    }

    /**
     * Constructor reads users from file and if user is presented in SendUserRepository changes isSend field fo users
     * @param file to load users from
     * @throws IOException if file not found
     */
    public UserRepository(File file) throws IOException {
        this.users = objectMapper
                .findAndRegisterModules()
                .readValue(file, new TypeReference<>() {
                });
        Set<Integer> userSend = new SendUserRepository().getUsersIDs();
        users
                .stream()
                .filter(u -> userSend.contains(u.getId()))
                .forEach(u -> u.setIsSend(true));
    }

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }
}
