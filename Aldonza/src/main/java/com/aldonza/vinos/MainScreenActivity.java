package com.aldonza.vinos;



import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainScreenActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);


        boolean s = pref.getBoolean("sonido", false);

        MediaPlayer mediaPlayer;
        mediaPlayer = MediaPlayer.create(this, R.raw.cancion);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(100, 100);
        if (s == true) {
            mediaPlayer.start();
        }
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

    public void pulsar(View view) {
        Class<?> clase = null;
        switch (view.getId()) {
            case R.id.textViewAldonza:
                try {
                    clase = Class.forName("com.aldonza.vinos.Aldonza");
                    Intent intent = new Intent(this, clase);
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.textViewVinedos:
                try {
                    clase = Class.forName("com.aldonza.vinos.Vinedos");
                    Intent intent = new Intent(this, clase);
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.textViewBodega:
                try {
                    clase = Class.forName("com.aldonza.vinos.Bodega");
                    Intent intent = new Intent(this, clase);
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.textViewNVinos:
                try {
                    clase = Class.forName("com.aldonza.vinos.NuestrosVinos");
                    Intent intent = new Intent(this, clase);
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.textViewAPlaces:
                try {
                    clase = Class.forName("com.aldonza.vinos.AldonzaPlaces");
                    Intent intent = new Intent(this, clase);
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }


}
