package com.aldonza.vinos;


import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by Miguel on 6/02/14.
 */
public class NuestrosVinos extends Activity {
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.nuestros_vinos);
        getActionBar().setTitle("");
        AdapterNuestrosVinos adapter = new AdapterNuestrosVinos();
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPagerA2);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        
//        AyudanteDB ayudantebd = new AyudanteDB(this, null, 1);
//        ayudantebd.openDataBase();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_screen, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about) {
            
            Class<?> clase = null;
            try {
                clase = Class.forName("com.aldonza.vinos.Dialog");
                Intent intent = new Intent(this, clase);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (item.getItemId() == R.id.Preferencias) {
            
            Class<?> clase = null;
            try {
                clase = Class.forName("com.aldonza.vinos.MuestraLasPreferencias");
                Intent intent = new Intent(this, clase);
                startActivity(intent);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        if (item.getItemId() == R.id.cocerCita) {
            
            Class<?> clase = null;
            try {
                clase = Class.forName("com.aldonza.vinos.ConcertarCita");
                Intent intent = new Intent(this, clase);
                startActivity(intent);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        return false;

    }
    public void twitter(View v){
    	Intent intent = new Intent(Intent.ACTION_VIEW);
    	intent.setData(Uri.parse("https://twitter.com/AldonzaWines"));
    	startActivity(intent);
    }
    public void facebook(View v){
    	Intent intent = new Intent(Intent.ACTION_VIEW);
    	intent.setData(Uri.parse("https://www.facebook.com/aldonzawines"));
    	startActivity(intent);
    }
    public void youtube(View v){
//    	Intent intent = new Intent(Intent.ACTION_VIEW);
//    	intent.setData(Uri.parse("https://www.youtube.com/channel/UCbgjP5f05GQqAeg8b2O5xMQ"));
//    	startActivity(intent);
    	
    	Intent intent = new Intent(Intent.ACTION_SEARCH);
    	intent.setPackage("com.google.android.youtube");
    	//la cadena a buscar
    	intent.putExtra("query", "una ranita iba caminando");
    	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    	try
    	{
    	  startActivity(intent);
    	} 
    	catch (ActivityNotFoundException e)
    	{
    	  //la app no esta instalada, mostrar por ejemplo un AlertDialog
    	}
    }
//    public void getDatosDDBB()
//    {
//
//    }
//    public void enviar1(View v)
//    {
//    	Class<?> clase = null;
//		try 
//	    {
//			clase = Class.forName("com.aldonza.vinos.mostrardatoVino");
//	        Intent intent = new Intent(this,clase);
//	        intent.putExtra("str1", 1);
//	        startActivityForResult(intent,1);
//	    }
//		catch (ClassNotFoundException e) 
//		{
//			e.printStackTrace();
//		}
//    }
//    public void enviar2(View v)
//    {
//    	Class<?> clase = null;
//		try 
//	    {
//			clase = Class.forName("com.aldonza.vinos.MostrardatoVino");
//	        Intent intent = new Intent(this,clase);
//	        intent.putExtra("str2", 2);
//	        startActivityForResult(intent,1);
//	    }
//		catch (ClassNotFoundException e) 
//		{
//			e.printStackTrace();
//		}
//    }
//    public void enviar3(View v)
//    {
//    	Class<?> clase = null;
//		try 
//	    {
//			clase = Class.forName("com.aldonza.vinos.mostrardatoVino");
//	        Intent intent = new Intent(this,clase);
//	        intent.putExtra("str3", 3);
//	        startActivityForResult(intent,1);
//	    }
//		catch (ClassNotFoundException e) 
//		{
//			e.printStackTrace();
//		}
//    }
//    public void enviar4(View v)
//    {
//    	Class<?> clase = null;
//		try 
//	    {
//			clase = Class.forName("com.aldonza.vinos.mostrardatoVino");
//	        Intent intent = new Intent(this,clase);
//	        intent.putExtra("str4", 4);
//	        startActivityForResult(intent,1);
//	    }
//		catch (ClassNotFoundException e) 
//		{
//			e.printStackTrace();
//		}
//    }
    
}
