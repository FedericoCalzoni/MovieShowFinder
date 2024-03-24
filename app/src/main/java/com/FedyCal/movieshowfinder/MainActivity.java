package com.FedyCal.movieshowfinder;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.FedyCal.movieshowfinder.databinding.ActivityMainBinding;

/**
 * In the main in the onCreate section the bottomNavigationView is initialized which allows us
 * to pass from one fragment to another.
 * The app consists of 3 fragments:
 * 1 home: recyclerview with output the lists received via TMDB api.
 * 2- search: I can search for a movie entered the string
 * 3- favorites: list with favorite items.
 *   The elements can be movie or series, and are shown in the same list.
 *
 * Besides the main there is another activity: ItemInformationActivity.
 * This is to show the details of the movie or series.
 */

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.FedyCal.movieshowfinder.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(binding.navView, navController);

    }
}