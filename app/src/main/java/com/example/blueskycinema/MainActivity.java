package com.example.blueskycinema;

import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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