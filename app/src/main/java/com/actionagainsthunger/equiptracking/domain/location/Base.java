package com.actionagainsthunger.equiptracking.domain.location;

import com.j256.ormlite.field.DatabaseField;

public class Base {
    @DatabaseField(id = true)
    private String id; // LC NB

    @DatabaseField(canBeNull = false, foreign = true)
    private Country country; // KE

    public Base() {
        // needed by ORMLite only
    }

    public Base(String _id, Country _country) {
        this.id = _id;
        this.country = _country;
    }

    public String GetId(){
        return this.id;
    }

    public Country GetCountry(){
        return this.country;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Base))return false;
        Base base = (Base) obj;
        return (this.id == base.GetId() && this.country.equals(base.GetCountry()));
    }
}
