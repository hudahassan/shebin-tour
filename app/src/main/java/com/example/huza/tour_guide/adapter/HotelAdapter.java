package com.example.huza.tour_guide.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.huza.tour_guide.R;
import com.example.huza.tour_guide.data.HotelData;
import com.example.huza.tour_guide.databinding.ListItemActivitiesBinding;

import java.util.ArrayList;

/**
 * Created by huza on 4/24/2019.
 */

public class HotelAdapter extends ArrayAdapter {
    ArrayList<HotelData> item=new ArrayList<HotelData>();

    public HotelAdapter(@NonNull Context context, ArrayList<HotelData> item) {
        super(context, 0,item);
        this.item=item;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public int getPosition(@Nullable Object item) {
        return getPosition(item);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        ListItemActivitiesBinding activitiesBinding;

        public ViewHolder(ListItemActivitiesBinding activitiesBinding) {
            this.activitiesBinding = activitiesBinding;
        }
        public void bind(HotelData hotelData){
            activitiesBinding.setHotel(hotelData);
            activitiesBinding.executePendingBindings();
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            ListItemActivitiesBinding binding;
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item_activities, parent, false);
            convertView=binding.getRoot();
            viewHolder=new ViewHolder(binding);
            convertView.setTag(viewHolder);
        }
        else
            viewHolder= (ViewHolder) convertView.getTag();
        viewHolder.bind(item.get(position));
        return convertView;

    }

}



