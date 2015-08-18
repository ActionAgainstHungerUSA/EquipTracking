package com.actionagainsthunger.equiptracking.domain.location;

public class Base {
    private String id; // LC NB
    private Country country; // KE

    public Base(String _id, Country _country) {
        this.id = _id;
        this.country = _country;
    }
}
