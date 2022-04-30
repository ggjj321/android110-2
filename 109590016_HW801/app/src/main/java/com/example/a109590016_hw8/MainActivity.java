package com.example.a109590016_hw8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private int level;
    ImageView battery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        level = 1;
        battery = (ImageView) findViewById(R.id.imageView);
        battery.setImageLevel(level);
    }
    public void lightUp(View view){
        if(level < 7){
            level += 1;
        }
        battery.setImageLevel(level);
    }

    public void lightDown(View view){
        if(level > 1){
            level -= 1;
        }
        battery.setImageLevel(level);
    }
}