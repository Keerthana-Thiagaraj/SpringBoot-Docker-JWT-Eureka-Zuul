package com.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordWithSameBrandException extends Exception {

    private static final long serialVersionUID = 1L;

    public RecordWithSameBrandException() {
        super("Record with same brand already exists");
    }

}
