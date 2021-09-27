package com.example.blueskycinema;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import android.app.DatePickerDialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;


import com.example.blueskycinema.Hasith.Adapter;
import com.example.blueskycinema.Hasith.Login;
import com.example.blueskycinema.Hasith.UserHome;
import com.example.blueskycinema.Hasith.add_movies;
import com.example.blueskycinema.Hasith.add_movies_2;
import com.example.blueskycinema.Hasith.displayMovies;
import com.example.blueskycinema.Hasith.startup;
import com.example.blueskycinema.Zaid.ReserveNowActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

import com.example.blueskycinema.Imasha.PostReview;
import com.example.blueskycinema.Imasha.TheaterRev;
import com.example.blueskycinema.Zaid.ReserveNowActivity;
import com.example.blueskycinema.Zaid.displayBooking;


public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


    }

    public void startup (View view){
        setContentView(R.layout.login);
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void loadAddMovies (View view){
        setContentView(R.layout.add_movies);
        Intent intent = new Intent(this, add_movies.class);

        setContentView(R.layout.activity_main);


    }

    public void loadReserveActivity(View view){
        setContentView(R.layout.activity_reserve_now);


        Intent intent = new Intent(this, ReserveNowActivity.class);
        startActivity(intent);
    }
    public void loadReview (View view){
        setContentView(R.layout.writereview);
        Intent intent = new Intent(this, PostReview.class);
        startActivity(intent);
    }

    public void loadReasevations(View view){
        setContentView(R.layout.activity_display_booking);

        Intent intent = new Intent(this, displayBooking.class);

        startActivity(intent);
    }



}