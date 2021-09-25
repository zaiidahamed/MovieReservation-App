package com.example.blueskycinema.Zaid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.blueskycinema.DB_Handler;
import com.example.blueskycinema.R;

import java.util.List;

public class displayBooking extends AppCompatActivity {

    RecyclerView recyclerView1;
    DB_Handler databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_booking);

        recyclerView1 = findViewById(R.id.recyclerView_new);
        databaseHelper = new DB_Handler(this);
        showRecord();
    }

    private void showRecord() {
        reservationListAdapter myAdapter = new reservationListAdapter(displayBooking.this, databaseHelper.getBookingList());
        recyclerView1.setAdapter(myAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showRecord();
    }
}