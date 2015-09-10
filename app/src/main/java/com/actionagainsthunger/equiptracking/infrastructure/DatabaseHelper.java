package com.actionagainsthunger.equiptracking.infrastructure;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.actionagainsthunger.equiptracking.R;
import com.actionagainsthunger.equiptracking.domain.*;
import com.actionagainsthunger.equiptracking.domain.administration.*;
import com.actionagainsthunger.equiptracking.domain.location.*;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.File;
import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "equipTracking.db";
    private static final int DATABASE_VERSION = 1;

    private RuntimeExceptionDao<Equipment, Integer> equipmentRuntimeDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    DatabaseHelper(Context context, File configFile){
        super(context, DATABASE_NAME, null, DATABASE_VERSION, configFile);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, EquipmentType.class);
            TableUtils.createTable(connectionSource, Family.class);
            TableUtils.createTable(connectionSource, Brand.class);
            TableUtils.createTable(connectionSource, Model.class);
            TableUtils.createTable(connectionSource, Supplier.class);
            TableUtils.createTable(connectionSource, Organization.class);
            TableUtils.createTable(connectionSource, Purchase.class);
            TableUtils.createTable(connectionSource, Country.class);
            TableUtils.createTable(connectionSource, Base.class);
            TableUtils.createTable(connectionSource, Equipment.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

    }

    public RuntimeExceptionDao<Equipment, Integer> getEquipmentDao() {
        if (equipmentRuntimeDao == null) {
            equipmentRuntimeDao = getRuntimeExceptionDao(Equipment.class);
        }
        return equipmentRuntimeDao;
    }

}
