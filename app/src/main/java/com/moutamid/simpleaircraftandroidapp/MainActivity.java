package com.moutamid.simpleaircraftandroidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.moutamid.simpleaircraftandroidapp.Model.AircraftModel;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    TextView titleTxt,nameTxt,operateTxt,ownerTxt,statusTxt,regTxt,noteTxt,yearTxt,back,countryTxt,icuTxt;
    ImageView imageView;
    private GoogleMap mMap;
    AircraftModel model;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        back = findViewById(R.id.back);
        titleTxt = findViewById(R.id.serialNo);
        countryTxt = findViewById(R.id.country);
        icuTxt = findViewById(R.id.icu);
        nameTxt = findViewById(R.id.name);
        operateTxt = findViewById(R.id.operator);
        ownerTxt = findViewById(R.id.owner);
        statusTxt = findViewById(R.id.status);
        regTxt = findViewById(R.id.reg);
        noteTxt = findViewById(R.id.notes);
        yearTxt = findViewById(R.id.year);
        imageView = findViewById(R.id.image);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        model = getIntent().getParcelableExtra("aircraft");
        titleTxt.setText(String.valueOf(model.getId()));
        nameTxt.setText(String.valueOf(model.getId()));
        operateTxt.setText("Operator: " + model.getOp());
        ownerTxt.setText("Owned by: " + model.getOwner());
        regTxt.setText(model.getReg());
        countryTxt.setText(model.getCountry());
        yearTxt.setText("Year of build: "+model.getYearbuilt());
        noteTxt.setText(model.getNotes());
        statusTxt.setText(model.getStatus());
        if (model.isSAR()){
            icuTxt.setText("SAR");
        }

        if (model.isOG()){
            icuTxt.setText("Oil & Gas");
        }
        imageView.setImageBitmap(getBitmapFromAsset(model.getImageName() + ".png"));
    }

    private Bitmap getBitmapFromAsset(String strName)
    {
        AssetManager assetManager = getAssets();
        InputStream istr = null;
        try {
            istr = assetManager.open(strName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(istr);
        return bitmap;
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        LatLng latLng = new LatLng(model.getLat(),model.getLng());
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,14f));

    }
}