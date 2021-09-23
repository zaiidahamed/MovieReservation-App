package com.example.blueskycinema.Zaid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.blueskycinema.DB_Handler;
import com.example.blueskycinema.MainActivity;
import com.example.blueskycinema.R;

public class Summery extends AppCompatActivity {

    TextView print_date1, print_time1, print_tot1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summery);

        Intent newIntent = getIntent();
        String selected_date = newIntent.getStringExtra("SELECTED_DATE");
        String selected_time = newIntent.getStringExtra("SELECTED_TIME");
        String total_amount = newIntent.getStringExtra("TOTAL_AMOUNT");


        print_date1 = findViewById(R.id.print_date2);
        print_time1 = findViewById(R.id.print_time2);
        print_tot1 = findViewById(R.id.print_tot2);

        print_date1.setText(selected_date);
        print_time1.setText(selected_time);
        print_tot1.setText(total_amount);

    }

    public void confirmButton(View view){
        Intent newIntent = getIntent();
        String fullTicket = newIntent.getStringExtra("TOTAL_FULL_TICKETS");
        String boxTickets = newIntent.getStringExtra("TOTAL_BOX_TICKETS");

        DB_Handler db_handler = new DB_Handler(this);

        long val = db_handler.addBooking(fullTicket, boxTickets, print_date1.getText().toString(), print_time1.getText().toString(), print_tot1.getText().toString(), "m1");

        if(val > 0){
            setContentView(R.layout.activity_main);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

            Toast.makeText(this, "Booking created!!!", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Data not inserted!!!", Toast.LENGTH_SHORT).show();
        }
    }
}



//            setContentView(R.layout.activity_reserve_now);
//            Intent intent = new Intent(this, ReserveNowActivity.class);