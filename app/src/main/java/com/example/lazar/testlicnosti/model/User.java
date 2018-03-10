package com.example.lazar.testlicnosti.model;

import java.util.Date;

/**
 * Created by Lazar on 2/26/18.
 */

public class User {

    public String gender;
    public String age;
    public String education;
    public String currentTime;

    public User(String gender, String age) {
        this.gender = gender;
        this.age = age;
    }

    public User() {

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
}
