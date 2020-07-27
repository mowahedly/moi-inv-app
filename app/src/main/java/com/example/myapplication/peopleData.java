package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.data.Person;

public class peopleData extends AppCompatActivity {
    TextView type, name, mother_name, nickname, id_number, birth_date, nationality, details, date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_data);

        type = findViewById(R.id.p_type);
        name = findViewById(R.id.p_name);
        mother_name = findViewById(R.id.p_mother_name);
        nickname = findViewById(R.id.p_nuck_name);
        id_number = findViewById(R.id.p_id_number);
        birth_date = findViewById(R.id.p_birth_date);
        nationality = findViewById(R.id.p_nationality);
        details= findViewById(R.id.p_details);
        date = findViewById(R.id.p_date);

        Person person = getIntent().getExtras().getParcelable("person");

        name.setText(person.getName());
        mother_name.setText(person.getMother_name());
        nickname.setText(person.getNickname());
        id_number.setText(person.getId_number());
        birth_date.setText(person.getBirth_date());
        nationality.setText(person.getNationality());
        details.setText(person.getDetails());
        date.setText(person.getCreated_at());

        switch (person.getType()) {
            case "wanted":
                type.setText("مطلوب");
                break;
            case "hijacked":
                type.setText("مخطوف");
                break;
            case "missing":
                type.setText("مفقود");
                break;
        }
    }
}