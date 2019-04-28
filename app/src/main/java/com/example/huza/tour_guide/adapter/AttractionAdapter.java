package com.example.huza.tour_guide.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.example.huza.tour_guide.data.AttractionData;
import com.example.huza.tour_guide.R;
import com.example.huza.tour_guide.databinding.ListItemAttractionBinding;


import java.util.ArrayList;

/**
 * Created by ankurg22 on 1/8/17.
 */

public class AttractionAdapter extends ArrayAdapter {
    private ArrayList<AttractionData> item = new ArrayList<AttractionData>();

    public AttractionAdapter(Context context,  ArrayList<AttractionData> item) {
        super(context, 0, item);
        this.item = item;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        if (convertView == null) {
            ListItemAttractionBinding binding;
            binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_attraction, parent, false);
            convertView = binding.getRoot();
            viewHolder = new ViewHolder(binding);
            convertView.setTag(viewHolder);


        } else viewHolder = (ViewHolder) convertView.getTag();

        viewHolder.bind(item.get(position));
        return convertView;
    }

    private class ViewHolder {
        private final ListItemAttractionBinding itemBinding;

        public ViewHolder(ListItemAttractionBinding binding) {
            this.itemBinding = binding;
        }

        public void bind(AttractionData attraction) {
            itemBinding.setAttraction(attraction);
            itemBinding.executePendingBindings();
        }
    }
}

