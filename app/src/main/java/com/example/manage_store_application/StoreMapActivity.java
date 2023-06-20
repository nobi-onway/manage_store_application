package com.example.manage_store_application;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.InputStream;

public class StoreMapActivity extends AppCompatActivity {
//    private GoogleMap _googleMap;

    private StoreMapFragment _storeMapFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_map_layout);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.store_map_fragment);

        _storeMapFragment = new StoreMapFragment(mapFragment);
        _storeMapFragment.InitGoogleMap();

//        mapFragment.getMapAsync(new OnMapReadyCallback() {
//            @Override
//            public void onMapReady(GoogleMap map) {
//                _googleMap = map;
//
//                LatLng myLocation = new LatLng(10.876274472837375, 106.80128522422662);
//
//                _googleMap.addMarker(new MarkerOptions()
//                        .position(myLocation)
//                        .title("Marker in my location"))
////                        .setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))
////                        .setIcon(BitmapDescriptorFactory.defaultMarker(BitmapFactory.decodeFile()))
////                        .setAlpha(0.5f)
//                        ;
//
//                _googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
//                    @Override
//                    public void onMapClick(@NonNull LatLng latLng) {
//                        _googleMap.addMarker(new MarkerOptions()
//                                .position(new LatLng(latLng.latitude, latLng.longitude))
//                                .title(String.format("%.2f, %.2f", latLng.latitude, latLng.longitude)))
//                                .setDraggable(true);
//                    }
//                });
//
//
//                _googleMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
//                    @Override
//                    public void onMarkerDrag(@NonNull Marker marker) {
//
//                    }
//
//                    @Override
//                    public void onMarkerDragEnd(@NonNull Marker marker) {
//                        LatLng newPosition = marker.getPosition();
//                    }
//
//                    @Override
//                    public void onMarkerDragStart(@NonNull Marker marker) {
//
//                    }
//                });
//
//            }
//        });
    }
}