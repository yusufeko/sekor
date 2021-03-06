package com.example.ysfkp.sekor;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        onNavigationItemSelected(navigationView.getMenu().getItem(0));
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager mFragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();


        if (id == R.id.nav_inggris) {

            PremierFragment mPremierFragment = new PremierFragment();
            mFragmentManager.beginTransaction().replace(R.id.fl_contentMain, mPremierFragment).addToBackStack(null).commit();

        } else if (id == R.id.nav_spanyol) {

            LaligaFragment mLaligaFragment = new LaligaFragment();
            mFragmentManager.beginTransaction().replace(R.id.fl_contentMain, mLaligaFragment).addToBackStack(null).commit();

        } else if (id == R.id.nav_italia) {

            SerieAFragment mSerieAFragment = new SerieAFragment();
            mFragmentManager.beginTransaction().replace(R.id.fl_contentMain, mSerieAFragment).addToBackStack(null).commit();

        } else if (id == R.id.nav_jerman) {

            BundesligaFragment mBundesligaFragment = new BundesligaFragment();
            mFragmentManager.beginTransaction().replace(R.id.fl_contentMain, mBundesligaFragment).addToBackStack(null).commit();

        } else if (id == R.id.nav_perancis) {

            Ligue1Fragment mLigue1Fragment = new Ligue1Fragment();
            mFragmentManager.beginTransaction().replace(R.id.fl_contentMain, mLigue1Fragment).addToBackStack(null).commit();

        } else if (id == R.id.nav_about) {

            AboutFragment mAboutFragment = new AboutFragment();
            mFragmentManager.beginTransaction().replace(R.id.fl_contentMain, mAboutFragment).addToBackStack(null).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
