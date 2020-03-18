package com.x.doctor.dao;

import com.x.doctor.entity.patient;

import java.sql.SQLException;

public interface LoginDao {
    boolean login(String patient_id, String patient_password) throws SQLException;
    void regist(patient patient) throws SQLException;
}
