package com.example.adiligencia;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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

public class ExercicioMaps extends AppCompatActivity implements OnMapReadyCallback {
    private DrawerLayout drawer2;

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Toolbar myToolbar2 = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar2);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        drawer2 = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer2, myToolbar2, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer2.addDrawerListener(toggle);
        toggle.syncState();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng CaxiasDoSul = new LatLng(-29.163882, -51.179483);
        LatLng Gramado = new LatLng(-29.374667, -50.876423);
        LatLng PortoAlegre = new LatLng(-30.034421, -51.217970);
        LatLng Torres = new LatLng(-29.338412, -49.728235);
        LatLng Centro = new LatLng(-29.445848, -50.580907);


        mMap.addMarker(new MarkerOptions().position(CaxiasDoSul).title("Caxias Do Sul"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CaxiasDoSul));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(CaxiasDoSul, 12.0f));

        mMap.addMarker(new MarkerOptions().position(PortoAlegre).title("Porto Alegre"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(PortoAlegre));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(PortoAlegre, 12.0f));

        mMap.addMarker(new MarkerOptions().position(Torres).title("Torres"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Torres));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Torres, 12.0f));

        mMap.addMarker(new MarkerOptions().position(Gramado).title("Gramado"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Gramado));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Gramado, 7.0f));

        mMap.addMarker(new MarkerOptions().position(Centro).title("Centro").icon(
                BitmapDescriptorFactory.fromResource(R.drawable.center)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Centro));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Centro, 8.0f));


        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.addPolyline(new PolylineOptions()
                .add(CaxiasDoSul, Gramado, PortoAlegre, Torres, CaxiasDoSul)
                .width(5)
                .color(Color.RED));
        mMap.addCircle(
                new CircleOptions()
                        .center(Centro)
                        .radius(100000.0)
                        .strokeWidth(3f)
                        .strokeColor(Color.BLUE)
                        .fillColor(Color.argb(70, 57, 211, 199))

        );
    }
}