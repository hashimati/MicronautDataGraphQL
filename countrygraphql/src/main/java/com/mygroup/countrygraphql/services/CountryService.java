package com.mygroup.countrygraphql.services;


import javax.inject.Inject;
import javax.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import com.mygroup.countrygraphql.domains.Country;
import com.mygroup.countrygraphql.repositories.CountryRepository;


@Singleton
@Transactional
public class CountryService {

    private static final Logger log = LoggerFactory.getLogger(CountryService.class);
    @Inject private CountryRepository countryRepository;

    public Country save(Country country){
        log.info("Saving  Country : {}", country);
        //TODO insert your logic here!
        //saving Object
        countryRepository.save(country);
        return country;
    }

    public Country findById(long id){
        log.info("Finding Country By Id: {}", id);
        return countryRepository.findById(id).orElse(null);
    }


    public boolean deleteById(long id){
        log.info("Deleting Country by Id: {}", id);
        try{
            countryRepository.deleteById(id);
            log.info("Deleted Country by Id: {}", id);
            return true;
        }
        catch(Exception ex)
        {
            log.info("Failed to delete Country by Id: {}", id);
            ex.printStackTrace();
            return false;
        }
    }

    public Iterable<Country> findAll() {
        log.info("Find All");
      return  countryRepository.findAll();
    }

    public boolean existsById(Long id)
    {
        log.info("Check if id exists: {}", id);
        return  countryRepository.existsById(id);

    }
    public Country update(Country country)
    {
        log.info("update {}", country);
        return countryRepository.update(country);

    }

}