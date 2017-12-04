package com.isd.ideas.roles;

public class RoleException extends RuntimeException {

    public RoleException(String message) {
        super(message);
        System.out.println(message);
    }

    @Override
    public String toString() {
        return getMessage(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
