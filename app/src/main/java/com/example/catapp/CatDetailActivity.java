package com.example.catapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CatDetailActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView descriptionTextView;
    private TextView weightTextView;
    private TextView temperamentTextView;
    private  TextView originTextView;
    private TextView lifespanTextView;
    private TextView wikilinkTextView;
    private TextView friendlinesslevelTextView;
    private ImageView favourites;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_detail);
        Intent intent = getIntent();
        String catId = intent.getStringExtra("catId");

        Cat cat = FakeDatabase.getCatByID(catId);


        nameTextView = findViewById(R.id.breedname);
        temperamentTextView = findViewById(R.id.temperament);
        lifespanTextView = findViewById(R.id.lifespan);
        friendlinesslevelTextView = findViewById(R.id.friendlinesslevel);




        descriptionTextView = findViewById(R.id.description);
        originTextView = findViewById(R.id.origin);
        wikilinkTextView = findViewById(R.id.wikilink);
        favourites = findViewById(R.id.favourite_list);



        nameTextView.setText(cat.getName());
        descriptionTextView.setText(cat.getDescription());
        temperamentTextView.setText(cat.getTemperament());
        originTextView.setText(cat.getOrigin());
        lifespanTextView.setText(cat.getLife_span() + " Years");
        wikilinkTextView.setText(cat.getWikipedia_url());
        friendlinesslevelTextView.setText(cat.getDog_friendly());

        favourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favouritesActivity();
                Toast.makeText(getApplicationContext(),"This Cat has been added to Favourites",Toast.LENGTH_LONG).show();


            }
        });

    }

    public void favouritesActivity() {

        String name = (String) nameTextView.getText();
        MainActivity.favouritesList.add(new Favourites(name));
        System.out.println("This Cat has been added to Favourites");


    }
}
