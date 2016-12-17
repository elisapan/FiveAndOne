package com.teicm.fiveandone;

import android.*;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    private Button Bonus;
    private int level=1 ;
    private Marker mSerres;
    private Marker mThessaloniki;
    private Marker mEdessa;
    private Marker mLarissa;
    private Marker mVolos;
    private Marker mAthens;

    private static final LatLng SERRES = new LatLng(41.07469264, 23.55348587);
    private static final LatLng THESSALONIKI = new LatLng(40.640063, 22.944419);
    private static final LatLng EDESSA = new LatLng(40.801680, 22.04398);
    private static final LatLng LARISA = new LatLng(39.639022, 22.419125);
    private static final LatLng VOLOS = new LatLng(39.362190, 22.942159);
    private static final LatLng ATHENS = new LatLng(37.983810, 23.727539);



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == QuizActivity.RESULT_OK){
                String result=data.getStringExtra("result");
            }
            if (resultCode == QuizActivity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Welcome = (TextView) findViewById(R.id.welcome);
        Info = (TextView) findViewById(R.id.info) ;
        Next = (Button) findViewById(R.id.next) ;
        //Next.setOnClickListener(this);
        Next.setVisibility(View.INVISIBLE);
        Bonus = (Button) findViewById(R.id.bonusbtn) ;
        Bonus.setVisibility(View.INVISIBLE);

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
        mMap.setMinZoomPreference(7.5f);
        googleMap.getUiSettings().setZoomControlsEnabled(true);



        //find my location
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            mMap.setMyLocationEnabled(true);
        } else {
            Toast.makeText(MapsActivity.this, "Πρέπει να ενεργοποιήσετε το GPS για την ευρεση της τοποθεσίας σας", Toast.LENGTH_LONG).show();
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
            }
        }
        mMap.setMyLocationEnabled(true);

        mSerres = mMap.addMarker(new MarkerOptions().position(SERRES).title("Σέρρες").snippet("Πρώτη τοποθεσία"));
        mThessaloniki = mMap.addMarker(new MarkerOptions().position(THESSALONIKI).title("Θεσσαλονίκη").snippet("Δεύτερη τοποθεσία"));
        mEdessa = mMap.addMarker(new MarkerOptions().position(EDESSA).title("Έδεσσα").snippet("Τρίτη τοποθεσία"));
        mVolos = mMap.addMarker(new MarkerOptions().position(VOLOS).title("Βόλος").snippet("Πέμπτη τοποθεσία"));
        mAthens = mMap.addMarker(new MarkerOptions().position(ATHENS).title("Αθήνα").snippet("Έκτη τοποθεσία"));
        mLarissa = mMap.addMarker(new MarkerOptions().position(LARISA).title("Λάρισσα").snippet("Έβδομη τοποθεσία"));




        mMap.moveCamera(CameraUpdateFactory.newLatLng(SERRES));

        mSerres.setVisible(true);
        mThessaloniki.setVisible(false);
        mEdessa.setVisible(false);
        mLarissa.setVisible(false);
        mVolos.setVisible(false);
        mAthens.setVisible(false);





        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if(marker.getTitle().equals("Σέρρες")) { // if marker source is clicked
                    Info.setText("Πρώτο επίπεδο.Καλωσήρθες στη Σέρρες. Πάτησε το κουμπί για να λύσεις τον γρίφο.");
                    Next.setVisibility(View.VISIBLE);

                    Next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent act5 = new Intent(MapsActivity.this, QuizActivity.class);
                            startActivityForResult(act5, 1);
                            level=2;
                            mThessaloniki.setVisible(true);

                        }
                    });




                } else if (marker.getTitle().equals("Θεσσαλονίκη")&&level==2){

                    Info.setText("Δεύτερο επίπεδο.Καλωσήρθες στη Θεσσαλονίκη. Πάτησε το κουμπί για να λύσεις τον γρίφο.");
                    Next.setVisibility(View.VISIBLE);
                    Next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent act5 = new Intent(MapsActivity.this, QuizActivity.class);
                            startActivityForResult(act5, 1);
                            level=3;
                            mVolos.setVisible(true);

                        }
                    });

                } else if (marker.getTitle().equals("Βόλος")&&level==3){
                    Info.setText("Τρίτο επίπεδο.Καλωσήρθες στο Βόλο. Πάτησε το κουμπί για να λύσεις τον γρίφο.");
                    Next.setVisibility(View.VISIBLE);
                    Next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent act5 = new Intent(MapsActivity.this, QuizActivity.class);
                            startActivityForResult(act5, 1);
                            level=4;
                            mEdessa.setVisible(true);

                        }
                    });



                }else if (marker.getTitle().equals("Έδεσσα")&&level==4){
                    Info.setText("Τέταρτο επίπεδο.Καλωσήρθες στην Έδεσσα. Πάτησε το κουμπί για να λύσεις τον γρίφο.");
                    Next.setVisibility(View.VISIBLE);
                    Next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent act5 = new Intent(MapsActivity.this, QuizActivity.class);
                            startActivityForResult(act5, 1);
                            level=5;
                            mAthens.setVisible(true);

                        }
                    });

                }else if (marker.getTitle().equals("Αθήνα")&&level==5){
                    Info.setText("Πέμπτο επίπεδο.Καλωσήρθες στην Αθήνα. Σε αυτό το σημείο πρέπει να λύσεις τον γρίφο και να περάσεις το Zombi level.");
                    Next.setVisibility(View.VISIBLE);
                    Bonus.setVisibility(View.VISIBLE);
                    Next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent act5 = new Intent(MapsActivity.this, QuizActivity.class);
                            startActivityForResult(act5, 1);
                            level=6;
                            //mAthens.setVisible(true);

                        }
                    });
                    Bonus.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent act6 = new Intent(MapsActivity.this, Gift.class);
                            startActivityForResult(act6, 1);
                        }
                    });


                }







                return true;
            }
        });




    }


}
