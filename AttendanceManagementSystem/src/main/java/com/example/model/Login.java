package com.example.model;

public class Login {
    private int id;
    private String username;
    private String password;
    private String todaydate;

    public Login() {
    }

    public Login(int id, String username, String password, String todaydate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.todaydate = todaydate;
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Login(String username, String password, String todaydate) {
        this.username = username;
        this.password = password;
        this.todaydate = todaydate;
    }

    public Login(String todaydate) {
        this.todaydate = todaydate;
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

    public String getTodaydate() {
        return todaydate;
    }

    public void setTodaydate(String todaydate) {
        this.todaydate = todaydate;
    }
}
