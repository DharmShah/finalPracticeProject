package com.example.finalpracticeproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        resultTextView = findViewById(R.id.resultTextView);

        // Receive data from Intent
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String name = bundle.getString("name");
            String email = bundle.getString("email");
            String password = bundle.getString("password");
            String date = bundle.getString("date");
            String time = bundle.getString("time");
            String grouptext = bundle.getString("grouptext");
            String country = bundle.getString("country");
            String hobbies = bundle.getString("hobbies");
            String gender = bundle.getString("gender");

            // Format display text
            String displayText = "Name: " + name + "\n"
                    + "Email: " + email + "\n"
                    + "Password: " + password + "\n"
                    + "Date: " + date + "\n"
                    + "Time: " + time + "\n"
                    + "Group Text: " + grouptext + "\n"
                    + "Country: " + country + "\n"
                    + "Hobbies: " + hobbies + "\n"
                    + "Gender: " + gender;

            // Set text
            resultTextView.setText(displayText);
        }
    }
}
