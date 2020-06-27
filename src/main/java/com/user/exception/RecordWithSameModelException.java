package com.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordWithSameModelException extends Exception {

    private static final long serialVersionUID = 1L;

    public RecordWithSameModelException() {
        super("Record with same model already exists");
    }

}
