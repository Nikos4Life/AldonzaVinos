package com.aldonza.vinos;


import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.widget.ListView;

public class MuestraLasPreferencias extends PreferenceActivity {

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);
        ListView lv = (ListView)findViewById(android.R.id.list);
        lv.setBackgroundColor(Color.BLACK);
    }
}
