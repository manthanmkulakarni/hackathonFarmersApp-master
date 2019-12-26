package com.arshilgenius.kisan.agriculture;

public class FarmerData {
    private String email,name,place;

    public FarmerData(String d1,String d2,String d3){
        this.email=d1;
        this.name=d2;
        this.place=d3;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPlace() {
        return place;
    }
}
