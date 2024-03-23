package com.example.tp_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private CheckBox kSACheckbox;
    private TextView mdpoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        kSACheckbox = findViewById(R.id.CheckBox);
        mdpoTextView = findViewById(R.id.mdpoTextView);

        loginButton.setOnClickListener(view -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            boolean isEmailValid = isValidEmail(email);
            boolean isPasswordValid = isValidPassword(password);

            if (isEmailValid && isPasswordValid) {
                // Perform login
                Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
            } else {
                // Display error message if email or password is incorrect
                Toast.makeText(MainActivity.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
            }
        });

        kSACheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Store the checkbox state in SharedPreferences or perform other actions
                SharedPreferences.Editor editor = getSharedPreferences("MyPrefs", MODE_PRIVATE).edit();
                editor.putBoolean("sessionActive", isChecked);
                editor.apply();
            }
        });

        mdpoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add logic to handle the "Forgotten Password" action, such as launching a password recovery activity
                // For example:
                // startActivity(new Intent(MainActivity.this, PasswordRecoveryActivity.class));
            }
        });

        TextView textView = findViewById(R.id.textView2);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        // Create a SpannableString
        SpannableString spannableString = new SpannableString("Vous n'avez pas encore de compte ? inscrivez vous ici");

        // Define the clickable span for "inscrivez vous ici"
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Handle click action here, e.g., navigate to registration activity
                // startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
            }
        };

        // Set the clickable span for "inscrivez vous ici"
        spannableString.setSpan(clickableSpan, spannableString.length() - "inscrivez vous ici".length(), spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Make the text view clickable
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        // Set the SpannableString to the TextView
        textView.setText(spannableString);
    }

    private boolean isValidEmail(String email) {
        // Add your email validation logic here
        return !email.isEmpty(); // For demonstration, checking if email is not empty
    }

    private boolean isValidPassword(String password) {
        // Add your password validation logic here
        return password.length() >= 6; // For demonstration, checking if password length is at least 6 characters
    }
}
