package com.example.android_student;

import java.util.Date;

public class Student {
    String name;
    String regNumber;
    Date dateOfBirth;
    double cgpa;
    String cnic;
    String[] hobbies= new String[10];
//constructors
    public Student() { }

    public Student(String name, String regNumber) {
        this.name = name;
        this.regNumber = regNumber;
    }
//methods
    public String getGender(){
        char[] chars = cnic.toCharArray();
        return String.valueOf(chars.length);
        /*if(chars[chars.length -1] % 2 == 0){
            return "FEMALE";
        }
        else return "Male";*/
    }
//getter setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }
}
