package com.mygroup.countrygraphql.repositories;

import com.mygroup.countrygraphql.domains.Country;
import java.util.Optional;
import io.micronaut.data.annotation.*;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.model.*;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.H2)
public interface CountryRepository extends CrudRepository<Country, Long> {
    
}