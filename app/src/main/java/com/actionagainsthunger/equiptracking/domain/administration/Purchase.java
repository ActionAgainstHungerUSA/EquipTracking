package com.actionagainsthunger.equiptracking.domain.administration;

import java.util.Currency;
import java.util.Date;

public class Purchase {
    private float purchasePrice;
    private Currency currency; //  ISO 4217
    private Date purchaseDate;
    private Supplier supplier;
    private String status; // New or 2nd hand
    private Organization property; // H3D, D3E, F1J, F1H, B2B, E2A, Z1C, ACF

    public Purchase(float _price, Currency _currency, Date _purchaseDate, Supplier _supplier, String _status, Organization _property){
        this.purchasePrice = _price;
        this.currency = _currency;
        this.purchaseDate = _purchaseDate;
        this.supplier = _supplier;
        this.status = _status;
        this.property = _property;
    }
}
