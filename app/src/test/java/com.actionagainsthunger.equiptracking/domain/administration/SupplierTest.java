package com.actionagainsthunger.equiptracking.domain.administration;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SupplierTest{
    @Test
    public void should_be_equal_to_another_supplier_when_all_fields_are_equals(){
        Supplier supplier1 = new Supplier("1");
        Supplier supplier2 = new Supplier("1");

        boolean result = supplier1.equals(supplier2);

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void should_not_be_equal_to_another_supplier_when_one_field_is_not_equal(){
        Supplier supplier1 = new Supplier("1");
        Supplier supplier2 = new Supplier("2");

        boolean result = supplier1.equals(supplier2);

        assertThat(result).isEqualTo(false);
    }

    @Test
    public void should_not_be_equal_to_objects_that_are_not_supplier(){
        Supplier supplier = new Supplier("1");

        boolean result = supplier.equals(new Object());

        assertThat(result).isEqualTo(false);
    }

}