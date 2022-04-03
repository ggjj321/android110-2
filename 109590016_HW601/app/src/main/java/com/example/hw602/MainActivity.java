package com.example.hw602;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view){
        String toast = "Toppings:";
        CheckBox syrup = (CheckBox) findViewById(R.id.syrup);
        CheckBox Sprinkles = (CheckBox) findViewById(R.id.Sprinkles);
        CheckBox Crushed = (CheckBox) findViewById(R.id.Crushed);
        CheckBox Cherries = (CheckBox) findViewById(R.id.Cherries);
        CheckBox Oeio = (CheckBox) findViewById(R.id.Oeio);

        if(syrup.isChecked()) toast += "Chocolate syrup ";
        if(Sprinkles.isChecked()) toast += "Sprinkles ";
        if(Crushed.isChecked()) toast += "Crushed nuts ";
        if(Cherries.isChecked()) toast += "Cherries ";
        if(Oeio.isChecked()) toast += "Oeio cookie crumbles ";

        Toast.makeText(getApplicationContext(), toast,
                Toast.LENGTH_SHORT).show();
    }
}