package com.actionagainsthunger.equiptracking.domain.builders;

import com.actionagainsthunger.equiptracking.domain.Equipment;
import com.actionagainsthunger.equiptracking.domain.administration.Organization;
import com.actionagainsthunger.equiptracking.domain.administration.Purchase;
import com.actionagainsthunger.equiptracking.domain.administration.Supplier;

import java.util.Date;

/*
    Class for test purpose only. Can't move anywhere because it is use by both androidTest (instrumented) and unit test
*/
public class APurchase {
    private Equipment equipment;
    private float purchasePrice = 300;
    private String currency = "EUR";
    private Date purchaseDate = new Date(1440944897);
    private Supplier supplier = new ASupplier().Build();
    private String status = "New";
    private Organization organization = new AnOrganization().Build();

    public APurchase Of(Equipment _equipment){
        this.equipment = _equipment;
        return this;
    }

    public Purchase Build(){
        return new Purchase(equipment, purchasePrice, currency, purchaseDate, supplier, status, organization);
    }
}
