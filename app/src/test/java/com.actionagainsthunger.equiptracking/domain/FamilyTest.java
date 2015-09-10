package com.actionagainsthunger.equiptracking.domain;

import com.actionagainsthunger.equiptracking.domain.builders.ABrand;
import com.actionagainsthunger.equiptracking.domain.builders.AnEquipmentType;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FamilyTest {
    @Test
    public void should_be_equal_to_another_family_when_all_fields_are_equals(){
        EquipmentType equipmentType = new AnEquipmentType().Build();
        Family family1 = new Family("1", equipmentType);
        Family family2 = new Family("1", equipmentType);

        boolean result = family1.equals(family2);

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void should_not_be_equal_to_another_family_when_one_field_is_not_equal(){
        EquipmentType equipmentType = new AnEquipmentType().Build();
        Family family1 = new Family("1", equipmentType);
        Family family2 = new Family("2", equipmentType);

        boolean result = family1.equals(family2);

        assertThat(result).isEqualTo(false);
    }

    @Test
    public void should_not_be_equal_to_objects_that_are_not_base(){
        Family family = new Family("1", new AnEquipmentType().Build());

        boolean result = family.equals(new Object());

        assertThat(result).isEqualTo(false);
    }
}

