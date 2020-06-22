package com.mygroup.countrygraphql.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mygroup.countrygraphql.domains.Country;
import com.mygroup.countrygraphql.repositories.CountryRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CountryQueryResolver implements GraphQLQueryResolver {
    @Inject
    private CountryRepository countryRepository;
    public Country find(long id)
    {
        return countryRepository.findById(id).get();
    }

}
