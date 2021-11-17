package com.exampleWeb.demoArtifact.ErrorM;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotFound extends ResponseStatusException {
    public UserNotFound(){
        super(HttpStatus.NOT_FOUND);
        //super(HttpStatus.NOT_FOUND, "not found");
    }
}
