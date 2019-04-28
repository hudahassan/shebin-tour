package com.example.huza.tour_guide.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;


import com.example.huza.tour_guide.HotelDetail;
import com.example.huza.tour_guide.adapter.HotelAdapter;
import com.example.huza.tour_guide.databinding.FragmentActivitiesBinding;
import com.example.huza.tour_guide.data.HotelData;

import com.example.huza.tour_guide.R;

import java.util.ArrayList;


public class HotelFragment extends Fragment {

    public HotelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final FragmentActivitiesBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_activities, container, false);

        //Get list of Activities
        final ArrayList<HotelData> activityList = new ArrayList<HotelData>();

        String[] name = getResources().getStringArray(R.array.hotels_name);
        String[] desc = getResources().getStringArray(R.array.hotels_description);
        String[] when = getResources().getStringArray(R.array.hotels_when);
        String[] where = getResources().getStringArray(R.array.hotels_where);
        String[] phone = getResources().getStringArray(R.array.hotels_phone);
        int[] imageId = {R.drawable.hotel1, R.drawable.hotel3, R.drawable.hotel4, R.drawable.hotel5};
        int[] color = new int[]{R.color.one, R.color.two, R.color.three, R.color.four};

        for (int i = 0; i < name.length; i++) {
            activityList.add(new HotelData(i, name[i], desc[i], when[i], where[i], phone[i], imageId[i], color[i]));
        }

        //Initialize adapter and set on ListView
        HotelAdapter hotelAdapter = new HotelAdapter(getActivity(),activityList);
        binding.listActivity.setAdapter(hotelAdapter);

        //Set OnItemClickListener on ListView to open details activity(ActDetailsActivity) for respective activity.
        binding.listActivity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(),HotelDetail.class);
                intent.putExtra("ACTIVITY_OBJECT", activityList.get(i));

                //Fancy animation for Android 5.0+
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Pair p1 = Pair.create(view.findViewById(R.id.activity_image), "image");
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(getActivity(), p1);
                    startActivity(intent, options.toBundle());
                } else startActivity(intent);
            }
        });

        return binding.getRoot();
    }




}
