package com.example.tp_projet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class interface2 extends AppCompatActivity {

    private EditText emailEditText, passwordEditText, confirmPasswordEditText;
    private TextView passwordErrorTextView, confirmPasswordErrorTextView;
    private Button createAccountButton;
    private RadioGroup radioGroup;
    private Spinner citySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface2);

        // Initialize views
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        passwordErrorTextView = findViewById(R.id.passwordErrorTextView);
        confirmPasswordErrorTextView = findViewById(R.id.confirmPasswordErrorTextView);
        createAccountButton = findViewById(R.id.createAccountButton);
        radioGroup = findViewById(R.id.radioGroup);
        citySpinner = findViewById(R.id.citySpinner);

        // Button click listener
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });

        // Password edit text focus change listener
        passwordEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    validatePasswordLength();
                }
            }
        });

        // Confirm password edit text focus change listener
        confirmPasswordEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    validateConfirmPassword();
                }
            }
        });
    }

    private void createAccount() {
        // Your account creation logic here
        startActivity(new Intent(interface2.this, interface3.class));
        Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show();
    }

    private void validatePasswordLength() {
        String password = passwordEditText.getText().toString().trim();
        if (password.length() < 5) {
            passwordErrorTextView.setVisibility(View.VISIBLE);
        } else {
            passwordErrorTextView.setVisibility(View.GONE);
        }
    }

    private void validateConfirmPassword() {
        String password = passwordEditText.getText().toString().trim();
        String confirmPassword = confirmPasswordEditText.getText().toString().trim();
        if (!password.equals(confirmPassword)) {
            confirmPasswordErrorTextView.setVisibility(View.VISIBLE);
        } else {
            confirmPasswordErrorTextView.setVisibility(View.GONE);
        }
    }
}