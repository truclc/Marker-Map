package com.example.infomap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    Button btnMap, btnSearch;
    TextView txtTitle, txtDis, txtAddress, txtFee;
    CourseModel courseModel, c2, c3;
    List<CourseModel> courseModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        insertData();
        txtTitle = findViewById(R.id.txt_title);
        txtAddress = findViewById(R.id.txt_Address);
        txtDis = findViewById(R.id.txt_Dis);
        txtFee = findViewById(R.id.txt_Fee);
        btnMap=findViewById(R.id.btn_Map);
        btnSearch=findViewById(R.id.btn_Search);

    }


    private void insertData() {
        courseModel = new CourseModel();
        courseModelList = new ArrayList<>();
        courseModel.setTitle("Day hoc tieng anh lop 6");
        courseModel.setDistance(4.5);
        courseModel.setAddress("Ngo 5,Hoang Quoc Viet");
        courseModel.setFee(200000);
        courseModel.setLat(20.345456);
        courseModel.setLon(106.346764);
        c2 = new CourseModel();
        c2.setTitle("Day hoc tieng anh lop 7");
        c2.setDistance(5.5);
        c2.setAddress("Duy Tan,Cau Giay");
        c2.setFee(300000);
        c2.setLat(20.388856);
        c2.setLon(106.3335564);
        c3 = new CourseModel();
        c3.setTitle("Day hoc tieng anh lop 8");
        c3.setDistance(6.5);
        c3.setAddress("Mai Dich,Cau Giay");
        c3.setFee(350000);
        c3.setLat(20.382256);
        c3.setLon(106.987564);

        courseModelList.add(courseModel);
        courseModelList.add(c2);
        courseModelList.add(c3);

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        for (int i = 0; i < courseModelList.size(); i++) {
            LatLng latLng = new LatLng(courseModelList.get(i).getLat(), courseModelList.get(i).getLon());
            mMap.addMarker(new MarkerOptions().title(courseModelList.get(i).getTitle())
                    .snippet(courseModelList.get(i).getAddress()).position(latLng)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.astrology)));

            CameraPosition cameraPosition = CameraPosition.builder().target(latLng).zoom(13).build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 1500, null);

        }
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                for (int j=0;j<courseModelList.size();j++){
                if (marker.getTitle().equals(courseModelList.get(j).getTitle())){
                    txtTitle.setText(marker.getTitle());
                    txtAddress.setText(courseModelList.get(j).getAddress());
                    txtDis.setText(courseModelList.get(j).getDistance()+" km");
                    txtFee.setText(courseModelList.get(j).getFee()+" D/Buoi");
                }
                }
            }
        });
    }

}


