package com.example.huza.tour_guide;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.huza.tour_guide.data.HotelData;
import com.example.huza.tour_guide.databinding.ActivityDetailBinding;

public class HotelDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        //Get the passed object from HotelFragment
        final Intent intent = getIntent();
        final HotelData hotel = (HotelData) intent.getSerializableExtra("ACTIVITY_OBJECT");

        //Set the object on layout using Data binding library
        binding.setHotel(hotel);

        //Setting clickListener to open map of the given location

        binding.buttonMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(hotel.getWhere()));
            if(intent.resolveActivity(getPackageManager())!=null){
                startActivity(intent);            }

            }
        });


        binding.buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",hotel.getPhone(),null)) ;

                startActivity(intent1);
            }
        });
    }
}

