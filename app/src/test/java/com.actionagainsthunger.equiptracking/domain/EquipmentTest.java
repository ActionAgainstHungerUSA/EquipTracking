package com.actionagainsthunger.equiptracking.domain;

import com.actionagainsthunger.equiptracking.domain.builders.*;
import com.actionagainsthunger.equiptracking.domain.location.Base;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EquipmentTest {
    @Test
    public void should_be_equal_to_another_equipment_when_all_fields_are_equals(){
        Family family = new AFamily().Build();
        Model model = new AModel().Build();
        Base location = new ABase().Build();

        Equipment equipment1 = new Equipment(1, "ref", "laptop", family, model, "123X", location, "good", "new", "ACF");
        Equipment equipment2 = new Equipment(1, "ref", "laptop", family, model, "123X", location, "good", "new", "ACF");

        boolean result = equipment1.equals(equipment2);

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void should_not_be_equal_to_another_equipment_when_one_field_is_not_equal(){
        Family family = new AFamily().Build();
        Model model = new AModel().Build();
        Base location = new ABase().Build();

        Equipment equipment1 = new Equipment(1, "ref1", "laptop", family, model, "123X", location, "good", "new", "ACF");
        Equipment equipment2 = new Equipment(1, "ref2", "laptop", family, model, "123X", location, "good", "new", "ACF");

        boolean result = equipment1.equals(equipment2);

        assertThat(result).isEqualTo(false);
    }

    @Test
    public void should_not_be_equal_to_objects_that_are_not_base(){
        Family family = new AFamily().Build();
        Model model = new AModel().Build();
        Base location = new ABase().Build();

        Equipment equipment = new Equipment(1, "ref1", "laptop", family, model, "123X", location, "good", "new", "ACF");

        boolean result = equipment.equals(new Object());

        assertThat(result).isEqualTo(false);
    }
}
