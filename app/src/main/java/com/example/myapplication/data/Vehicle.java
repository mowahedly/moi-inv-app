package com.example.myapplication.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Vehicle implements Parcelable {
    private String number;
    private String vendor;
    private String model;
    private String manufacture_year;
    private String manufacture_origin;
    private String color;
    private String design;
    private String fuel;
    private String vin;
    private String registration_date;
    private String owner_name;
    private String db_origin;


    // Getter Methods

    protected Vehicle(Parcel in) {
        number = in.readString();
        vendor = in.readString();
        model = in.readString();
        manufacture_year = in.readString();
        manufacture_origin = in.readString();
        color = in.readString();
        design = in.readString();
        fuel = in.readString();
        vin = in.readString();
        registration_date = in.readString();
        owner_name = in.readString();
        db_origin = in.readString();
    }

    public static final Creator<Vehicle> CREATOR = new Creator<Vehicle>() {
        @Override
        public Vehicle createFromParcel(Parcel in) {
            return new Vehicle(in);
        }

        @Override
        public Vehicle[] newArray(int size) {
            return new Vehicle[size];
        }
    };

    public String getNumber() {
        return number;
    }

    public String getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public String getManufacture_year() {
        return manufacture_year;
    }

    public String getManufacture_origin() {
        return manufacture_origin;
    }

    public String getColor() {
        return color;
    }

    public String getDesign() {
        return design;
    }

    public String getFuel() {
        return fuel;
    }

    public String getVin() {
        return vin;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public String getDb_origin() {
        return db_origin;
    }

    // Setter Methods

    public void setNumber(String number) {
        this.number = number;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacture_year(String manufacture_year) {
        this.manufacture_year = manufacture_year;
    }

    public void setManufacture_origin(String manufacture_origin) {
        this.manufacture_origin = manufacture_origin;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public void setDb_origin(String db_origin) {
        this.db_origin = db_origin;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(number);
        parcel.writeString(vendor);
        parcel.writeString(model);
        parcel.writeString(manufacture_year);
        parcel.writeString(manufacture_origin);
        parcel.writeString(color);
        parcel.writeString(design);
        parcel.writeString(fuel);
        parcel.writeString(vin);
        parcel.writeString(registration_date);
        parcel.writeString(owner_name);
        parcel.writeString(db_origin);
    }
}
