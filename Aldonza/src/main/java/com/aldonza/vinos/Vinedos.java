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
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

/**
 * Created by Miguel on 6/02/14.O no.
 */
public class Vinedos extends Activity {
	TabHost tabHost;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vinedos_screen);
        getActionBar().setTitle("");
        MyPageAdapter adapter = new MyPageAdapter();
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager1);
        viewPager.setAdapter(adapter);

        //---starts with the second page---
        viewPager.setCurrentItem(0);
        
        
        //tab
        tabHost=(TabHost)findViewById(android.R.id.tabhost);
        tabHost.setup();
      
        TabSpec spec1=tabHost.newTabSpec("Superficies y Variedades");
        spec1.setContent(R.id.Supervicies);
        spec1.setIndicator("Superficies y Variedades");
        
      
      
        TabSpec spec2=tabHost.newTabSpec("Entorno");
        spec2.setIndicator("Entorno");
        spec2.setContent(R.id.entorno);
      
      
        TabSpec spec3=tabHost.newTabSpec("Nuestra cosecha");
        spec3.setContent(R.id.cosecha);
        spec3.setIndicator("Nuestra cosecha");
        tabHost.addTab(spec1);
        tabHost.addTab(spec2);
        tabHost.addTab(spec3);
        
        //finaltab
    }
    public boolean onMenuItemSelected(int featureId,MenuItem item){
        int itemId = item.getItemId();
        switch(itemId){
            case android.R.id.home:
                Toast.makeText(this, "Has pulsado el Home", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
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
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.youtube.com/watch?v=U26vd2hnu5U"));
        startActivity(intent);
    }

}

