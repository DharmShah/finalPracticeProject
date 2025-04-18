package com.example.finalpracticeproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText name, password, email, date, time, grouptext;
    private AutoCompleteTextView country;
    private RadioGroup gender;
    private CheckBox volleyball, badminton, cricket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialization of Views
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        grouptext = findViewById(R.id.grouptext);
        country = findViewById(R.id.country);
        volleyball = findViewById(R.id.volleyball);
        badminton = findViewById(R.id.badminton);
        cricket = findViewById(R.id.cricket);
        gender = findViewById(R.id.gender);
        button = findViewById(R.id.button);

        // Country dropdown setup
        String[] arr = {"INDIA", "USA", "CANADA", "PAKISTAN"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, arr);
        country.setAdapter(adapter);

        // Button click logic
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Gender
                int selectedId = gender.getCheckedRadioButtonId();
                String genderText = "";
                if (selectedId != -1) {
                    RadioButton genderbtn = findViewById(selectedId);
                    genderText = genderbtn.getText().toString();
                }

                // Hobbies
                StringBuilder hobbies = new StringBuilder();
                if (volleyball.isChecked()) hobbies.append("Volleyball ");
                if (badminton.isChecked()) hobbies.append("Badminton ");
                if (cricket.isChecked()) hobbies.append("Cricket ");

                // Get all inputs
                String namedd = name.getText().toString();
                String emaildd = email.getText().toString();
                String passworddd = password.getText().toString();
                String datedd = date.getText().toString();
                String timedd = time.getText().toString();
                String grouptextdd = grouptext.getText().toString();
                String countrydd = country.getText().toString();

                // Logging
                Log.v("FormData", "Name: " + namedd
                        + " | Email: " + emaildd
                        + " | Password: " + passworddd
                        + " | Date: " + datedd
                        + " | Time: " + timedd
                        + " | Group Text: " + grouptextdd
                        + " | Country: " + countrydd
                        + " | Hobbies: " + hobbies
                        + " | Gender: " + genderText);

                // Intent setup
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("name", namedd);
                intent.putExtra("email", emaildd);
                intent.putExtra("password", passworddd);
                intent.putExtra("date", datedd);
                intent.putExtra("time", timedd);
                intent.putExtra("grouptext", grouptextdd);
                intent.putExtra("country", countrydd);
                intent.putExtra("hobbies", hobbies.toString());
                intent.putExtra("gender", genderText);

                startActivity(intent);
            }
        });
    }
}
