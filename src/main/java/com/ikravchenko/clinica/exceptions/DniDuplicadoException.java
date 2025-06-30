package com.ikravchenko.clinica.exceptions;

public class DniDuplicadoException extends Exception {
    public DniDuplicadoException(String message) {
        super(message);
    }
    
    public DniDuplicadoException(String message, Throwable cause) {
        super(message, cause);
    }
} 