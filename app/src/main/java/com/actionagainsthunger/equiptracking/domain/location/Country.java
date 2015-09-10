package com.actionagainsthunger.equiptracking.domain.location;

import com.j256.ormlite.field.DatabaseField;

public class Country {
    @DatabaseField(id = true)
    private String id; // KE

    public Country (){
        // needed by ORMLite only
    }

    public Country(String _id){
        this.id = _id;
    }

    public String GetId(){
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Country))return false;
        return (this.id == ((Country) obj).GetId());
    }
}
