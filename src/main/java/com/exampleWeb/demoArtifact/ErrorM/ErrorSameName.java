package com.exampleWeb.demoArtifact.ErrorM;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ErrorSameName extends ResponseStatusException {
    public ErrorSameName(){
        super(HttpStatus.CONFLICT);
        //super(HttpStatus.NOT_FOUND, "not found");
    }
}
