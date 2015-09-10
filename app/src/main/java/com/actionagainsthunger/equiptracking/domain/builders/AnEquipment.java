package com.actionagainsthunger.equiptracking.domain.builders;

import com.actionagainsthunger.equiptracking.domain.Equipment;
import com.actionagainsthunger.equiptracking.domain.Family;
import com.actionagainsthunger.equiptracking.domain.Model;
import com.actionagainsthunger.equiptracking.domain.location.Base;

/*
    Class for test purpose only. Can't move anywhere because it is use by both androidTest (instrumented) and unit test
*/
public class AnEquipment {
    private int id = 1;
    private String reference = "00020";
    private String designation = "Laptop";
    private Family family = new AFamily().Build();
    private Model model = new AModel().Build();
    private String serialNumber = "5B144188K";
    private Base location = new ABase().Build();
    private String condition = "good";
    private String status = "working";
    private String firstContractAllocation = "ZIA";

    public Equipment Build(){
        Equipment equipment = new Equipment(id, reference, designation, family, model, serialNumber, location, condition, status, firstContractAllocation);
        //equipment.AddPurchaseEvent(new APurchase().Of(equipment).Build());
        return equipment;
    }

}
