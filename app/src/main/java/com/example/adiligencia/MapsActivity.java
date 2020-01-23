package com.example.adiligencia;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, myToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        // Add a marker in Sydney and move the camera
        LatLng sao_leopoldo = new LatLng(-29.7549941, -51.150283);
        LatLng esteio = new LatLng(-29.8524632, -51.1845758);

        mMap.addMarker(new MarkerOptions().position(esteio).title("(51) 99972-9864").icon(
                BitmapDescriptorFactory.fromResource(R.drawable.whats)));
        mMap.addMarker(new MarkerOptions().position(sao_leopoldo).title("São Leopoldo").icon(
                BitmapDescriptorFactory.fromResource(R.drawable.whats)));


        mMap.moveCamera(CameraUpdateFactory.newLatLng(sao_leopoldo));


        //setar o zoom do mapa
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(esteio, 12.0f));

        //mostra controles de zoom
        mMap.getUiSettings().setZoomControlsEnabled(true);


        //adiciona linha rota
        mMap.addPolyline(new PolylineOptions()
                .add(sao_leopoldo, esteio)
                .width(5)
                .color(Color.RED));

        //adiciona circulo
        mMap.addCircle(
                new CircleOptions()
                        .center(esteio)
                        .radius(1580.0)
                        .strokeColor(Color.RED)
                        .fillColor(Color.argb(70, 150, 50, 50))
        );


    }
}
