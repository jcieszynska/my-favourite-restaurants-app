package com.example.mojerestauracje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoggedActivity extends AppCompatActivity {

    Button searchButton, listButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);

        searchButton = findViewById(R.id.searchBtn);
        listButton = findViewById(R.id.listBtn);

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoggedActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }
}
