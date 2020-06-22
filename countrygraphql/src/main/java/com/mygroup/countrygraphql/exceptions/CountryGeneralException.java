package com.mygroup.countrygraphql.exceptions;

public class CountryGeneralException extends RuntimeException {
    private String message;
    public CountryGeneralException(String message)
    {
        super(message);
    }
}