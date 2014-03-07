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

/**
 * This shows how to add a map to a ViewPager. Note the use of
 * {@link android.view.ViewGroup#requestTransparentRegion(android.view.View)} to reduce jankiness.
 */
public class Aldonza extends FragmentActivity {
    private MyAdapter mAdapter;
    private ViewPager mPager;
    private static ViewPager mViewPager;
    private static ViewPager mViewPagerPisces;
    private static ViewPager mViewPagerNav;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aldonza_screen);
        getActionBar().setTitle("");
        getActionBar().hide();
        mAdapter = new MyAdapter(getSupportFragmentManager());

        mPager = (ViewPager) findViewById(R.id.viewPagerAldonza);
        mPager.setAdapter(mAdapter);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());

//        This is required to avoid a black flash when the map is loaded. The
//        flash is due
//        to the use of a SurfaceView as the underlying view of the map.
//        mPager.requestTransparentRegion(mPager);
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
    //**************************************************
    /*
    *Metodos siguiente y atras para cambiar de vino
    * NOTA: solo funciona con el vino verde
     */
    public  int getItem(int i) {
        return mViewPager.getCurrentItem() + i;
    }
    public  void siguientealdonza(View view) {
        mViewPager.setCurrentItem(getItem(+1), true); //getItem(-1) for previous
    }
    public  void atrasaldonza(View view) {
        mViewPager.setCurrentItem(getItem(-1), true);
    }
    public  int getItempisces(int i) {
        return mViewPagerPisces.getCurrentItem() + i;
    }
    public  void siguientepisces(View view) {
        mViewPagerPisces.setCurrentItem(getItempisces(+1), true); //getItem(-1) for previous
    }
    public  void atraspisces(View view) {
        mViewPagerPisces.setCurrentItem(getItempisces(-1), true);
    }
    public  int getItemnav(int i) {
        return mViewPagerNav.getCurrentItem() + i;
    }
    public  void siguientenav(View view) {
        mViewPagerNav.setCurrentItem(getItemnav(+1), true); //getItem(-1) for previous
    }
    public  void atrasnav(View view) {
        mViewPagerNav.setCurrentItem(getItemnav(-1), true);
    }
    //**************************************************
    /** A simple fragment that displays a TextView. */
    public static class aSeleccion extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle bundle) {
            return inflater.inflate(R.layout.aldonzaseleccion, container,
                    false);
        }
        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            MyPageAdapterPremios adapter = new MyPageAdapterPremios();
            adapter.setN(4);
            mViewPager = (ViewPager) view.findViewById(R.id.viewPagerPremios);
            mViewPager.setAdapter(adapter);
        }
    }

    /** A simple fragment that displays a TextView. */
    public static class pisces extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle bundle) {
            View v = inflater.inflate(R.layout.aldonzapisces, container,
                    false);
            return v;
        }
        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            MyPageAdapterPremios adapter = new MyPageAdapterPremios();
            adapter.setN(6);
            mViewPagerPisces = (ViewPager) view.findViewById(R.id.viewPagerPisces);
            mViewPagerPisces.setAdapter(adapter);
        }
    }

    public static class Navamarin extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle bundle) {
            View v = inflater.inflate(R.layout.aldonzanavamarin, container,
                    false);
            return v;
        }
        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            MyPageAdapterPremios adapter = new MyPageAdapterPremios();
            adapter.setN(6);
            mViewPagerNav = (ViewPager) view.findViewById(R.id.viewPagerNav);
            mViewPagerNav.setAdapter(adapter);
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
                    return new aSeleccion();
                case 1:
                    return new pisces();
                case 2:
                    return new Navamarin();
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
        startActivity(intent);    }
}