package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegConfirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_confirm);

        Intent it = getIntent();
        String fullName = it.getStringExtra("Full_Name");
        String email = it.getStringExtra("Email");
        String teamName = it.getStringExtra("Team_Name");

        TextView textFName = findViewById(R.id.tfName);
        TextView textTName = findViewById(R.id.ttName);
        TextView textEmail = findViewById(R.id.temail);

        textFName.setText("Hello " + fullName);
        textTName.setText("You are registering your team " + teamName + " for Hackathon 2024");
        textEmail.setText("Email: " + email);

        Button conBut = findViewById(R.id.buttonConfirm);
        conBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("RegConfirm", "Button clicked, starting Congrat activity");
                Intent intentt = new Intent(RegConfirm.this, Congrat.class);
                startActivity(intentt);
            }
        });
    }
}
