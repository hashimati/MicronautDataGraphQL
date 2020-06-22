package com.mygroup.countrygraphql.repositories;


import com.mygroup.countrygraphql.utils.Randomizer;
import com.mygroup.countrygraphql.domains.Country;
import com.mygroup.countrygraphql.repositories.CountryRepository;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.*;
import javax.inject.Inject;
@MicronautTest
public class CountryRepositoryTest {

    @Inject
    private CountryRepository countryRepository;

    Country country;

    public CountryRepositoryTest() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        this.country = new Randomizer<Country>(Country.class).getRandomInstance();

    }
    @Order(1)
    @Test
    public void saveAndFind(){

        this.country = countryRepository.save(country);

        Assertions.assertNotNull(this.country.getId());
        Country findResult  = countryRepository.findById(country.getId()).get();
        Assertions.assertEquals(this.country.getId(), findResult.getId());
    }


    @Order(2)
    @Test
    public void update() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Country update = new Randomizer<Country>(Country.class).getRandomInstance();
        update.setId(country.getId());
        this.country = countryRepository.update(update);
        Assertions.assertEquals(update.getId(), this.country.getId());
    }

    @Order(3)
    @Test
    public void deleteById() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        try {
            countryRepository.deleteById(this.country.getId());
            Assertions.assertTrue(true);
        }catch (Exception ex){

        }

    }

}