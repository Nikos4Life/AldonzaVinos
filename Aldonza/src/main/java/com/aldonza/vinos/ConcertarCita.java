package com.aldonza.vinos;


import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ConcertarCita extends Activity 
{
	private EditText DNI;
	private EditText nombre;
	private EditText numAsistentes;
	private EditText pref;	
	
	ConcertarCitaHBBDD obj1 = new ConcertarCitaHBBDD(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.pruebacita);
		//setContentView(R.layout.activity_concertar_cita);
		Toast.makeText(this, "ConccertarCita", Toast.LENGTH_LONG).show();
		
		DNI = (EditText)findViewById(R.id.editText1);
		nombre = (EditText)findViewById(R.id.editText2);
		numAsistentes = (EditText)findViewById(R.id.editText3);
		pref = (EditText)findViewById(R.id.editText4);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.concertar_cita, menu);
		return true;
	}
	public void alta(View v)
	{
		SQLiteDatabase db=obj1.getWritableDatabase();
		
		String Dni=DNI.getText().toString();
		String Nombre=nombre.getText().toString();
		String Num=numAsistentes.getText().toString();
		String Pref=pref.getText().toString();	
		
		ContentValues reg = new ContentValues();
		
		reg.put("DNI", Dni);
		reg.put("nombre", Nombre);
		reg.put("numAsistentes", Num);
		reg.put("pref", Pref);
		db.insert("citas", null, reg);
		db.close();
		
		DNI.setText("");
		nombre.setText("");
		numAsistentes.setText("");
		pref.setText("");
		
		Toast.makeText(this, "Cita concertada"+Dni+Nombre+Num+Pref, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Cita");//se usará por ejemplo para email
        intent.putExtra(Intent.EXTRA_TEXT, "DNI: "+Dni+" Nombre: "+Nombre+" Asistentes: "+Num+" Hora: "+Pref);
        startActivity(Intent.createChooser(intent, "Compartir usando"));
	}
	
	public void consulta(View v)
	{
		SQLiteDatabase db=obj1.getWritableDatabase();
		String Dni=DNI.getText().toString();
		Cursor fila=db.rawQuery("SELECT DNI, nombre,numAsistentes,pref FROM citas WHERE DNI='"+Dni+"'",null);
		
		if(fila.moveToFirst())
		{
			DNI.setText(fila.getString(0));
			nombre.setText(fila.getString(1));
			numAsistentes.setText(fila.getString(2));
			pref.setText(fila.getString(3));
		}
		else
		{
			Toast.makeText(this, "Cita no encontrada", Toast.LENGTH_SHORT).show();
		}
		db.close();
	}
	
	public void baja(View v)
	{
		SQLiteDatabase db=obj1.getWritableDatabase();
		String Dni=DNI.getText().toString();
		int borrar=db.delete("citas", "DNI ='"+Dni+"'", null);
		db.close();		
		
		DNI.setText("");
		nombre.setText("");
		numAsistentes.setText("");
		pref.setText("");
		
		if(borrar==1)
		{
			Toast.makeText(this, "Cita anulada", Toast.LENGTH_SHORT).show();
		}
		else
		{
			Toast.makeText(this, "Cita no encontrada", Toast.LENGTH_SHORT).show();
		}
		db.close();
	}
}
