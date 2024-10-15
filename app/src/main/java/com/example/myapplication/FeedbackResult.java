package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FeedbackResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_result);

        String feedbackType = getIntent().getStringExtra("FEEDBACK_TYPE");
        String feedbackText = getIntent().getStringExtra("FEEDBACK_TEXT");
        String email = getIntent().getStringExtra("EMAIL");
        boolean notificationsEnabled = getIntent().getBooleanExtra("NOTIFICATIONS_ENABLED", false);

        TextView resultTextView = findViewById(R.id.resultTextView);

        StringBuilder result = new StringBuilder();
        result.append("Feedback Type: ").append(feedbackType).append("\n")
                .append("Feedback: ").append(feedbackText).append("\n")
                .append("Email: ").append(email.isEmpty() ? "No email provided" : email).append("\n")
                .append("Notifications Enabled: ").append(notificationsEnabled ? "Yes" : "No");

        resultTextView.setText(result.toString());

        Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(v -> finish()); // Closes this activity and returns to the previous one
    }
}
