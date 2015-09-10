package com.actionagainsthunger.equiptracking.infrastructure;

import com.actionagainsthunger.equiptracking.domain.Equipment;
import com.actionagainsthunger.equiptracking.domain.builders.*;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(AndroidJUnit4.class)
public class DatabaseHelperTest extends InstrumentationTestCase{

    private Equipment equipment;

    @Test
    public void should_create_database_for_saving_equipment_data()
    {
        RuntimeExceptionDao<Equipment, Integer> dao = getEquipmentDao();

        equipment = new AnEquipment().Build();
        dao.create(equipment);

        Equipment retrievedEquipment = dao.queryForId(equipment.GetId());

        assertThat(retrievedEquipment.equals(equipment));
    }

    @After
    public void TearDown(){
        RuntimeExceptionDao<Equipment, Integer> dao = getEquipmentDao();
        dao.delete(equipment);
    }

    private RuntimeExceptionDao<Equipment, Integer> getEquipmentDao() {
        Context context = InstrumentationRegistry.getTargetContext();

        DatabaseHelper databaseHelper = new DatabaseHelper(context);

        return databaseHelper.getEquipmentDao();
    }
}
