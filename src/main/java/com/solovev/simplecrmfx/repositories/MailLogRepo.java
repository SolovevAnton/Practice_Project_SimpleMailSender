package com.solovev.simplecrmfx.repositories;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solovev.simplecrmfx.util.Constants;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Repository to store mail login
 */
public class MailLogRepo {
    private final String log;
    private final String pass;
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Takes cvs file and reads data from it. first string pass, second log
     * File situated in constants
     */
    public MailLogRepo() throws IOException {
        JsonNode parent= new ObjectMapper().readTree(Constants.MAIL_INFO);
        pass = parent.path("pass").asText();
        log = parent.path("log").asText();
    }

    public String getLog() {
        return log;
    }

    public String getPass() {
        return pass;
    }
}
