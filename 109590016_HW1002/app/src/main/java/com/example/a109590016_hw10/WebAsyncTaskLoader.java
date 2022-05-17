package com.example.a109590016_hw10;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class WebAsyncTaskLoader extends AsyncTaskLoader<String> {

    private String mQueryString;

    public WebAsyncTaskLoader(@NonNull Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        try {
            return GetWebData.getHtml(mQueryString);
        } catch (Exception e) {
            return String.format("error %s", e);
        }
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
