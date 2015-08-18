package com.actionagainsthunger.equiptracking.domain;

public class Model {
    public String id; // SATELLITE C-IPT
    public Brand brand;

    public Model(String _id, Brand _brand){
        this.id = _id;
        this.brand = _brand;
    }
}
