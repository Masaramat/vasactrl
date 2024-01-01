package com.vasactrl.exceptions.handlers;

import java.io.IOException;

public class BranchNotFoundException extends IOException {
    public BranchNotFoundException(String message){
        super(message);
    }
}
