package com.teicm.fiveandone;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView Welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Welcome = (TextView) findViewById(R.id.welcome);

        Intent act = getIntent();
        String name = act.getExtras().getString("parameter");
        Welcome.setText("Καλωσήρθες χρήστη: "+name);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMinZoomPreference(10.5f);



        //find my location
        //mMap.setMyLocationEnabled(true);

        // Add a marker in Serres and move the camera
        LatLng serres = new LatLng(41.07469264, 23.55348587);
        mMap.addMarker(new MarkerOptions().position(serres).title("Σέρρες"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(serres));
    }
}
