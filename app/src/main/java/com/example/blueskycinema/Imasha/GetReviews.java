package com.example.blueskycinema.Imasha;
import android.content.Context;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blueskycinema.DB_Handler;
import com.example.blueskycinema.R;

import java.util.ArrayList;
import java.util.List;

public class GetReviews extends AppCompatActivity {

    TextView countRev,avgRating;
    RatingBar main_rating_bar;
    RecyclerView rcView;
    DB_Handler databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviews);
        DB_Handler DB = new DB_Handler(this);
        GetReviews context = this;

        countRev = findViewById(R.id.totRatingtxt);
        avgRating = findViewById(R.id.avg_ratingtxt);
        main_rating_bar = findViewById(R.id.main_rating_bar);
        //set reviews count
        int count = DB.countReviews();
        countRev.setText(count + " Reviews");

        //set rating count
        float rateCount = DB.countRating();
        float avg = rateCount / 5;
        avgRating.setText(avg + "/5");
        main_rating_bar.setRating(avg / 2);

        //get all Reviews
        rcView = findViewById(R.id.recyView);
        databaseHelper = new DB_Handler(this);

        showRecord();



    }
    private void showRecord() {
        RevAddapter adapter = new RevAddapter(GetReviews.this, databaseHelper.getAllReviews(DB_Handler.REVIEWS_COLUMN_DATE+ " DESC"));
        rcView.setAdapter(adapter);
        rcView.setItemAnimator(new DefaultItemAnimator());
    }
    @Override
    protected void onResume() {
        super.onResume();
        showRecord();
    }


}
