package com.isd.ideas.idea;

public class IdeaException extends RuntimeException {

    public IdeaException(String message) {
        super(message);
        System.out.println(message);
    }

    @Override
    public String toString() {
        return getMessage(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
