package com.actionagainsthunger.equiptracking.domain.builders;

import com.actionagainsthunger.equiptracking.domain.Brand;

/*
    Class for test purpose only. Can't move anywhere because it is use by both androidTest (instrumented) and unit test
*/
public class ABrand {
    private String id = "Toshiba";

    public Brand Build()
    {
        return new Brand(id);
    }
}
