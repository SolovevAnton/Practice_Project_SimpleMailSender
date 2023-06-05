package com.solovev;

import com.solovev.simplecrmfx.repositories.UserRepository;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File userFile = new File("src/main/resources/com/solovev/files/users.json");
        UserRepository repo = new UserRepository(userFile);
    }
}
