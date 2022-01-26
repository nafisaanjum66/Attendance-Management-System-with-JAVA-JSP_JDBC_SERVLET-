package com.example.model;

public class Student {
    public int id;
    public String username;
    public String todaydate;
    public String sname;
    public String rollno;
    public String course;
    public String semester;
    public String branch;
    public String attendance;

    public Student() {
    }

    public Student(int id, String username, String todaydate, String sname, String rollno, String course, String semester, String branch, String attendance) {
        this.id = id;
        this.username = username;
        this.todaydate = todaydate;
        this.sname = sname;
        this.rollno = rollno;
        this.course = course;
        this.semester = semester;
        this.branch = branch;
        this.attendance = attendance;
    }

    public Student(int id, String sname, String rollno, String course, String semester, String branch, String attendance) {
        this.id = id;
        this.sname = sname;
        this.rollno = rollno;
        this.course = course;
        this.semester = semester;
        this.branch = branch;
        this.attendance = attendance;
    }

    public Student(String username, String todaydate, String sname, String rollno, String course, String semester, String branch, String attendance) {
        this.username = username;
        this.todaydate = todaydate;
        this.sname = sname;
        this.rollno = rollno;
        this.course = course;
        this.semester = semester;
        this.branch = branch;
        this.attendance = attendance;
    }

    public Student(int id, String username, String todaydate, String sname, String rollno, String course, String semester, String branch) {
        this.id = id;
        this.username = username;
        this.todaydate = todaydate;
        this.sname = sname;
        this.rollno = rollno;
        this.course = course;
        this.semester = semester;
        this.branch = branch;
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

    public String getTodaydate() {
        return todaydate;
    }

    public void setTodaydate(String todaydate) {
        this.todaydate = todaydate;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }
}
