package com.actionagainsthunger.equiptracking.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EquipmentTypeTest {
    @Test
    public void should_be_equal_to_another_equipment_type_when_all_fields_are_equals(){
        EquipmentType equipmentType1 = new EquipmentType("1");
        EquipmentType equipmentType2 = new EquipmentType("1");

        boolean result = equipmentType1.equals(equipmentType2);

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void should_not_be_equal_to_another_equipment_type_when_one_field_is_not_equal(){
        EquipmentType equipmentType1 = new EquipmentType("1");
        EquipmentType equipmentType2 = new EquipmentType("2");

        boolean result = equipmentType1.equals(equipmentType2);

        assertThat(result).isEqualTo(false);
    }

    @Test
    public void should_not_be_equal_to_objects_that_are_not_equipment_type(){
        EquipmentType equipmentType = new EquipmentType("1");

        boolean result = equipmentType.equals(new Object());

        assertThat(result).isEqualTo(false);
    }
}
