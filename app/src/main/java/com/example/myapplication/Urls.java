package com.example.myapplication;

public class Urls {

    private static final String IP = "192.168.1.35";
    private static final String SYSTEM_API = "http://" + IP + "/reporting-api/public/api/";


    public static String getApiUrl() {
        return SYSTEM_API;
    }

    public static final String VEHICLES = "vehicles";
    public static final String VEHICLE_CHECK = "vehicles/check";
    public static final String PEOPLE = "people";
}
