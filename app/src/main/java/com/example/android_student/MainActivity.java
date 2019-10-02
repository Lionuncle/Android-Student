package com.example.android_student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView name;
    TextView regNumber;
    TextView cnic;
    TextView hobbies;
    TextView cgpa;
    Button getAge;
    Button getStatus;
    Button getGender;
    Button getNoOfWords;
    Button getInfo;
    Button save;
    Student student = new Student();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.textName);
        regNumber = findViewById(R.id.textRegNumber);
        cnic = findViewById(R.id.textCnic);
        hobbies = findViewById(R.id.textHobbies);
        cgpa = findViewById(R.id.textCGPA);

        getAge =findViewById(R.id.btnGetAge);
        getGender= findViewById(R.id.btnGetGender);
        getInfo =findViewById(R.id.btnInfo);
        getStatus = findViewById(R.id.btnGetStatus);
        getNoOfWords = findViewById(R.id.btnNumberOfWords);
        save = findViewById(R.id.btnSave);


        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                try{
                    student.setName(name.getText().toString());
                    student.setCgpa( Double.valueOf(cgpa.getText().toString()) );
                    student.setRegNumber(regNumber.getText().toString());
                    student.setCnic(cnic.getText().toString());
                    String[] hob = new String[20];
                    hob[0] = hobbies.getText().toString();
                    student.setHobbies(hob);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }


            }
        });


        getGender.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                try {
                    Toast.makeText(MainActivity.this, student.getGender(), Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
