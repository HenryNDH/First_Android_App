package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.EventListener;

public class Register extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText fullName = findViewById(R.id.editTextName);
        EditText email = findViewById(R.id.editTextEmail);
        EditText teamName = findViewById(R.id.editTextTeamName);

        Button regBut = findViewById(R.id.buttonRegister);

        regBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fName = fullName.getText().toString();
                String e = email.getText().toString();
                String tName = teamName.getText().toString();

                Intent it = new Intent(Register.this, RegConfirm.class);

                it.putExtra("Full_Name", fName);
                it.putExtra("Email", e);
                it.putExtra("Team_Name", tName);
                startActivity(it);
            }
        });

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnItemSelectedListener(item -> {
            Intent intent;
            int id = item.getItemId();

            // Create the intent based on the selected item
            if (id == R.id.home) {
                intent = new Intent(this, MainActivity.class);
            } else if (id == R.id.register) {
                intent = new Intent(this, Register.class);
            } else if (id == R.id.feedback) {
                intent = new Intent(this, FeedBack.class);
            } else {
                return false; // Handle unrecognized item
            }

            // Start the activity with flags to prevent multiple instances
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);

            // No transition
            overridePendingTransition(0, 0);
            return true;
        });



    }
}