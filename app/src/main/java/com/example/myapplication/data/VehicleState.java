package com.example.myapplication.data;

import android.os.Parcel;
import android.os.Parcelable;

public class VehicleState implements Parcelable {
    private String id;
    private String type;
    private String number;
    private String plate_type;
    private String vendor = null;
    private String model;
    private String color;
    private String design;
    private String fuel;
    private String vin;
    private String owner_name;
    private String complaint;
    private String complaint_phone_number;
    private String mother_name;
    private String birth_date;
    private String id_card_number;
    private String residence;
    private String police_station;
    private String informer_grade = null;
    private String informer_name = null;
    private String crime_date;
    private String crime_place;
    private String notes;
    private String is_found;
    private String db_origin;


    // Getter Methods

    protected VehicleState(Parcel in) {
        id = in.readString();
        type = in.readString();
        number = in.readString();
        plate_type = in.readString();
        vendor = in.readString();
        model = in.readString();
        color = in.readString();
        design = in.readString();
        fuel = in.readString();
        vin = in.readString();
        owner_name = in.readString();
        complaint = in.readString();
        complaint_phone_number = in.readString();
        mother_name = in.readString();
        birth_date = in.readString();
        id_card_number = in.readString();
        residence = in.readString();
        police_station = in.readString();
        informer_grade = in.readString();
        informer_name = in.readString();
        crime_date = in.readString();
        crime_place = in.readString();
        notes = in.readString();
        is_found = in.readString();
        db_origin = in.readString();
    }

    public static final Creator<VehicleState> CREATOR = new Creator<VehicleState>() {
        @Override
        public VehicleState createFromParcel(Parcel in) {
            return new VehicleState(in);
        }

        @Override
        public VehicleState[] newArray(int size) {
            return new VehicleState[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public String getPlate_type() {
        return plate_type;
    }

    public String getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
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

    public String getOwner_name() {
        return owner_name;
    }

    public String getComplaint() {
        return complaint;
    }

    public String getComplaint_phone_number() {
        return complaint_phone_number;
    }

    public String getMother_name() {
        return mother_name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public String getId_card_number() {
        return id_card_number;
    }

    public String getResidence() {
        return residence;
    }

    public String getPolice_station() {
        return police_station;
    }

    public String getInformer_grade() {
        return informer_grade;
    }

    public String getInformer_name() {
        return informer_name;
    }

    public String getCrime_date() {
        return crime_date;
    }

    public String getCrime_place() {
        return crime_place;
    }

    public String getNotes() {
        return notes;
    }

    public String getIs_found() {
        return is_found;
    }

    public String getDb_origin() {
        return db_origin;
    }

    // Setter Methods

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPlate_type(String plate_type) {
        this.plate_type = plate_type;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setModel(String model) {
        this.model = model;
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

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public void setComplaint_phone_number(String complaint_phone_number) {
        this.complaint_phone_number = complaint_phone_number;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public void setId_card_number(String id_card_number) {
        this.id_card_number = id_card_number;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public void setPolice_station(String police_station) {
        this.police_station = police_station;
    }

    public void setInformer_grade(String informer_grade) {
        this.informer_grade = informer_grade;
    }

    public void setInformer_name(String informer_name) {
        this.informer_name = informer_name;
    }

    public void setCrime_date(String crime_date) {
        this.crime_date = crime_date;
    }

    public void setCrime_place(String crime_place) {
        this.crime_place = crime_place;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setIs_found(String is_found) {
        this.is_found = is_found;
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
        parcel.writeString(id);
        parcel.writeString(type);
        parcel.writeString(number);
        parcel.writeString(plate_type);
        parcel.writeString(vendor);
        parcel.writeString(model);
        parcel.writeString(color);
        parcel.writeString(design);
        parcel.writeString(fuel);
        parcel.writeString(vin);
        parcel.writeString(owner_name);
        parcel.writeString(complaint);
        parcel.writeString(complaint_phone_number);
        parcel.writeString(mother_name);
        parcel.writeString(birth_date);
        parcel.writeString(id_card_number);
        parcel.writeString(residence);
        parcel.writeString(police_station);
        parcel.writeString(informer_grade);
        parcel.writeString(informer_name);
        parcel.writeString(crime_date);
        parcel.writeString(crime_place);
        parcel.writeString(notes);
        parcel.writeString(is_found);
        parcel.writeString(db_origin);
    }
}
