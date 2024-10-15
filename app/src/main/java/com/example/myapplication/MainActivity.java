package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnItemSelectedListener(item -> {
            Intent intent;
            int id = item.getItemId();

            if (id == R.id.home) {
                intent = new Intent(this, MainActivity.class);
            } else if (id == R.id.register) {
                intent = new Intent(this, Register.class);
            } else if (id == R.id.feedback) {
                intent = new Intent(this, FeedBack.class);
            } else {
                return false;
            }

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);

            overridePendingTransition(0, 0);
            return true;
        });


    }
}