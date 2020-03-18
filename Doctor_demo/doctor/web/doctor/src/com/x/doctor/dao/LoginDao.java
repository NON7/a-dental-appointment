package com.x.doctor.dao;

import com.x.doctor.entity.patient;

import java.sql.SQLException;

public interface LoginDao {
    public boolean login(String patient_id,String patient_password) throws SQLException;
    public void regist(patient patient) throws SQLException;
}
