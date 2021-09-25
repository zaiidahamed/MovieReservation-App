package com.example.blueskycinema.Janani;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.blueskycinema.DB_Handler;
import com.example.blueskycinema.R;

public class AddFood extends AppCompatActivity {

    EditText editTextTextPersonName3,editTextTextPersonName5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        editTextTextPersonName3 = findViewById(R.id.editTextTextPersonName3);
        editTextTextPersonName5 = findViewById(R.id.editTextTextPersonName5);
    }

    public void submitFood (View view) {
        DB_Handler db = new DB_Handler(this);
        long val = db.addFood(editTextTextPersonName3.getText().toString(),editTextTextPersonName5.getText().toString());
        if(val > 0){
            Toast.makeText(this, "Data inserted successfully!!!", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Data not inserted!!!", Toast.LENGTH_SHORT).show();
        }
    }
}



