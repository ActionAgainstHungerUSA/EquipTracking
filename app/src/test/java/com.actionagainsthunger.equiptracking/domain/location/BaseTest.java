package com.actionagainsthunger.equiptracking.domain.location;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;
import com.actionagainsthunger.equiptracking.domain.builders.*;

public class BaseTest {
    @Test
    public void should_be_equal_to_another_base_when_all_fields_are_equals(){
        Country country = new ACountry().Build();
        Base base1 = new Base("1", country);
        Base base2 = new Base("1", country);

        boolean result = base1.equals(base2);

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void should_not_be_equal_to_another_base_when_one_field_is_not_equal(){
        Country country = new ACountry().Build();
        Base base1 = new Base("1", country);
        Base base2 = new Base("2", country);

        boolean result = base1.equals(base2);

        assertThat(result).isEqualTo(false);
    }

    @Test
    public void should_not_be_equal_to_objects_that_are_not_base(){
        Base base = new Base("1", new ACountry().Build());

        boolean result = base.equals(new Object());

        assertThat(result).isEqualTo(false);
    }
}
