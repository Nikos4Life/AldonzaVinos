package com.aldonza.vinos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MostrardorVinoHBBDD extends SQLiteOpenHelper {
    private static final String DATABAS_NAME = "BBDD_Vinos.db";

    public MostrardorVinoHBBDD(Context context) {
        super(context, DATABAS_NAME, null, 1);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }

}
