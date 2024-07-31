package com.educandoweb.workshopmongo.service.exception;

import java.io.Serial;

public class ObjectNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(Object id) {
       super("Object with id " + id + " not found");
    }

}
