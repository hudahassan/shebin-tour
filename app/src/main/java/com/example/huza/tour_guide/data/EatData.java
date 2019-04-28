package com.example.huza.tour_guide.data;

import java.io.Serializable;

/**
 * Created by huza on 4/24/2019.
 */

public class EatData implements Serializable {
   private int mImage;
    private String Name;
    private String location;

    public EatData(int mImage, String name, String location) {
        this.mImage = mImage;
        this.Name = name;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
