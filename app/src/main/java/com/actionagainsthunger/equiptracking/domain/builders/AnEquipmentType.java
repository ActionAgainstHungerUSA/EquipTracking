package com.actionagainsthunger.equiptracking.domain.builders;

import com.actionagainsthunger.equiptracking.domain.EquipmentType;

/*
    Class for test purpose only. Can't move anywhere because it is use by both androidTest (instrumented) and unit test
*/
public class AnEquipmentType {
    private String id = "HY";

    public EquipmentType Build(){
        return new EquipmentType(id);
    }
}
