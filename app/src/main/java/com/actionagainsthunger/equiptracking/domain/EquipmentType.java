package com.actionagainsthunger.equiptracking.domain;

import com.j256.ormlite.field.DatabaseField;

public class EquipmentType {
    @DatabaseField(id = true)
    private String id; // HY (hygiene), LO, OF

    public EquipmentType(){
        // needed by ORMLite only
    }

    public EquipmentType(String _id){
        this.id = _id;
    }

    public String GetId(){
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof EquipmentType))return false;
        return (this.id == ((EquipmentType) obj).GetId());
    }
}
