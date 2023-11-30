package com.example.mon_application.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ma_calculatrice.R;
import com.google.android.filament.View;

public class MainView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = findViewById(R.id.button);

        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View _view) {
                Intent intent = new Intent(MainView.this, CalculatorView.class);
                startActivity(intent);
            }
        });
    }
}