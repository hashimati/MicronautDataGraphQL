package com.mygroup.countrygraphql.clients;


import io.micronaut.context.annotation.Parameter;
import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import javax.inject.Inject;
import io.reactivex.Flowable;
import io.reactivex.Single;
import com.mygroup.countrygraphql.domains.Country;


@Client("/api/country")
public interface CountryClient {

    @Post("/save")
    public Country save(Country country);

    @Get("/get")
    public Country findById(@Parameter("id") long id);

    @Delete("/delete/{id}")
    public boolean deleteById(@PathVariable("id") long id);

    @Get("/findAll")
    public Iterable<Country> findAll();

    @Put("/update")
    public Country update(@Body Country country);
}