package com.example.blueskycinema.Imasha;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.blueskycinema.R;

public class Accinfo2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_information);

        Button savebtn;

        savebtn = findViewById(R.id.backBtn);

    }

    public void nav_back (View view){
        setContentView(R.layout.profle);
    }

}
