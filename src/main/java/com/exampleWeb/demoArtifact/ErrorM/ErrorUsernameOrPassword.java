package com.exampleWeb.demoArtifact.ErrorM;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ErrorUsernameOrPassword extends RuntimeException {
//    public ErrorUsername(){
//        super(HttpStatus.BAD_REQUEST);
//    }
}
