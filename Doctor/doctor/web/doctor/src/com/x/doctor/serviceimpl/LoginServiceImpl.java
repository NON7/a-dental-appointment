package com.x.doctor.serviceimpl;

import com.x.doctor.dao.LoginDao;
import com.x.doctor.daoimpl.LoginDaoImpl;
import com.x.doctor.entity.patient;
import com.x.doctor.service.LoginService;
import org.apache.log4j.Logger;

import java.sql.SQLException;

public class LoginServiceImpl implements LoginService {
    @Override
    public boolean login(String patient_id,String patient_password) throws SQLException {
        LoginDao ld=new LoginDaoImpl();
       // LoginDao db=new LoginDaoImpl();
        boolean flag=false;
        try {
            flag=ld.login(patient_id,patient_password);
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(LoginServiceImpl.class).debug(e.getMessage()+"登录出问题啦");
        }finally {
            ((LoginDaoImpl) ld).closeDb();
        }
        return flag;
    }

    @Override
    public void regist(patient patient) throws SQLException {
        LoginDao dao=new LoginDaoImpl();

        try {
            dao.regist(patient);
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(LoginServiceImpl.class).debug(e.getMessage()+"注册出问题啦");
        }finally {
            ((LoginDaoImpl) dao).closeDb();
        }
    }

}
