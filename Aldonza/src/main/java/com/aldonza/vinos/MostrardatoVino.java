package com.aldonza.vinos;


import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class MostrardatoVino extends Activity {

    TextView txt;
    TextView txt1;
    TextView txt2;
    TextView txt3;
    TextView txt4;
    TextView txt5;
    TextView txt6;
    TextView txt7;
    TextView txt8;
    TextView txt9;
    TextView txt10;

    MostrardorVinoHBBDD obj1 = new MostrardorVinoHBBDD(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrardato_vino);

        int ID = getIntent().getIntExtra("str", 0);

        txt1 = (TextView) findViewById(R.id.text1);
        txt2 = (TextView) findViewById(R.id.text2);
        txt3 = (TextView) findViewById(R.id.text3);
//		txt4=(TextView)findViewById(R.id.text4);
//		txt5=(TextView)findViewById(R.id.text5);
//		txt6=(TextView)findViewById(R.id.text6);
//		txt7=(TextView)findViewById(R.id.text7);
//		txt8=(TextView)findViewById(R.id.text8);
//		txt9=(TextView)findViewById(R.id.text9);
//		txt10=(TextView)findViewById(R.id.text10);


        SQLiteDatabase db = obj1.getWritableDatabase();
        Cursor fila = db.rawQuery("SELECT tV,tU,presentacion FROM VINOS WHERE ID=" + ID, null);
        txt1.setText(fila.getString(1));
        txt2.setText(fila.getString(2));
        txt3.setText(fila.getString(3));
//			txt4.setText(fila.getString(4));
//			txt5.setText(fila.getString(5));
//			txt6.setText(fila.getString(6));
//			txt7.setText(fila.getString(7));
//			txt8.setText(fila.getString(8));
//			txt9.setText(fila.getString(9));
//			txt10.setText(fila.getString(10));
        //,graduacion,eleboracion,gastronomia,servicio,produccion,notas,recomendacion

        db.close();
    }
/*
    @Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mostrardato_vino, menu);
		
		
		
		return true;
	}
*/
}
