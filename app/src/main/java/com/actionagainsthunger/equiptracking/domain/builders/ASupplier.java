package com.actionagainsthunger.equiptracking.domain.builders;

import com.actionagainsthunger.equiptracking.domain.administration.Supplier;

/*
    Class for test purpose only. Can't move anywhere because it is use by both androidTest (instrumented) and unit test
*/
public class ASupplier {
    private String id = "Bard Enterprises";

    public Supplier Build(){
        return new Supplier(id);
    }
}
