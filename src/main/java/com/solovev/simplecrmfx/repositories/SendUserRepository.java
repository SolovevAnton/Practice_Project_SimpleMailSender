package com.solovev.simplecrmfx.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solovev.simplecrmfx.util.Constants;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Repo to store user IDs, to whom emails was already sent
 */

public class SendUserRepository {
    private Set<Integer> usersIDs = new HashSet<>();
    private final ObjectMapper mapper = new ObjectMapper();

    public SendUserRepository() {
        try {
            usersIDs = mapper.readValue(Constants.USERS_ID, new TypeReference<>() {
            });
        } catch (IOException ignored) {
        }
    }

    public Set<Integer> getUsersIDs() {
        return Collections.unmodifiableSet(usersIDs);
    }
}
