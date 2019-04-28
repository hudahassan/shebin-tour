package com.example.huza.tour_guide.fragment;

import android.app.AlertDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.example.huza.tour_guide.R;
import com.example.huza.tour_guide.adapter.EatAdapter;
import com.example.huza.tour_guide.data.EatData;
import com.example.huza.tour_guide.databinding.FragmentEatBinding;

import java.util.ArrayList;


public class EatFragment extends Fragment {


    public EatFragment() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final FragmentEatBinding binding= DataBindingUtil.inflate(inflater,R.layout.fragment_eat,container,false);

        final ArrayList<EatData> item=new ArrayList<EatData>();
        String[] name=getResources().getStringArray(R.array.eat_name);
        String[] location=getResources().getStringArray(R.array.eat_where);
        int[] image=new int[]{R.drawable.crip, R.drawable.pizza, R.drawable.shawrma, R.drawable.shrimp,
                R.drawable.elflah, R.drawable.m4awy, R.drawable.pasta, R.drawable.icecream, R.drawable.coffee, R.drawable.coffee};

        for (int i=0;i<name.length;i++){
            item.add(new EatData(image[i],name[i],location[i]));
        }

        EatAdapter adapter=new EatAdapter(getActivity(),item);
        binding.listEat.setAdapter(adapter);

        binding.listEat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView view1=new ImageView(getActivity());
                view1.setImageResource(item.get(position).getmImage());
                view1.setScaleType(ImageView.ScaleType.CENTER_CROP);

                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity())
                        .setView(view1)
                        .setTitle(item.get(position).getName())
                         .setMessage(item.get(position).getLocation());


                AlertDialog dialog=builder.create();
                dialog.show();



            }
        });
        return binding.getRoot();
    }

}