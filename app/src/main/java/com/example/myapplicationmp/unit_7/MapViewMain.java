package com.example.myapplicationmp.unit_7;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplicationmp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapViewMain extends AppCompatActivity implements OnMapReadyCallback {
    private Resources res;


    @Override
    protected void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.unit_7_map_view);

        res = getResources();

        MapView mapContainer = findViewById(R.id.mapViewMain);
        mapContainer.onCreate(b);
        mapContainer.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap map) {
        LatLng coordinates = new LatLng(27.6915, 85.3420);
        map.addMarker(new MarkerOptions().position(coordinates).title("Kathmandu Sahar"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 10));
    }
}
