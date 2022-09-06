package com.example.alertdialog;

public class UserPojo {
    int empImage;
    String name;
    String mail;

    public int getEmpImage() {
        return empImage;
    }

    public void setEmpImage(int empImage) {
        this.empImage = empImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    String mobile;

    public UserPojo(int empImage, String name, String mail, String mobile, String address) {
        this.empImage = empImage;
        this.name = name;
        this.mail = mail;
        this.mobile = mobile;
        this.address = address;
    }

    String address;


}




