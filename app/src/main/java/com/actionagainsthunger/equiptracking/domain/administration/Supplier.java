package com.actionagainsthunger.equiptracking.domain.administration;

import com.j256.ormlite.field.DatabaseField;

public class Supplier {
    @DatabaseField(id = true)
    private String id;

    public Supplier () {
        // needed by ORMLite only
    }

    public Supplier(String _id){
        this.id = _id;
    }

    public String GetId(){
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Supplier))return false;
        return (this.id == ((Supplier) obj).GetId());
    }
}
