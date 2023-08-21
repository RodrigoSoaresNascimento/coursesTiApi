package com.cursosdeti.apicursosdeti.exception;

public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException(Integer id) {
        super("Registro não encontrado para o identificador : "+ id);
    }
}
