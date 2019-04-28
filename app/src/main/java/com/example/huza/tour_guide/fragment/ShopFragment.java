package com.example.huza.tour_guide.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.example.huza.tour_guide.adapter.ShopAdapter;
import com.example.huza.tour_guide.databinding.FragmentShopBinding;

import com.example.huza.tour_guide.R;
import com.example.huza.tour_guide.data.ShopData;

import java.util.ArrayList;


public class ShopFragment extends Fragment {

    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final FragmentShopBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shop, container, false);

        final ArrayList<ShopData> item = new ArrayList<ShopData>();
        String[] name = getResources().getStringArray(R.array.shop_name);
        final String[] detail = getResources().getStringArray(R.array.shop_details);
        int[] image =  {R.drawable.women_colthes, R.drawable.men, R.drawable.syrian_market,
                R.drawable.baby, R.drawable.shoes_shop, R.drawable.accessories,R.drawable.women_colth};


        for (int i = 0; i < name.length; i++) {
            item.add(new ShopData(image[i], name[i], detail[i]));
        }

        ShopAdapter adapter = new ShopAdapter(getActivity(), item);

        binding.listShop.setAdapter(adapter);

        binding.listShop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ImageView view1=new ImageView(getActivity());
                view1.setImageResource(item.get(position).getmImage());
                view1.setScaleType(ImageView.ScaleType.CENTER_CROP);
                view1.setMaxHeight(45);
                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity())
                       .setView(view1)
                           .setTitle(item.get(position).getName())
                      .setMessage(item.get(position).getmDetail());

                AlertDialog dialog=builder.create();
                dialog.show();
                dialog.getWindow().setLayout(500,800);
            }
        });

        return binding.getRoot();
    }
}



