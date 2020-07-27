package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.data.Vehicle;

public class carData extends AppCompatActivity {

    TextView vin, number, vendor, model, color, fuel, year, owner, reg_date, status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_data);

        model = findViewById(R.id.textView20);
        vin = findViewById(R.id.textView11);
        vendor = findViewById(R.id.textView13);
        number = findViewById(R.id.textView12);
        year = findViewById(R.id.textView15);
        reg_date = findViewById(R.id.textView22);
        color = findViewById(R.id.textView14);
        owner = findViewById(R.id.textView16);
        status = findViewById(R.id.textView40);


        Vehicle vehicle = getIntent().getExtras().getParcelable("vehicle");


        model.setText(vehicle.getModel());
        vin.setText(vehicle.getVin());
        vendor.setText(vehicle.getVendor());
        number.setText(vehicle.getNumber());
        year.setText(vehicle.getManufacture_year());
        reg_date.setText(vehicle.getRegistration_date());
        color.setText(vehicle.getColor());
        owner.setText(vehicle.getOwner_name());

    }
}