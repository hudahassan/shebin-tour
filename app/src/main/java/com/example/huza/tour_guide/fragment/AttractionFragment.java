package com.example.huza.tour_guide.fragment;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.example.huza.tour_guide.AttractionDetail;
import com.example.huza.tour_guide.adapter.AttractionAdapter;
import com.example.huza.tour_guide.databinding.FragmentAttractionBinding;
import com.example.huza.tour_guide.R;
import com.example.huza.tour_guide.data.AttractionData;

import java.util.ArrayList;


public class AttractionFragment extends Fragment {



    public AttractionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentAttractionBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_attraction, container, false);

        final ArrayList<AttractionData> item=new ArrayList<AttractionData>();

        String[] name=getResources().getStringArray(R.array.attraction_name);
        String[] shortdesc=getResources().getStringArray(R.array.attraction_description_short);
        String[] longdesc=getResources().getStringArray(R.array.attraction_description_long);
        int[] imageId = { R.drawable.sadat,R.drawable.omar_affendi, R.drawable.stadium, R.drawable.dotsmall,R.drawable.denshawy};

        for(int i=0;i<name.length;i++){
            item.add(new AttractionData(i,name[i],shortdesc[i],longdesc[i],imageId[i]));
        }

        AttractionAdapter adapter=new AttractionAdapter(getActivity(),item);

        binding.listAttraction.setAdapter(adapter);

        binding.listAttraction.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), AttractionDetail.class);
                intent.putExtra("ATTRACTION_OBJECT", item.get(i));

                //Fancy animation for Android 5.0+
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Pair p1 = Pair.create(view.findViewById(R.id.image_attraction), "attraction_image");
                    Pair p2 = Pair.create(view.findViewById(R.id.text_attraction), "attraction_text");
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(getActivity(), p1, p2);
                    startActivity(intent, options.toBundle());
                } else startActivity(intent);
            }
        });

        return binding.getRoot();
    }
    @BindingAdapter("android:src")
    public static void setImageResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);


    }
}