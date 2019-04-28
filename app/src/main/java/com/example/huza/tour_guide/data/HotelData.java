package com.example.huza.tour_guide.data;

import android.provider.ContactsContract;

import java.io.Serializable;

/**
 * Created by huza on 4/24/2019.
 */

public class HotelData implements Serializable {
    private int Id;
    private String Name;
    private String Description;
    private String When;
    private String Where;
    private String Phone;
    private int ImageId;
    private int ColorId;

    public HotelData(int id, String name, String description, String when, String where, String phone, int imageId, int colorId) {
        Id = id;
        Name = name;
        Description = description;
        When = when;
        Where = where;
        Phone = phone;
        ImageId = imageId;
        ColorId = colorId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getWhen() {
        return When;
    }

    public void setWhen(String when) {
        When = when;
    }

    public String getWhere() {
        return Where;
    }

    public void setWhere(String where) {
        Where = where;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public int getColorId() {
        return ColorId;
    }

    public void setColorId(int colorId) {
        ColorId = colorId;
    }
}

