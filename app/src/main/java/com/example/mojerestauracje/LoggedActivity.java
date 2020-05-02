package com.example.mojerestauracje;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.OnMapReadyCallback;

public class LoggedActivity extends AppCompatActivity  {
    TextView hello;
    Button searchButton, listButton;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);

        searchButton = findViewById(R.id.searchBtn);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoggedActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
        listButton = findViewById(R.id.listBtn);

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoggedActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
        EditText accountName = findViewById(R.id.emailEditText);

        hello = findViewById(R.id.helloTextView);
        hello.setText("Witaj, " + accountName +"!");
    }
}
