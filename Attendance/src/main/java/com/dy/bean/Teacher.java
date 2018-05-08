package com.dy.bean;

public class Teacher {
    private Integer id;

    private String tecId;

    private String tecName;

    private String tecPassword;

    private String coursename;

    private String classname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTecId() {
        return tecId;
    }

    public void setTecId(String tecId) {
        this.tecId = tecId == null ? null : tecId.trim();
    }

    public String getTecName() {
        return tecName;
    }

    public void setTecName(String tecName) {
        this.tecName = tecName == null ? null : tecName.trim();
    }

    public String getTecPassword() {
        return tecPassword;
    }

    public void setTecPassword(String tecPassword) {
        this.tecPassword = tecPassword == null ? null : tecPassword.trim();
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

}