package com.example.infomap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class Main2Activity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    Button btnMap, btnSearch;
    TextView txtName, txtDis, txtAddress, txtFee,txtRating,txtSubject;
    TeacherModel t1,t2,t3;
    List<TeacherModel> teacherModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        insertData();
        txtName = findViewById(R.id.txt_name);
        txtRating=findViewById(R.id.txt_Rating);
        txtSubject=findViewById(R.id.txt_Subject);
        txtAddress = findViewById(R.id.txt_Address);
        txtDis = findViewById(R.id.txt_Dis);
        txtFee = findViewById(R.id.txt_Fee);
    }

    private void insertData() {
        t1=new TeacherModel();
        t2=new TeacherModel();
        t3= new TeacherModel();
        teacherModelList= new ArrayList<>();
        t1.setName("La Ngoc Anh");
        t1.setRating(8);
        t1.setDistance(4.5);
        t1.setSubject("Toan,Hoa,Sinh");
        t1.setAddress("Ngo 5,Hoang Quoc Viet");
        t1.setFee(200000);
        t1.setLat(20.345456);
        t1.setLon(106.346764);

        t2.setName("Phan trong dat");
        t2.setRating(8.5);
        t2.setDistance(6.5);
        t2.setSubject("Van,Su,Dia");
        t2.setAddress("Mai Co,Ba Dinh");
        t2.setFee(300000);
        t2.setLat(20.340956);
        t2.setLon(106.312764);

        t3.setName("Lam Anh Tu");
        t3.setRating(7);
        t3.setDistance(2.5);
        t3.setSubject("Anh,Ly");
        t3.setAddress("So 7, Hoang Mai");
        t3.setFee(150000);
        t3.setLat(20.39856);
        t3.setLon(106.320964);

        teacherModelList.add(t1);
        teacherModelList.add(t2);
        teacherModelList.add(t3);





    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        for (int i = 0; i < teacherModelList.size(); i++) {
            LatLng latLng = new LatLng(teacherModelList.get(i).getLat(), teacherModelList.get(i).getLon());
            mMap.addMarker(new MarkerOptions().title(teacherModelList.get(i).getName())
                    .snippet(teacherModelList.get(i).getAddress()).position(latLng)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.astrology)));

            CameraPosition cameraPosition = CameraPosition.builder().target(latLng).zoom(13).build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 1500, null);

        }
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                for (int j=0;j<teacherModelList.size();j++){
                    if (marker.getTitle().equals(teacherModelList.get(j).getName())){
                        txtName.setText(marker.getTitle());
                        txtRating.setText(teacherModelList.get(j).getRating()+"");
                        txtSubject.setText(teacherModelList.get(j).getSubject()+"");
                        txtAddress.setText(teacherModelList.get(j).getAddress());
                        txtDis.setText(teacherModelList.get(j).getDistance()+" km");
                        txtFee.setText(teacherModelList.get(j).getFee()+" D/Buoi");
                    }
                }
            }
        });
    }

}


