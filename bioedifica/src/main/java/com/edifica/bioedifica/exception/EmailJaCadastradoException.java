package com.edifica.bioedifica.exception;

public class EmailJaCadastradoException extends RuntimeException {
    public EmailJaCadastradoException(String email) {
        super("Email '" + email + "' já está cadastrado no sistema");
    }
}