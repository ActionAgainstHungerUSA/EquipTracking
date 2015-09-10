package com.actionagainsthunger.equiptracking.domain;

import com.j256.ormlite.field.DatabaseField;

public class Model {
    @DatabaseField(id = true)
    private String id; // SATELLITE C-IPT

    @DatabaseField(canBeNull = false, foreign = true)
    private Brand brand;

    public Model(){
        // needed by ORMLite only
    }

    public Model(String _id, Brand _brand){
        this.id = _id;
        this.brand = _brand;
    }

    public String GetId(){
        return this.id;
    }

    public Brand GetBrand(){
        return this.brand;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Model))return false;
        Model model = (Model) obj;
        return (this.id == model.GetId() && this.brand.equals(model.GetBrand()));
    }
}
