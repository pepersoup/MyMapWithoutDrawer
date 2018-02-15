package com.example.lulu.mymapwithoutdrawer;

import android.graphics.Color;
import android.os.AsyncTask;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lulu on 13/02/2018.
 */

public class GetDirectionsData extends AsyncTask<Object, String, String>{

    GoogleMap mMap;
    String url;
    String googleDirectionsData;
    String duration, distance;
    LatLng latlng;


    @Override
    protected String doInBackground(Object... objects) {
        mMap = (GoogleMap) objects[0];
        url= (String) objects[1];
        latlng = (LatLng) objects[3];

        DownloadUrl downloadUrl = new DownloadUrl();
        try {
            googleDirectionsData = downloadUrl.readUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return googleDirectionsData;
    }

    @Override
    protected void onPostExecute(String s) {
        String[] directionsList;
        DataParse parse = new DataParse();
        directionsList = parse.parseDirections(s);
        displayDirections(directionsList);

        //getdirections only without the steps
        /*HashMap<String,String> directionList = null;
        DataParse parse = new DataParse();
        directionList = parse.parseDirections(s);
        duration = directionList.get("direction");
        distance = directionList.get("distance");

        mMap.clear();
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latlng);
        markerOptions.draggable(true);
        markerOptions.title("Duration="+duration);
        markerOptions.title("Distance="+distance);

        mMap.addMarker(markerOptions);*/




    }

    private void displayDirections(String[] directionsList) {
        int count = directionsList.length;
        for(int i = 0; i<count; i++){

            PolygonOptions options = new PolygonOptions();
            options.fillColor(Color.RED);
            options.strokeWidth(10);
            //options.addAll(PolyUtil.decode(directionsList[i]));
            //mMap.addPolyline(options);
        }
    }
}
