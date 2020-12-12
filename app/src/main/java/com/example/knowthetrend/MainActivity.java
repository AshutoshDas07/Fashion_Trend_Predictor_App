package com.example.knowthetrend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout dLayout;
    Intent receivedintent;
    Fragment fragment;
    //Toolbar toolbar;
    private String[] activityTitles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //toolbar=findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        activityTitles=new String[]{"Men Fashion","Women Fashion","Top 10 Trending"};
        fragment=null;
        receivedintent=getIntent();
        int catnum=receivedintent.getIntExtra("catType",0);
        setNavigationDrawer(); // call method
        if(catnum==0){
            fragment=new MenFragment();
            //getSupportActionBar().setTitle(activityTitles[0]);
        }else if(catnum==1){
            fragment=new WomenFragment();
            //getSupportActionBar().setTitle(activityTitles[1]);
        }else if(catnum==2){
            fragment=new TTTFragment();
            //getSupportActionBar().setTitle(activityTitles[2]);
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment); // replace a Fragment with Frame Layout
        transaction.commit(); // commit the changes
        dLayout.closeDrawers(); // close the all open Drawer Views
    }
    private void setNavigationDrawer() {
        dLayout = (DrawerLayout) findViewById(R.id.drawer_layout); // initiate a DrawerLayout
        NavigationView navView = (NavigationView) findViewById(R.id.navigation); // initiate a Navigation View
        // implement setNavigationItemSelectedListener event on NavigationView
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment frag = null; // create a Fragment Object
                int itemId = item.getItemId(); // get selected menu item's id
                // check selected menu item's id and replace a Fragment Accordingly
                if (itemId == R.id.first) {
                    frag = new MenFragment();
                    //getSupportActionBar().setTitle(activityTitles[0]);
                } else if (itemId == R.id.second) {
                    frag = new WomenFragment();
                    //getSupportActionBar().setTitle(activityTitles[1]);
                } else if (itemId == R.id.third) {
                    frag = new TTTFragment();
                    //getSupportActionBar().setTitle(activityTitles[2]);
                }
                if (frag != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame, frag); // replace a Fragment with Frame Layout
                    transaction.commit(); // commit the changes
                    dLayout.closeDrawers(); // close the all open Drawer Views
                    return true;
                }
                return false;
            }
        });
    }
}

