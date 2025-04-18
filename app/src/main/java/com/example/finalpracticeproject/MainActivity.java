package com.example.finalpracticeproject;

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
        volleyball = findViewById(R.id.volleyball);  // Fixed typo
        badminton = findViewById(R.id.badminton);
        cricket = findViewById(R.id.cricket);
        gender = findViewById(R.id.gender);          // Important!
        button = findViewById(R.id.button);

        // Country dropdown setup
        String[] arr = {"INDIA", "USA", "CANADA", "PAKISTAN"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, arr);
        country.setAdapter(adapter);

        // Button click logic
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Radio group selection
                int selectedId = gender.getCheckedRadioButtonId();
                String genderText = "";
                if (selectedId != -1) {
                    RadioButton genderbtn = findViewById(selectedId);
                    genderText = genderbtn.getText().toString();
                }

                // Collect hobbies
                String hobbies = "";
                if (volleyball.isChecked()) hobbies += "VolleyBall ";
                if (badminton.isChecked()) hobbies += "Badminton ";
                if (cricket.isChecked()) hobbies += "Cricket ";

                // Collect text inputs
                String namedd = name.getText().toString();
                String emaildd = email.getText().toString();
                String passworddd = password.getText().toString();
                String grouptextdd = grouptext.getText().toString();
                String datedd = date.getText().toString();
                String timedd = time.getText().toString();
                String countrydd = country.getText().toString();

                // Log everything
                Log.v("FormData", "Name: " + namedd
                        + " | Email: " + emaildd
                        + " | Password: " + passworddd
                        + " | Date: " + datedd
                        + " | Time: " + timedd
                        + " | Group Text: " + grouptextdd
                        + " | Country: " + countrydd
                        + " | Hobbies: " + hobbies
                        + " | Gender: " + genderText);
            }
        });
    }
}
