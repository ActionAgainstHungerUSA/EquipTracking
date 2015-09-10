package com.actionagainsthunger.equiptracking.domain;

import com.j256.ormlite.field.DatabaseField;

public class Brand {
    @DatabaseField(id = true)
    private String id; //Toshiba

    public Brand () {
        // needed by ORMLite only
    }

    public Brand(String _id) {
        this.id = _id;
    }

    public String GetId(){
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Brand))return false;
        return (this.id == ((Brand) obj).GetId());
    }
}
