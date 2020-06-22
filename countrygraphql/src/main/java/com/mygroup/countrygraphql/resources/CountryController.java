package com.mygroup.countrygraphql.resources;


import io.micronaut.context.annotation.Parameter;
import io.micronaut.http.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import com.mygroup.countrygraphql.domains.Country;
import com.mygroup.countrygraphql.services.CountryService;


@Controller("/api/country")
public class CountryController {

    private static final Logger log = LoggerFactory.getLogger(CountryController.class);

    @Inject private CountryService countryService;

    @Post("/save")
    public Country save(@Body Country country){
        log.info("Saving  Country : {}", country);
        //TODO insert your logic here!

        //saving Object
        return countryService.save(country);
    }
    @Get("/get")
    public Country findById(@Parameter("id") long id){
        return countryService.findById(id);
    }

    @Delete("/delete/{id}")
    public boolean deleteById(@PathVariable("id") long id){
        log.info("Deleting Country by Id: {}", id);
        return  countryService.deleteById(id);
    }

    @Get("/findAll")
    public Iterable<Country> findAll(){
        log.info("find All");
        return countryService.findAll();
    }

    @Put("/update")
    public Country update(@Body Country country)
    {
        log.info("update {}", country);
        return countryService.update(country);

    }
}