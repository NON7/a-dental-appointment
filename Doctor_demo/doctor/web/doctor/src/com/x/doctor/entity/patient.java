package com.x.doctor.entity;

import java.util.ArrayList;
import java.util.List;

public class patient {
    String patient_id;
    String patient_name;
    String patient_password;
    String patient_Id_card;
    String patient_sex;
    int patient_age;
    String patient_headImage;

    List<patient> list=new ArrayList<>();

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_password() {
        return patient_password;
    }

    public void setPatient_password(String patient_password) {
        this.patient_password = patient_password;
    }

    public String getPatient_Id_card() {
        return patient_Id_card;
    }

    public void setPatient_Id_card(String patient_Id_card) {
        this.patient_Id_card = patient_Id_card;
    }

    public String getPatient_sex() {
        return patient_sex;
    }

    public void setPatient_sex(String patient_sex) {
        this.patient_sex = patient_sex;
    }

    public int getPatient_age() {
        return patient_age;
    }

    public void setPatient_age(int patient_age) {
        this.patient_age = patient_age;
    }

    public String getPatient_headImage() {
        return patient_headImage;
    }

    public void setPatient_headImage(String patient_headImage) {
        this.patient_headImage = patient_headImage;
    }
}
