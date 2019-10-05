package com.example.android_student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
    public static int currentYear;
    public static int currentMonth;
    public static int currentDay;

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
                    String[] hob = new String[20];hob[0] = hobbies.getText().toString();
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
                    Toast.makeText(MainActivity.this, String.valueOf(student.getNumberOfWords()), Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        getStatus.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                try{
                    Toast.makeText(MainActivity.this, student.getStatus(), Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        getAge.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(MainActivity.this, String.valueOf(student.getAge(currentYear,currentMonth,currentDay)), Toast.LENGTH_SHORT).show();
            }
        });

        getInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog fbDialogue = new Dialog(getBaseContext(), android.R.style.Theme_Black_NoTitleBar);
                fbDialogue.getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(100, 0, 0, 0)));
                fbDialogue.setContentView(R.layout.popup);
                TextView info = findViewById(R.id.infoTextFragment);
                String msg = "Name: "+name.getText()+" (Contains "+student.getNumberOfWords()+" words)\n"
                        +"Registeration Number: "+student.getRegNumber()+"\n"
                        +"Date of birth: "+currentDay+"/"+currentMonth+"/"+currentYear+"Age( "+student.getAge(currentYear,currentMonth,currentDay)
                        +"Years) "
                        +"CNIC: "+student.getCnic()
                        +"Gender: "+student.getGender()
                        +"Hobbies: "+student.getHobbies();
                info.setText(msg);
                fbDialogue.setCancelable(true);
                fbDialogue.show();
            }
        });



    }//onCreate
    ///////////////////////////////date picker
    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {

            int cYear = Calendar.getInstance().get(Calendar.YEAR);
            int cMonth = Calendar.getInstance().get(Calendar.MONTH);
            int cDay = Calendar.getInstance().get(Calendar.YEAR);
            datepicker.setText(day+"/"+month+"/"+year);
            currentYear = year;
            currentMonth = month;
            currentDay = day;

        }
    }
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
