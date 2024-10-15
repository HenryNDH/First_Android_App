package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Congrat extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrat);

        String teamName = getIntent().getStringExtra("Team_Name");

        TextView tv = findViewById(R.id.congratMessage);

        tv.setText("You have successfully registered your team " + teamName + "for Hackathon 2024!");

        Button finishButton = findViewById(R.id.buttonFinish);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Congrat.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
