package com.example.shauryatrivedi.naamkaran.Retrofit;

import java.util.ArrayList;

public class Pojo1 {
    ArrayList<GenderApi> genderData;

    public Pojo1(ArrayList<GenderApi> genderData) {
        this.genderData = genderData;
    }

    public ArrayList<GenderApi> getGenderData() {
        return genderData;
    }

    public void setGenderData(ArrayList<GenderApi> genderData) {
        this.genderData = genderData;
    }
}
