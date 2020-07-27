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

import com.example.myapplication.data.Person;
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

public class PersonSearchActivity extends AppCompatActivity {

    EditText value;
    Button search;

    ListView peopleListView;
    ProgressBar progressBar;

    private Gson gson;
    private Retrofit retrofit;
    private ApiHandler api;
    private HttpLoggingInterceptor interceptor;
    private OkHttpClient client;

    List<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_search);

value = findViewById(R.id.nameSearch);
    search  =findViewById(R.id.button4);
        peopleListView = findViewById(R.id.people_list_view);

        progressBar = findViewById(R.id.progressBar2);
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
    search.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            HashMap<String, String> params = new HashMap<>();
            params.put("value", value.getText().toString());
api.getPeople(params).enqueue(new Callback<List<Person>>() {
    @Override
    public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
        if(response.isSuccessful()){
            Toast.makeText(getApplicationContext(), "تم العثور على بيانات", Toast.LENGTH_LONG).show();
            bindAdapter(response.body());
        }else {
            Toast.makeText(getApplicationContext(), "لا توجد بيانات", Toast.LENGTH_LONG).show();
        }

        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onFailure(Call<List<Person>> call, Throwable t) {
        Toast.makeText(getApplicationContext(), "لا توجد بيانات", Toast.LENGTH_LONG).show();
        progressBar.setVisibility(View.INVISIBLE);
    }
});
        }
    });

    }

    private void bindAdapter(List<Person> body) {
        people = body;
        ArrayList<String> adapterStringArray = new ArrayList<>();
        for(Person p : people ){
            Log.d("V", p.getName());
            adapterStringArray.add("الإسم:" + p.getName() + " \n " + "رقم الهوية:" + p.getId_number() +  " \n " + "المواليد:" + p.getBirth_date() + " \n " + "إسم الأم:" +p.getMother_name());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, adapterStringArray);

        peopleListView.setAdapter(adapter);
        peopleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("person", people.get(i));
                Intent intent = new Intent(PersonSearchActivity.this, peopleData.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}