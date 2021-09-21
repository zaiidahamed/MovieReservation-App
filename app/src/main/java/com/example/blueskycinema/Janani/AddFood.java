package com.example.blueskycinema.Janani;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.blueskycinema.DB_Handler;
import com.example.blueskycinema.R;

public class AddFood extends AppCompatActivity {

    DB_Handler myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        myDB = new DB_Handler(this);
    }
}



