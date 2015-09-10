package com.actionagainsthunger.equiptracking.domain.administration;

import com.actionagainsthunger.equiptracking.domain.Equipment;
import com.j256.ormlite.field.DatabaseField;

import java.util.Currency;
import java.util.Date;

public class Purchase {
    @DatabaseField(canBeNull = false, foreign = true)
    Equipment equipment;

    @DatabaseField
    private float purchasePrice;

    @DatabaseField
    private String currency; //  ISO 4217

    @DatabaseField
    private Date purchaseDate;

    @DatabaseField(canBeNull = false, foreign = true)
    private Supplier supplier;

    @DatabaseField
    private String status; // New or 2nd hand

    @DatabaseField(canBeNull = false, foreign = true)
    private Organization property; // H3D, D3E, F1J, F1H, B2B, E2A, Z1C, ACF

    public Purchase() {
        // needed by ORMLite only
    }

    public Purchase(Equipment _equipment, float _price, String _currency, Date _purchaseDate, Supplier _supplier, String _status, Organization _property){
        this.equipment = _equipment;
        this.purchasePrice = _price;
        this.currency = _currency;
        this.purchaseDate = _purchaseDate;
        this.supplier = _supplier;
        this.status = _status;
        this.property = _property;
    }
}
