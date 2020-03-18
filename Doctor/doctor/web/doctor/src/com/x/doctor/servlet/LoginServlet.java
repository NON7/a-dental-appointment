package com.x.doctor.servlet;

import com.x.doctor.service.LoginService;
import com.x.doctor.serviceimpl.LoginServiceImpl;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {




    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String  patient_id=request.getParameter("username");
        String patient_password=request.getParameter(("pwd"));
        LoginService ls=new LoginServiceImpl();
        try {
            boolean flag=ls.login(patient_id,patient_password);
            if(flag){
                request.getRequestDispatcher("success.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("faild.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
