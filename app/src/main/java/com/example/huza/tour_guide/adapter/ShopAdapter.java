package com.example.huza.tour_guide.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import com.example.huza.tour_guide.R;

import  com.example.huza.tour_guide.data.ShopData;
import com.example.huza.tour_guide.databinding.ListItemShopBinding;

/**
 * Created by huza on 4/24/2019.
 */

public class ShopAdapter extends ArrayAdapter{
    ArrayList<ShopData> item=new ArrayList<ShopData>();

    public ShopAdapter(@NonNull Context context, ArrayList<ShopData> item) {
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
        ListItemShopBinding itemShopBinding;

        public ViewHolder(ListItemShopBinding itemShopBinding) {
            this.itemShopBinding = itemShopBinding;
        }
        public void bind(ShopData shopData){
            itemShopBinding.setShop(shopData);
            itemShopBinding.executePendingBindings();
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            ListItemShopBinding binding;
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.list_item_shop, parent, false);
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