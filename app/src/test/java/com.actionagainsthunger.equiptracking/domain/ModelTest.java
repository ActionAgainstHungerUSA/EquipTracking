package com.actionagainsthunger.equiptracking.domain;

import com.actionagainsthunger.equiptracking.domain.builders.ABrand;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ModelTest {
    @Test
    public void should_be_equal_to_another_model_when_all_fields_are_equals(){
        Brand brand = new ABrand().Build();
        Model model1 = new Model("1", brand);
        Model model2 = new Model("1", brand);

        boolean result = model1.equals(model2);

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void should_not_be_equal_to_another_model_when_one_field_is_not_equal(){
        Brand brand = new ABrand().Build();
        Model model1 = new Model("1", brand);
        Model model2 = new Model("2", brand);

        boolean result = model1.equals(model2);

        assertThat(result).isEqualTo(false);
    }

    @Test
    public void should_not_be_equal_to_objects_that_are_not_base(){
        Model model = new Model("1", new ABrand().Build());

        boolean result = model.equals(new Object());

        assertThat(result).isEqualTo(false);
    }
}
