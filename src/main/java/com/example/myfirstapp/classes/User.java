package com.example.myfirstapp.classes;

public class User {
    private String username;
    private String password;
    private Boolean teacher;
    private String adress ;
    private Integer postalcode;
    private Integer userID;


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

    public Boolean getTeacher() {
        return teacher;
    }

    public void setTeacher(Boolean teacher) {
        this.teacher = teacher;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(Integer postalcode) {
        this.postalcode = postalcode;
    }
}
