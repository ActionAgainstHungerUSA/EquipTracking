package com.actionagainsthunger.equiptracking.domain;

import android.support.annotation.NonNull;

import com.actionagainsthunger.equiptracking.domain.administration.Purchase;
import com.actionagainsthunger.equiptracking.domain.location.Base;
import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.CloseableWrappedIterable;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

public class Equipment {
    @DatabaseField(id = true)
    private int id;

    @DatabaseField
    private String reference; // PD or IKD => 00020 or 9999

    @DatabaseField
    private String designation; // Laptop

    @DatabaseField(canBeNull = false, foreign = true, columnName = "family_id")
    private Family family; // LAP (laptop), QUA, HOU, COP, DES (Desktop)

    @DatabaseField(canBeNull = false, foreign = true, columnName = "model_id")
    private Model model;

    @DatabaseField
    private String serialNumber; // 5B144188K

    @ForeignCollectionField
    private ForeignCollection<Purchase> purchases;

    @DatabaseField(canBeNull = false, foreign = true, columnName = "base_id")
    private Base location;

    @DatabaseField
    private String condition; // good

    @DatabaseField
    private String status; // working

    @DatabaseField
    private String firstContractAllocation; // ZIA

    public Equipment(){
        // needed by ORMLite only
    }

    public Equipment(int _id, String _reference, String _designation, Family _family, Model _model, String _serialNumber, Base _location, String _condition, String _status, String _contract){
        this.id = _id;
        this.reference = _reference;
        this.designation = _designation;
        this.family = _family;
        this.model = _model;
        this.serialNumber = _serialNumber;
        this.location = _location;
        this.condition = _condition;
        this.status = _status;
        this.firstContractAllocation = _contract;
    }

    public Integer GetId() {
        return this.id;
    }

    public String GetReference(){
        return this.reference;
    }

    public String GetDesignation() {
        return this.designation;
    }

    public Family GetFamily(){
        return this.family;
    }

    public Model GetModel(){
        return this.model;
    }

    public String GetSerialNumber(){
        return this.serialNumber;
    }

    public Base GetLocation(){
        return this.location;
    }

    public String GetCondition(){
        return this.condition;
    }

    public String GetStatus(){
        return this.status;
    }

    public String GetFirstContractAllocation(){
        return this.firstContractAllocation;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Equipment))return false;
        Equipment equipment = (Equipment) obj;
        return (   this.id == equipment.GetId()
                && this.reference.equals(equipment.GetReference())
                && this.designation.equals(equipment.GetDesignation())
                && this.family.equals(equipment.GetFamily())
                && this.model.equals(equipment.GetModel())
                && this.serialNumber.equals(equipment.GetSerialNumber())
                && this.location.equals(equipment.GetLocation())
                && this.condition.equals(equipment.GetCondition())
                && this.status.equals(equipment.GetStatus())
                && this.firstContractAllocation.equals(equipment.GetFirstContractAllocation()));
    }
}
