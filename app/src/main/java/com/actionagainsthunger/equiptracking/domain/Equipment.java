package com.actionagainsthunger.equiptracking.domain;

import com.actionagainsthunger.equiptracking.domain.administration.Purchase;
import com.actionagainsthunger.equiptracking.domain.location.Base;

public class Equipment {
    private int id;
    private String reference; // PD or IKD => 00020 or 9999
    private String designation; // Laptop
    private Family family; // LAP (laptop), QUA, HOU, COP, DES (Desktop)
    private Model model;
    private String serialNumber; // 5B144188K
    private Purchase purchase;
    private Base location;
    private String condition; // good
    private String status; // working
    private String firstContractAllocation; // ZIA

    public Equipment(int _id, String _reference, String _designation, Family _family, Model _model, String _serialNumber, Purchase _purchase, Base _location, String _condition, String _status, String _contract){
        this.id = _id;
        this.reference = _reference;
        this.designation = _designation;
        this.family = _family;
        this.model = _model;
        this.serialNumber = _serialNumber;
        this.purchase = _purchase;
        this.location = _location;
        this.condition = _condition;
        this.status = _status;
        this.firstContractAllocation = _contract;
    }
}
