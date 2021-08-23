package com.example.tour_guide;

public class guideInformation {
    private String nmae,email,age,mobilenuimber,district;
    guideInformation(){

    }

    public guideInformation(String nmae, String email, String age, String mobilenuimber, String district) {
        this.nmae = nmae;
        this.email = email;
        this.age = age;
        this.mobilenuimber = mobilenuimber;
        this.district = district;


    }


    public String getNmae() {
        return nmae;
    }

    public void setNmae(String nmae) {
        this.nmae = nmae;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMobilenuimber() {
        return mobilenuimber;
    }

    public void setMobilenuimber(String mobilenuimber) {
        this.mobilenuimber = mobilenuimber;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
