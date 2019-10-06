package com.example.android_student;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import java.util.Calendar;
import java.util.Objects;

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
    Boolean isCompleteInfo = false;
    private static int count =0;
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
                    if(!name.getText().toString().matches(""))
                    {
                        student.setName(name.getText().toString());
                        count++;
                        // not null not empty
                    }else {
                        //null or empty
                        name.setHintTextColor(Color.RED);
                        //Toast.makeText(MainActivity.this, "Please enter name", Toast.LENGTH_SHORT).show();
                    }
                    if(!cgpa.getText().toString().matches(""))
                    {
                        if (Double.valueOf(cgpa.getText().toString()) >1.0 && (Double.valueOf(cgpa.getText().toString())<4.0 )){

                            student.setCgpa( Double.valueOf(cgpa.getText().toString()) );
                            count++;
                        }
                        else {
                            Toast.makeText(MainActivity.this, "GPA must be between 1.0 & 4.0", Toast.LENGTH_SHORT).show();
                            cgpa.setText("");
                            cgpa.setHintTextColor(Color.RED);
                        }
                        // not null not empty
                    }else {
                        //null or empty
                        cgpa.setHintTextColor(Color.RED);
                    }
                    if(!regNumber.getText().toString().matches(""))
                    {
                        student.setRegNumber(regNumber.getText().toString());
                        count++;
                        // not null not empty
                    }else {
                        //null or empty
                        regNumber.setHintTextColor(Color.RED);
                    }
                    if(!cnic.getText().toString().matches(""))
                    {
                        if ((cnic.getText().toString().length())==13){
                            student.setCnic(cnic.getText().toString());
                            count++;
                        }
                        else {
                            Toast.makeText(MainActivity.this, "CNIC must be 13 digits", Toast.LENGTH_SHORT).show();
                            cnic.setText("");
                            cnic.setHintTextColor(Color.RED);
                        }
                        // not null not empty
                    }else {
                        cnic.setHintTextColor(Color.RED);
                        //null or empty
                    }
                    if(!hobbies.getText().toString().matches(""))
                    {
                        String[] hob = new String[20];hob[0] = hobbies.getText().toString();
                        student.setHobbies(hob);
                        count++;
                        // not null not empty
                    }else {
                        hobbies.setHintTextColor(Color.RED);
                        //null or empty
                    }
                    if (!(count == 5)){
                        //Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                        isCompleteInfo = false;
                    }
                    else{
                        Toast.makeText(MainActivity.this, "saved!", Toast.LENGTH_SHORT).show();
                        isCompleteInfo = true;
                    }



                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }


            }
        });


        getGender.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                try {
                    if(!isCompleteInfo){
                        Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                        return;
                    }

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
                    if(!isCompleteInfo){
                        Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Toast.makeText(MainActivity.this, student.getAge(currentYear,currentMonth,currentDay)+" Years old", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        getNoOfWords.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                try{
                    if(!isCompleteInfo){
                        Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Toast.makeText(MainActivity.this, String.valueOf(student.getNumberOfWords()), Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        getStatus.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                try{
                    if(!isCompleteInfo){
                        Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Toast.makeText(MainActivity.this, student.getStatus(), Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });


        getInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(!isCompleteInfo){
                        Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String msg = "Name: "+name.getText()+" (Contains "+student.getNumberOfWords()+" words)\n"
                            +"Registeration Number: "+student.getRegNumber()+"\n"
                            +"CGPA: "+student.getCgpa()+" "+student.getStatus()+"\n"
                            +"Date of birth: "+currentDay+"/"+currentMonth+"/"+currentYear+"Age( "+student.getAge(currentYear,currentMonth,currentDay)
                            +" Years) "+"\n"
                            +"CNIC: "+student.getCnic()+"\n"
                            +"Gender: "+student.getGender()+"\n"
                            +"Hobbies: "+ student.getHobbies()[0];
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });



    }//onCreate

    ///////////////////////////////date picker
    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(Objects.requireNonNull(getActivity()), this, year, month, day);
        }

        @SuppressLint("SetTextI18n")
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
