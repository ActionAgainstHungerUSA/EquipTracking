package com.actionagainsthunger.equiptracking.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BrandTest {
    @Test
    public void should_be_equal_to_another_brand_when_all_fields_are_equals(){
        Brand brand1 = new Brand("1");
        Brand brand2 = new Brand("1");

        boolean result = brand1.equals(brand2);

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void should_not_be_equal_to_another_brand_when_one_field_is_not_equal(){
        Brand brand1 = new Brand("1");
        Brand brand2 = new Brand("2");

        boolean result = brand1.equals(brand2);

        assertThat(result).isEqualTo(false);
    }

    @Test
    public void should_not_be_equal_to_objects_that_are_not_brand(){
        Brand brand = new Brand("1");

        boolean result = brand.equals(new Object());

        assertThat(result).isEqualTo(false);
    }
}


