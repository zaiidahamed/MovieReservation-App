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

//        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView1.setHasFixedSize(true);

//        if (bookingModels.size() > 0){
//            reservationListAdapter myAdapter = new reservationListAdapter(bookingModels,displayBooking.this);
//            recyclerView1.setAdapter(myAdapter);
//        }else {
//            Toast.makeText(this, "There is no employee in the database", Toast.LENGTH_SHORT).show();
//        }

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