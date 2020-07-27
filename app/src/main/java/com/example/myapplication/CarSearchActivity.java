package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myapplication.data.Vehicle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CarSearchActivity extends AppCompatActivity {

    EditText value;
    Button search;
    ListView vehiclesListView;
    ProgressBar progressBar;

    private Gson gson;
    private Retrofit retrofit;
    private ApiHandler api;
    private HttpLoggingInterceptor interceptor;
    private OkHttpClient client;

    private List<Vehicle> vehicles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_search);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        gson = new GsonBuilder()
                .setLenient()
                .create();

        interceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.getApiUrl())
                .baseUrl(Urls.getApiUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        api = retrofit.create(ApiHandler.class);
        value = findViewById(R.id.editTextTextPersonName2);
search = findViewById(R.id.button3);
vehiclesListView = findViewById(R.id.lst_vehicles);

search.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        progressBar.setVisibility(View.VISIBLE);
        HashMap<String, String> params = new HashMap<>();
        params.put("value", value.getText().toString());
        api.getVehicles(params).enqueue(new Callback<List<Vehicle>>() {
            @Override
            public void onResponse(Call<List<Vehicle>> call, Response<List<Vehicle>> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(getApplicationContext(), "تم العثور علي بيانات", Toast.LENGTH_LONG).show();
                        bindAdapter(response.body());
                    }else {
                        Toast.makeText(getApplicationContext(), "لاتوجد بيانات", Toast.LENGTH_LONG).show();
                    }

                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<List<Vehicle>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "لاتوجد بيانات", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }
});
    }

    private void bindAdapter(List<Vehicle> body) {
    vehicles = body;
        ArrayList<String> adapterStringArray = new ArrayList<>();
        for(Vehicle v : vehicles ){
            Log.d("V", v.getNumber());
            adapterStringArray.add(v.getNumber() + " - " + v.getVendor() +  " - " + v.getModel() + " - " + v.getColor());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, adapterStringArray);

        vehiclesListView.setAdapter(adapter);
        vehiclesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("vehicle", vehicles.get(i));
                Intent intent = new Intent(CarSearchActivity.this, carData.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}