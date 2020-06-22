package com.mygroup.countrygraphql.exceptions.handlers;

import com.mygroup.countrygraphql.exceptions.CountryGeneralException;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import javax.inject.Singleton;


@Produces
@Requires(classes = {CountryGeneralException.class, ExceptionHandler.class})
@Singleton
public class CountryExceptionHandler implements ExceptionHandler<CountryGeneralException, HttpResponse> {
    @Override
    public HttpResponse handle(HttpRequest request, CountryGeneralException exception) {
        return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}