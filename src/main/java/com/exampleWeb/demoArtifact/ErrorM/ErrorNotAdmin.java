package com.exampleWeb.demoArtifact.ErrorM;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ErrorNotAdmin extends ResponseStatusException {
    public  ErrorNotAdmin() {
        super(HttpStatus.FORBIDDEN);
    }
}
