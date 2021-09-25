package com.example.blueskycinema.Hasith;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blueskycinema.DB_Handler;
import com.example.blueskycinema.MainActivity;
import com.example.blueskycinema.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class displayMovies extends AppCompatActivity {

//    FloatingActionButton fab;
//    ActionBar actionBar;
    RecyclerView mRecyclerView;
    DB_Handler databaseHelper;
//    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_view);
//        actionBar = getSupportActionBar();
//        actionBar.setTitle("All Information");

        mRecyclerView = findViewById(R.id.recyclerView);
        databaseHelper = new DB_Handler(this);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        layoutManager = new GridLayoutManager(this,2);

        showRecord();

//        fab = findViewById(R.id.addFabButton);
//
//        fab.setOnClickListener((v -> {
//            startActivity(new Intent(add_movies.this, add_movies.class));
//        }));
    }
    private void showRecord() {
        Adapter adapter = new Adapter(displayMovies.this, databaseHelper.getAllData(DB_Handler.MOVIE_COLUMN_START_DATE+ " DESC"));

        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showRecord();
    }
}
