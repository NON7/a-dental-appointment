package com.x.doctor.daoimpl;

import com.x.doctor.dao.DbDao;
import com.x.doctor.dao.LoginDao;
import com.x.doctor.entity.patient;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl extends DbDaoImpl implements LoginDao {
    public LoginDaoImpl(){
        patient patient=new patient();
    }
    @Override
    public boolean login(String  patient_id,String patient_password) throws SQLException {
//登录时数据库的查询
        boolean flag=false;
        openDb();
        String sql=" select * from patient where patient_id = ? and patient_password = ?";
        ps=con.prepareStatement(sql);
        ps.setString(1,patient_id);
        ps.setString(2,patient_password);
        rs=ps.executeQuery();
        if(rs.next()) flag=true;


        return flag;

    }

    @Override
    public void regist(patient patient) throws SQLException {
        openDb();
        String sql="insert into patient(patient_id,patient_password,patient_Id_Card) VALUES (?,?,?)";
        ps=con.prepareStatement(sql);
        ps.setString(1,patient.getPatient_id());
        ps.setString(2,patient.getPatient_password());
        ps.setString(3,patient.getPatient_Id_card());
        ps.executeUpdate();



    }
}
