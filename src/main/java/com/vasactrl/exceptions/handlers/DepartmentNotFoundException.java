package com.vasactrl.exceptions.handlers;

import java.io.IOException;

public class DepartmentNotFoundException extends IOException {

    public DepartmentNotFoundException(String message){
        super(message);
    }
}
