package com.example.mojerestauracje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.graphics.Typeface.createFromAsset;

public class ListActivity extends AppCompatActivity {
    private ArrayAdapter mAdapter;
    private Typeface mTypeface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
       // mTypeface = Typeface.createFromAsset(getAssets(),"fonts/hobo.otf");


        ListView listView = findViewById(R.id.listView);
        final ArrayList<String> places = new ArrayList<>();
        places.add("Dodaj nowe miejsce...");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,places)
//        {
//            public View getView(int position, View convertView, ViewGroup parent) {
//                // Cast the list view each item as text view
//                TextView item = (TextView) super.getView(position, convertView, parent);
//
//                // Set the typeface/font for the current item
//                item.setTypeface(mTypeface);
//
//
//                // Change the item text size
//                item.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
//
//                // return the view
//                return item;
//            }
//        }
        ;
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                intent.putExtra("place", places.get(position));
                startActivity(intent);
            }
        });
    }


}
