package com.example.a109590016_hw701;

import android.content.Intent;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ActionBar actionBar;
    ImageView dountView;
    ImageView froyoView;
    ImageView iceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
        dountView = (ImageView)findViewById(R.id.dount);
        froyoView = (ImageView)findViewById(R.id.froyo);
        iceView = (ImageView)findViewById(R.id.icecream);

        Intent dountIntent = new Intent(this, dount.class);
        Intent froyoIntent = new Intent(this, froyo.class);
        Intent iceIntent = new Intent(this, icecream.class);


        dountView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(dountIntent);
            }
        });

        froyoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(froyoIntent);
            }
        });

        iceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(iceIntent);
            }
        });
    }

}