package com.example.a109590016_hw401;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mMessageEditText;
    private TextView mCountTextView;
    private int countNum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessageEditText = findViewById(R.id.editText_main);
        mCountTextView = findViewById(R.id.textView);

        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState
                    .getBoolean("reply_visible");
            if (isVisible) {
                mMessageEditText.setVisibility(View.VISIBLE);
                mMessageEditText.setText(savedInstanceState
                        .getString("reply_text"));
                mMessageEditText.setVisibility(View.VISIBLE);
            }
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mMessageEditText.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("input_text", mMessageEditText.getText().toString());
        }
    }
    public void countUp(View view){
        countNum += 1;
        mCountTextView.setText(Integer.toString(countNum));
    }
}