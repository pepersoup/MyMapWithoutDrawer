package com.example.lulu.mymapwithoutdrawer;

import android.os.AsyncTask;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.nio.DoubleBuffer;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lulu on 09/02/2018.
 */

public class GetNearbyPlacesData extends AsyncTask<Object,String, String>{

    String googlePlaceData;
    GoogleMap mMap;
    String url;


    @Override
    protected String doInBackground(Object... objects) {
        mMap = (GoogleMap) objects[0];
        url= (String) objects[1];

        DownloadUrl downloadUrl = new DownloadUrl();
        try {
            googlePlaceData = downloadUrl.readUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return googlePlaceData;
    }

    @Override
    protected void onPostExecute(String s) {
        List<HashMap<String,String>> nearbyPlacelist = null;
        DataParse parse = new DataParse();
        nearbyPlacelist = parse.parse(s);
        showNearbyPlaces(nearbyPlacelist);

    }

    private  void showNearbyPlaces(List<HashMap<String,String>> nearbyPlaces){

        for(int i=0;i<nearbyPlaces.size();i++){
            MarkerOptions markerOptions = new MarkerOptions();
            HashMap<String,String> googlePlace = nearbyPlaces.get(i);


            String placeName = googlePlace.get("place_name");
            String vicinity = googlePlace.get("vicinity");
            Double lat = Double.parseDouble(googlePlace.get("lat"));
            Double lng = Double.parseDouble(googlePlace.get("lng"));

            LatLng latLng = new LatLng(lat,lng);
            markerOptions.position(latLng);
            markerOptions.title(placeName +":"+ vicinity);
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));

            mMap.addMarker(markerOptions);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(10));


        }
    }
}

