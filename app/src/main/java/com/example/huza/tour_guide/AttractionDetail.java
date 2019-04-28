package com.example.huza.tour_guide;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.huza.tour_guide.data.AttractionData;
import com.example.huza.tour_guide.databinding.ActivityAttractionDetailBinding;

public class AttractionDetail extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     ActivityAttractionDetailBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_attraction_detail);


        Intent intent=getIntent();
       AttractionData attractionData= (AttractionData) intent.getSerializableExtra("ATTRACTION_OBJECT");

       binding.setAttraction(attractionData);

    }
}
