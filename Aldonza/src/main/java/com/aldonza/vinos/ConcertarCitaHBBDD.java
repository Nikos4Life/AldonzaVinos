package com.aldonza.vinos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ConcertarCitaHBBDD extends SQLiteOpenHelper
{
	private static final String DATABAS_NAME="BBDD_Vinos2.db";
	private String tag="CORRECTO";

	private String tabla="CREATE TABLE citas(DNI INTEGER PRYMARY KEY,nombre TEXT,numAsistentes INTEGER,pref TEXT)";
	
	public ConcertarCitaHBBDD(Context context)
	{
		super(context, DATABAS_NAME,null,1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		// TODO Auto-generated method stub
		db.execSQL(tabla);
		Log.d(tag,"tabla Creada");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXIST citas");
		db.execSQL(tabla);
	}
}

