package com.solovev.simplecrmfx.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solovev.simplecrmfx.model.User;
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

    /**
     * Method to add user ID to send repository
     *
     * @param userID to add
     * @return true if user successfully added
     */
    public boolean addUser(int userID) {
        return usersIDs.add(userID);
    }

    /**
     * Method saves user ID in the file Constants.USERS_ID and creates it if it is not present
     */
    public void save() {
        try {
            mapper.writeValue(Constants.USERS_ID, usersIDs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method clears the file with users send ID's
     */
    public void clear(){
        usersIDs.clear();
        save();
    }

    public Set<Integer> getUsersIDs() {
        return Collections.unmodifiableSet(usersIDs);
    }
}
