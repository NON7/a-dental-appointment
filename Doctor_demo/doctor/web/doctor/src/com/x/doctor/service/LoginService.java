package com.x.doctor.service;

import com.x.doctor.entity.patient;

import java.sql.SQLException;

public interface LoginService {
    public boolean login(String patient_id,String patient_password ) throws SQLException;
    public void regist(patient patient) throws SQLException;
}
