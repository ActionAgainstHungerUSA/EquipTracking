package com.actionagainsthunger.equiptracking.domain.builders;

import com.actionagainsthunger.equiptracking.domain.EquipmentType;
import com.actionagainsthunger.equiptracking.domain.Family;

/*
    Class for test purpose only. Can't move anywhere because it is use by both androidTest (instrumented) and unit test
*/
public class AFamily {
    private String id = "LAP";
    private EquipmentType equipmentType = new AnEquipmentType().Build();

    public Family Build(){
        return new Family(id, equipmentType);
    }
}
