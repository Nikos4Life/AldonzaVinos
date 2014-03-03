package com.aldonza.vinos;


import android.os.Bundle;
import android.preference.PreferenceActivity;

public class MuestraLasPreferencias extends PreferenceActivity {

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);
    }
}
