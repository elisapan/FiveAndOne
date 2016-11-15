package com.teicm.fiveandone;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView Welcome;
    private TextView Info;
    private Button Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Welcome = (TextView) findViewById(R.id.welcome);
        Info = (TextView) findViewById(R.id.info) ;
        Next = (Button) findViewById(R.id.next) ;
        //Next.setOnClickListener(this);
        Next.setVisibility(View.INVISIBLE);

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
        LatLng salonika = new LatLng(40.640063, 22.944419);

        mMap.addMarker(new MarkerOptions().position(serres).title("Σέρρες").snippet("Πρώτη τοποθεσία"));
        mMap.addMarker(new MarkerOptions().position(salonika).title("Θεσσαλονίκη").snippet("Δεύτερη τοποθεσία"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(serres));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.getTitle().equals("Σέρρες")) { // if marker source is clicked
                    Info.setText("Πρώτο επίπεδο.Πηγαινε Θεσσαλονίκη");
                    Next.setVisibility(View.INVISIBLE);
                } else if (marker.getTitle().equals("Θεσσαλονίκη")){
                    Info.setText("Καλωσήρθες Θεσσαλονίκη");
                    Next.setVisibility(View.VISIBLE);
                    Next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent act2 = new Intent(MapsActivity.this, MapQuiz.class);
                            //act2.putExtra("parameter",name);
                            startActivity(act2);

                        }
                    });
                }

                        return true;
            }
        });




    }


}
