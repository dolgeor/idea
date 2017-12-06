/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isd.ideas.vote;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Гриша
 */
@ControllerAdvice
public class VoteRestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
 
    @ExceptionHandler(value = {VoteException.class})
    protected ResponseEntity<VoteTypeException> handleVoteException(VoteException e) {
        return new ResponseEntity<>(new VoteTypeException(e.toString()), HttpStatus.NOT_FOUND);
    }
    
    private static class VoteTypeException {
        private String message;

        public VoteTypeException(String message) {
            this.message = message;
        }

        public VoteTypeException() {
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
        
    }
}