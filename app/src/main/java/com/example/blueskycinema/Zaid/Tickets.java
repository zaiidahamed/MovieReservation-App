package com.example.blueskycinema.Zaid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.blueskycinema.R;

public class Tickets extends AppCompatActivity {

    //No of seats in the theater
    public static final int NO_OF_SEATS = 100;
    public static final int NO_OF_BOX_SEATS = 105;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);


    }
}