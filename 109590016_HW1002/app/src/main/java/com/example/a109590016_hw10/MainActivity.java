package com.example.a109590016_hw10;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements
        AdapterView.OnItemSelectedListener, LoaderManager.LoaderCallbacks<String>{

    String[] protocols = { "http://", "https://"};
    TextView mTextView;
    TextView spinnerView;
    EditText webInput;
    Button mButton;
    Spinner spin;

    String protocol = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,protocols);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        mTextView = (TextView) findViewById(R.id.webPage);
        //spinnerView = (TextView) findViewById(R.id.textView2);
        webInput = (EditText) findViewById(R.id.inputText);
        mButton = (Button) findViewById(R.id.button);
    }

    public void loadPage(View view) {
        String path = protocol + webInput.getText().toString();

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected()
                && path.length() != 0) {

            Bundle queryBundle = new Bundle();
            queryBundle.putString("path", path);
            getSupportLoaderManager().restartLoader(0, queryBundle, this);

            mTextView.setText("");
        }
        // Otherwise update the TextView to tell the user there is no
        // connection, or no search term.
        else {
            if (path.length() == 0) {
                mTextView.setText("");
            } else {
                mTextView.setText("");
            }
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        protocol = protocols[position];
        //spinnerView.setText(protocol);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        String path = "";
        if (args != null) {
            path = args.getString("path");
        }
        return  new WebAsyncTaskLoader(this, path);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        mTextView.setText(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}