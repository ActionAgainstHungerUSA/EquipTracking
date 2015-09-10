package com.actionagainsthunger.equiptracking.domain;

import com.j256.ormlite.field.DatabaseField;

public class Family {
    @DatabaseField(id = true)
    private String id; // LAP (laptop), QUA, HOU, COP, DES (Desktop)

    @DatabaseField(canBeNull = false, foreign = true)
    private EquipmentType type;

    public Family() {
        // needed by ORMLite only
    }

    public Family(String _id, EquipmentType _type) {
        this.id = _id;
        this.type = _type;
    }

    public String GetId(){
        return this.id;
    }

    public EquipmentType GetType(){
        return this.type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Family))return false;
        Family family = (Family) obj;
        return (this.id == family.GetId() && this.type.equals(family.GetType()));
    }

}
