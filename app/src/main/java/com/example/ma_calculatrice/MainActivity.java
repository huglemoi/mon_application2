package com.example.ma_calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View start = findViewById(R.id.button);

        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View _view) {
                Intent intent = new Intent(com.example.ma_calculatrice.MainActivity.this, CalculatorActivity.class);
                startActivity(intent);
            }

        });
    }
}