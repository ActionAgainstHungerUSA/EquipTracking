package com.actionagainsthunger.equiptracking.domain.administration;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class OrganizationTest {
    @Test
    public void should_be_equal_to_another_organization_when_all_fields_are_equals(){
        Organization organization1 = new Organization("1");
        Organization organization2 = new Organization("1");

        boolean result = organization1.equals(organization2);

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void should_not_be_equal_to_another_organization_when_one_field_is_not_equal(){
        Organization organization1 = new Organization("1");
        Organization organization2 = new Organization("2");

        boolean result = organization1.equals(organization2);

        assertThat(result).isEqualTo(false);
    }

    @Test
    public void should_not_be_equal_to_objects_that_are_not_organization(){
        Organization organization = new Organization("1");

        boolean result = organization.equals(new Object());

        assertThat(result).isEqualTo(false);
    }
}
