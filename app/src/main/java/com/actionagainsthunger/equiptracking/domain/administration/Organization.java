package com.actionagainsthunger.equiptracking.domain.administration;

import com.j256.ormlite.field.DatabaseField;

public class Organization {
    @DatabaseField(id = true)
    private String id; // H3D, D3E, F1J, F1H, B2B, E2A, Z1C, ACF

    public Organization() {
        // needed by ORMLite only
    }

    public Organization(String _id) {
        this.id = _id;
    }

    public String GetId(){
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Organization))return false;
        return (this.id == ((Organization) obj).GetId());
    }
}
