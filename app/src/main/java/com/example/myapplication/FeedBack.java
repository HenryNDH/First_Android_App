package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FeedBack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        RadioGroup radioGroupFeedback = findViewById(R.id.radioGroupFeedback);
        EditText editTextFeedback = findViewById(R.id.editTextFeedback);
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        Switch switchNotify = findViewById(R.id.switch_notify);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);

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

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = radioGroupFeedback.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                String feedbackType = selectedRadioButton != null ? selectedRadioButton.getText().toString() : "No feedback type selected";


                String feedbackText = editTextFeedback.getText().toString();
                String email = editTextEmail.getText().toString();
                boolean isNotificationsEnabled = switchNotify.isChecked();


                Intent intent = new Intent(FeedBack.this, FeedbackResult.class);
                intent.putExtra("FEEDBACK_TYPE", feedbackType);
                intent.putExtra("FEEDBACK_TEXT", feedbackText);
                intent.putExtra("EMAIL", email);
                intent.putExtra("NOTIFICATIONS_ENABLED", isNotificationsEnabled);


                startActivity(intent);
            }
        });
    }
}
