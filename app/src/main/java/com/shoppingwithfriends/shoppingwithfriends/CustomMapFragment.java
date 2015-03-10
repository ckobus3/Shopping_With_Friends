package com.shoppingwithfriends.shoppingwithfriends;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

public class CustomMapFragment extends com.google.android.gms.maps.SupportMapFragment {

    private final LatLng Atlanta = new LatLng(33.7550, -84.3900);

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        GoogleMap googleMap = getMap();
        googleMap.setMyLocationEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(false);
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        CameraUpdate cam = CameraUpdateFactory.newLatLngZoom(Atlanta, 10);
        //googleMap.addMarker(new MarkerOptions().position(place).title("place"));
        googleMap.animateCamera(cam);
    }

}