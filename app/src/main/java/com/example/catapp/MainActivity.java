package com.example.catapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FavouritesRecyclerFragment.OnFragmentInteractionListener {
    public static ArrayList<Favourites> favouritesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        favouritesList = new ArrayList<Favourites>();


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


//fragment switcher resource https://www.youtube.com/watch?v=tPV8xA7m-iw&t=313s

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CatRecyclerFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()) {
                        case R.id.nav_cat:
                            selectedFragment = new CatRecyclerFragment();
                            break;

                            case R.id.nav_favourites:
                                selectedFragment = new FavouritesRecyclerFragment();
                                break;
                        }


                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                selectedFragment).commit();


                        return true;

                    }
                };



    public void showCoolMessage(String string) {
        Toast.makeText(this, "Meow, Welcome!", Toast.LENGTH_SHORT).show();


    }


    @Override
    public void onFragmentInteraction(String string) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}