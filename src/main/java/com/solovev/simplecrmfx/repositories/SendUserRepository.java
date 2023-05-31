package com.solovev.simplecrmfx.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solovev.simplecrmfx.util.Constants;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SendUserRepository {
    Set<Integer> users = new HashSet<>();
    ObjectMapper mapper = new ObjectMapper();

    public SendUserRepository() {
        try {
            users = mapper.readValue(Constants.USERS_ID, new TypeReference<>() {
            });
        } catch (IOException ignored) {
            throw new RuntimeException(ignored);
        }
    }
}
