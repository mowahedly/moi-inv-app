package com.example.myapplication.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    private String id;
    private String type;
    private String name;
    private String nickname;
    private String mother_name;
    private String birth_date;
    private String id_number;
    private String nationality;
    private String details;
    private String complaint_name;
    private String complaint_phone;
    private String created_at;
    private String origin_name;


    // Getter Methods

    protected Person(Parcel in) {
        id = in.readString();
        type = in.readString();
        name = in.readString();
        nickname = in.readString();
        mother_name = in.readString();
        birth_date = in.readString();
        id_number = in.readString();
        nationality = in.readString();
        details = in.readString();
        complaint_name = in.readString();
        complaint_phone = in.readString();
        created_at = in.readString();
        origin_name = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getMother_name() {
        return mother_name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public String getId_number() {
        return id_number;
    }

    public String getNationality() {
        return nationality;
    }

    public String getDetails() {
        return details;
    }

    public String getComplaint_name() {
        return complaint_name;
    }

    public String getComplaint_phone() {
        return complaint_phone;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getOrigin_name() {
        return origin_name;
    }

    // Setter Methods

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setComplaint_name(String complaint_name) {
        this.complaint_name = complaint_name;
    }

    public void setComplaint_phone(String complaint_phone) {
        this.complaint_phone = complaint_phone;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setOrigin_name(String origin_name) {
        this.origin_name = origin_name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(type);
        parcel.writeString(name);
        parcel.writeString(nickname);
        parcel.writeString(mother_name);
        parcel.writeString(birth_date);
        parcel.writeString(id_number);
        parcel.writeString(nationality);
        parcel.writeString(details);
        parcel.writeString(complaint_name);
        parcel.writeString(complaint_phone);
        parcel.writeString(created_at);
        parcel.writeString(origin_name);
    }
}
