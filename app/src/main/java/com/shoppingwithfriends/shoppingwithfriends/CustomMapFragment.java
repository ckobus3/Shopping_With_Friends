package com.shoppingwithfriends.shoppingwithfriends;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

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

        Geocoder gc = new Geocoder(getActivity().getApplicationContext());
        try {
            String loc = getArguments().getString("location");
            List<Address> ad = gc.getFromLocationName(loc, 1, 32.985997, -85.124942, 34.701339, -83.350650);
            if (ad != null && ad.size() > 0) {
                LatLng place = new LatLng(ad.get(0).getLatitude(), ad.get(0).getLongitude());
                /* GeoPoint point = new GeoPoint(
                        (int) (a.getLatitude() * _1E6),
                        (int) (a.getLongitude() * _1E6)); */
                googleMap.addMarker(new MarkerOptions().position(place).title(loc));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        googleMap.animateCamera(cam);
    }

}