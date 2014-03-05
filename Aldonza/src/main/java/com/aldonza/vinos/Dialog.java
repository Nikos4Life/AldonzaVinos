package com.aldonza.vinos;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class Dialog extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_dialog);
		
		TextView tvc = (TextView) findViewById(R.id.infoTV);
				
		//lectura assets
		AssetManager assetManager = getAssets();
		//definimos le inputStream
		InputStream input = null;
		//Utilizaremos un try y catch para tratar posibles excepciones
		try{
			input = assetManager.open("Aldonza/assets/about/aboutUs.txt");
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			byte[] bytes = new byte[4096];
			int len = 0;
			while((len = input.read(bytes))>0){
				byteStream.write(bytes,0,len);
			}
			String text = new String(byteStream.toByteArray(),"UTF-8");
			tvc.setText(text);
		}catch (IOException e){
			tvc.setText("No se pudo cargar el carchivo");
		} finally{
			if(input != null)
				try{
					input.close();
				}catch (IOException e){
					tvc.setText("No se pudo cargar el archivo");
				}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dialog, menu);
		return true;
	}
	public void volver(View v){
        finish();
    }
	public void llamar(View v){
		Intent i = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:902232350"));
		startActivity(i);
	}
}
