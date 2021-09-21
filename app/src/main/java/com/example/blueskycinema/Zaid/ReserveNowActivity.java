package com.example.blueskycinema.Zaid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.blueskycinema.R;

import java.util.Calendar;

public class ReserveNowActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_now);

        //calendar implementation

        ImageView ivCalender = findViewById(R.id.ivCalender);
        TextView tv_showDate = findViewById(R.id.tv_showDate);


        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        ivCalender.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(ReserveNowActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tv_showDate.setText(year + " - " + (month + 1) + " - " + dayOfMonth);
                    }
                }, mYear, mMonth, mDay);

                datePickerDialog.show();
            }
        });
        //end of Calender



    }

    //continue button
    public void loadActivityTickets(View v){
        Intent intent = new Intent(this, Tickets.class);

        startActivity(intent);
    }
}