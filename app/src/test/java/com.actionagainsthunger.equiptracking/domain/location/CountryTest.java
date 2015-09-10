package com.actionagainsthunger.equiptracking.domain.location;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountryTest {
    @Test
    public void should_be_equal_to_another_country_when_all_fields_are_equals(){
        Country country1 = new Country("1");
        Country country2 = new Country("1");

        boolean result = country1.equals(country2);

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void should_not_be_equal_to_another_country_when_one_field_is_not_equal(){
        Country country1 = new Country("1");
        Country country2 = new Country("2");

        boolean result = country1.equals(country2);

        assertThat(result).isEqualTo(false);
    }

    @Test
    public void should_not_be_equal_to_objects_that_are_not_country(){
        Country country = new Country("1");

        boolean result = country.equals(new Object());

        assertThat(result).isEqualTo(false);
    }
}
