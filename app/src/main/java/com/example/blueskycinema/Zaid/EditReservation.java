package com.example.blueskycinema.Zaid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.blueskycinema.DB_Handler;
import com.example.blueskycinema.MainActivity;
import com.example.blueskycinema.R;

import java.util.List;

public class EditReservation extends AppCompatActivity {
    
//    ImageView moviePoster1;
//    TextView movieName3, print_date2, print_time2, print_tot2;
//    RecyclerView recyclerView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_reservation);

////        moviePoster1 = findViewById(R.id.moviePoster1);
////        movieName3 = findViewById(R.id.movieName3);
////        print_date2 = findViewById(R.id.print_date2);
////        print_time2 = findViewById(R.id.print_time2);
////        print_tot2 = findViewById(R.id.print_tot2);
//
//        //recyclerView = findViewById(R.id.recyclerView);
////        recyclerView.setLayoutManager(new LinearLayoutManager(this));
////        recyclerView.setHasFixedSize(true);
////
//        DB_Handler db_handler = new DB_Handler(this);
//        List<bookingModel> bookingModels = db_handler.getBookingList();
//
//        if (bookingModels.size() > 0){
//            reservationListAdapter myAdapter = new reservationListAdapter(bookingModels,EditReservation.this);
//            recyclerView.setAdapter(myAdapter);
//        }else {
//            Toast.makeText(this, "There is no employee in the database", Toast.LENGTH_SHORT).show();
//        }
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//    }
//
//    //Edit details button
//    public void loadChangeDateActivity(View v){
//
//        //Create intent for next activity
//        setContentView(R.layout.activity_change_date);
//        Intent intent = new Intent(this, changeDate.class);
//
//
//        startActivity(intent);
//    }
//
//    //Delete booking button
//    public void deleteBooking(View v){
//
//        //delete booking
//
//
//
//        //Create intent for next activity
//        setContentView(R.layout.activity_main);
//        Intent intent = new Intent(this, MainActivity.class);
//
//        startActivity(intent);
//        Toast.makeText(this, "Booking Removed!", Toast.LENGTH_SHORT).show();
    }


}