package com.actionagainsthunger.equiptracking.domain;

public class Family {
    private String id; // LAP (laptop), QUA, HOU, COP, DES (Desktop)
    private EquipmentType type;

    public Family(String _id, EquipmentType _type) {
        this.id = _id;
        this.type = _type;
    }
}
