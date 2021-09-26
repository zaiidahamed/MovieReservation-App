package com.example.blueskycinema.Imasha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.blueskycinema.DB_Handler;
import com.example.blueskycinema.R;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Calendar;

public class PostReview extends AppCompatActivity {

    EditText  reviewText;
    Button post,cancel;
    RatingBar rtBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writereview);

        reviewText = findViewById(R.id.reviewText);
        post= findViewById(R.id.post_btn);
        cancel = findViewById(R.id.cancel_btn);
        rtBar = findViewById(R.id.rating_bar_writePage);


    }
    public void submitReview(View view){
        DB_Handler DB = new DB_Handler(this);
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        long info = DB.addReview(reviewText.getText().toString(),currentDate,String.valueOf(rtBar.getRating()));
        if( info > 0 ){
            Toast.makeText(this, "Added Your Review", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.reviews);
            Intent intent = new Intent(this, GetReviews.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "UnSuccessful", Toast.LENGTH_SHORT).show();
        }
    }

    public void cancel_btn (View view){
        setContentView(R.layout.reviews);
//        Intent intent = new Intent(this, TheaterRev.class);
//        startActivity(intent);
    }

}
