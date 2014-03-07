package com.aldonza.vinos;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * This shows how to add a map to a ViewPager. Note the use of
 * {@link android.view.ViewGroup#requestTransparentRegion(android.view.View)} to reduce jankiness.
 */
public class Bodega extends FragmentActivity {
	private MyAdapter mAdapter;
	private ViewPager mPager;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.la_bodega_screen);
        getActionBar().setTitle("");
		mAdapter = new MyAdapter(getSupportFragmentManager());

		mPager = (ViewPager) findViewById(R.id.viewPagerBodega);
		mPager.setAdapter(mAdapter);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());

		// This is required to avoid a black flash when the map is loaded. The
		// flash is due
		// to the use of a SurfaceView as the underlying view of the map.
		mPager.requestTransparentRegion(mPager);
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
	/** A simple fragment that displays a TextView. */
	public static class Instalaciones extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle bundle) {
			return inflater.inflate(R.layout.bodegainstalaciones, container,
					false);
		}
	}

	/** A simple fragment that displays a TextView. */
	public static class Elaboracion extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle bundle) {
			View v = inflater.inflate(R.layout.bodegaelaboracion, container,
					false);
			return v;
		}
	}

	public static class Mapa extends Fragment {
		private static final int MAP_TYPE_SATELLITE = 2;
		final LatLng HAMBURG = new LatLng(53.558, 9.927);
		final LatLng KIEL = new LatLng(53.551, 9.993);
		GoogleMap map;

		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View v = inflater.inflate(R.layout.bodegaubicacion, null, false);
//			FragmentTransaction ft = getFragmentManager().beginTransaction();
//
//			map = ((SupportMapFragment) getFragmentManager().findFragmentById(
//					R.id.map)).getMap();
//
//
//			ft.commit();
//
//			Marker hamburg = map.addMarker(new MarkerOptions()
//					.position(HAMBURG).title("Hamburg"));
//			/*
//			 * Marker kiel = map.addMarker(new MarkerOptions() .position(KIEL)
//			 * .title("Kiel") .snippet("Kiel is cool")
//			 * .icon(BitmapDescriptorFactory
//			 * .fromResource(R.drawable.ic_launcher)));
//			 */
//			// Move the camera instantly to hamburg with a zoom of 15.
//			map.moveCamera(CameraUpdateFactory.newLatLngZoom(HAMBURG, 15));
//
//			// Zoom in, animating the camera.
//			map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
//			*/
			map = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
	        map.setMapType(MAP_TYPE_SATELLITE);

	        LatLng Aldonza = new LatLng(38.9943, -2.41438);

	        map.setMyLocationEnabled(true);
	        map.moveCamera(CameraUpdateFactory.newLatLngZoom(Aldonza, 13));

	        map.addMarker(new MarkerOptions()
	                .title("Aldonza")
	                .snippet("Vinos")
	                .position(Aldonza).icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
			return v;
		}

		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);

		}
	}

	/**
	 * A simple FragmentPagerAdapter that returns two TextFragment and a
	 * SupportMapFragment.
	 */
	public static class MyAdapter extends FragmentPagerAdapter {
		public MyAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				return new Instalaciones();
			case 1:
				return new Elaboracion();
			case 2:
				return new Mapa();
			default:
				return null;
			}
		}
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