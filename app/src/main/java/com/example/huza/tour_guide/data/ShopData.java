package com.example.huza.tour_guide.data;

import java.io.Serializable;

/**
 * Created by huza on 4/24/2019.
 */

public class ShopData implements Serializable {
    private int mImage;
    private String Name;
    private String mDetail;

    public ShopData(int mImage, String name, String mDetail) {
        this.mImage = mImage;
        Name = name;
        this.mDetail = mDetail;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getmDetail() {
        return mDetail;
    }

    public void setmDetail(String mDetail) {
        this.mDetail = mDetail;
    }
}
