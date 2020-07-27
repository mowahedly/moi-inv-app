package com.example.myapplication;

import com.example.myapplication.data.Person;
import com.example.myapplication.data.Vehicle;
import com.example.myapplication.data.VehicleState;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiHandler {

    @GET(Urls.VEHICLES)
    Call<List<Vehicle>> getVehicles(@QueryMap HashMap<String, String> params);

    @GET(Urls.PEOPLE)
    Call<List<Person>> getPeople(@QueryMap HashMap<String, String> params);

    @GET(Urls.VEHICLE_CHECK)
    Call<List<VehicleState>> checkVehicles(@QueryMap HashMap<String, String> params);

}
