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
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.youtube.com/watch?v=U26vd2hnu5U"));
        startActivity(intent);
    }

    
}
