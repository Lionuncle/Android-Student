package com.example.android_student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView name;
    TextView regNumber;
    TextView cnic;
    TextView hobbies;
    TextView cgpa;
    static TextView datepicker;
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
        datepicker = findViewById(R.id.datePickerText);
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
                    Toast.makeText(MainActivity.this, student.getGender(cnic.getText().toString()), Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        getAge.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                try{


                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        getNoOfWords.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                try{
                    Toast.makeText(MainActivity.this, String.valueOf(student.getNumberOfWords(name.getText().toString())), Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        getStatus.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                try{
                    Toast.makeText(MainActivity.this, student.getStatus(Double.valueOf(cgpa.getText().toString())), Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });



    }//onCreate
    ///////////////////////////////date picker
    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            Date d = new Date();
            d.se
            datepicker.setText(day+"/"+month+"/"+year);

        }
    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
