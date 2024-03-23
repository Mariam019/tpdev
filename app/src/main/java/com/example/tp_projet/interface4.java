package com.example.tp_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class interface4 extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface4);

        // Retrieve the city mentioned in the form from the intent
        String cityMentioned = getIntent().getStringExtra("villementionee");

        // Now you have the cityMentioned value, you can use it to fetch the number of annonces
        // You can proceed with displaying the number of annonces in the UI
        // For demonstration, let's assume you have a TextView with id annonceCountTextView
        // and you want to display the number of annonces there
        int numberOfAnnonces = fetchNumberOfAnnoncesForCity(cityMentioned);
        TextView annonceCountTextView = findViewById(R.id.annonceCountTextView);
        annonceCountTextView.setText("Il y a actuellement " + numberOfAnnonces +" "+ "annonces sur " + cityMentioned);
    }

    private int fetchNumberOfAnnoncesForCity(String city) {
        int numberOfAnnonces = 0;
        if (city.equals("Agadir")) {
            numberOfAnnonces = 20;
        } else if (city.equals("Casablanca")) {
            numberOfAnnonces = 54;
        }
        return numberOfAnnonces;
    }
}