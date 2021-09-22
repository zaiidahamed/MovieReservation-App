package com.example.blueskycinema.Imasha;

import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.blueskycinema.DB_Handler;
import com.example.blueskycinema.R;
import androidx.appcompat.app.AppCompatActivity;

public class PostReview extends AppCompatActivity {

    EditText  reviewText;
    //Button post,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writereview);

        reviewText = findViewById(R.id.reviewText);
        //post = findViewById(R.id.post_btn);
        //cancel = findViewById(R.id.cancel_btn);

    }
    public void submitReview(View view){
        DB_Handler DB = new DB_Handler(this);
        long info = DB.addReview(reviewText.getText().toString());
        if( info > 0 ){
            Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "UnSuccessful", Toast.LENGTH_SHORT).show();
        }
    }
}
