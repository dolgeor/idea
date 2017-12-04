/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isd.ideas.roles;

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
public class RoleRestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
 
    @ExceptionHandler(value = { RoleException.class})
    protected ResponseEntity<RoleTypeException> handleRoleException() {
        return new ResponseEntity<>(new RoleTypeException("There is no such role"), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(value = { IllegalArgumentException.class})
    protected ResponseEntity<RoleTypeException> createRoleConflictException() {
        System.out.println("Role can't be created. Role already exist!!!");
        return new ResponseEntity<>(new RoleTypeException("Role can't be created. Role already exist!!!"), HttpStatus.CONFLICT);
    }
   
    private static class RoleTypeException {
        private String message;

        public RoleTypeException(String message) {
            this.message = message;
        }

        public RoleTypeException() {
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
        
    }
}