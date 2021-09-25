package com.example.blueskycinema.Hasith;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.blueskycinema.R;

public class startup extends AppCompatActivity {

    public void home (View view){
        setContentView(R.layout.main_view);
        Intent intent = new Intent(this, displayMovies.class);
        startActivity(intent);
    }
}
