package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

/**
 * Created by FaiyazHuq on 2018-05-25.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private String url;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        this.url = url;
    }



    @Nullable
    @Override
    public List<Earthquake> loadInBackground() {


        return QueryUtils.fetchEarthquakeData(url);
    }
}
