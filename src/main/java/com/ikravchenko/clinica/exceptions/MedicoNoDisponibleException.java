package com.ikravchenko.clinica.exceptions;

public class MedicoNoDisponibleException extends Exception {
    public MedicoNoDisponibleException(String message) {
        super(message);
    }
    
    public MedicoNoDisponibleException(String message, Throwable cause) {
        super(message, cause);
    }
} 