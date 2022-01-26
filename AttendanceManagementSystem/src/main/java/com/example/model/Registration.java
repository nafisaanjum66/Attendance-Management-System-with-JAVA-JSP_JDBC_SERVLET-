package com.example.model;

public class Registration {
    public int id;
    public String username;
    public String password;
    public String fullname;
    public String mobile;
    public String dob;
    public String qualification;

    public Registration() {
    }

    public Registration(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Registration(int id, String username, String password, String fullname, String mobile, String dob, String qualification) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.mobile = mobile;
        this.dob = dob;
        this.qualification = qualification;
    }

    public Registration(String username, String password, String fullname, String mobile, String dob, String qualification) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.mobile = mobile;
        this.dob = dob;
        this.qualification = qualification;
    }

    public Registration( String username ,String fullname, String mobile, String dob, String qualification) {
        this.username = username;
        this.fullname = fullname;
        this.mobile = mobile;
        this.dob = dob;
        this.qualification = qualification;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
