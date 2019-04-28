package com.example.huza.tour_guide.data;

import java.io.Serializable;

/**
 * Created by huza on 4/24/2019.
 */

public class AttractionData implements Serializable {
    private int mId;
    private String Name;
    private String ShortDescription;
    private String LongDescription;
    private int Image;

    public AttractionData(int mId, String name, String shortDescription, String longDescription, int Image) {
        this.mId = mId;
        Name = name;
        ShortDescription = shortDescription;
        LongDescription = longDescription;
        this.Image = Image;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getShortDescription() {
        return ShortDescription;
    }

    public void setShortDescription(String shortDescription) {
        ShortDescription = shortDescription;
    }

    public String getLongDescription() {
        return LongDescription;
    }

    public void setLongDescription(String longDescription) {
        LongDescription = longDescription;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int Image) {
        this.Image = Image;
    }
}
