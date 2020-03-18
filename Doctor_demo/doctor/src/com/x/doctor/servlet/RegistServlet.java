package com.x.doctor.servlet;

import com.x.doctor.entity.patient;
import com.x.doctor.service.LoginService;
import com.x.doctor.serviceimpl.LoginServiceImpl;
import com.x.doctor.util.MyLog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String patient_id=request.getParameter("username");
        String patient_password=request.getParameter("pwd");
        String patient_identityCard=request.getParameter("identity_card");
        LoginService ls=new LoginServiceImpl();
        patient patient=new patient();
        patient.setPatient_id(patient_id);
        patient.setPatient_password(patient_password);
        patient.setPatient_Id_card(patient_identityCard);
        try {
            ls.regist(patient);
            //request.getRequestDispatcher("success.jsp").forward(request,response);
            response.setHeader("refresh","1;URL=index.jsp");

        } catch (SQLException e) {
            request.getRequestDispatcher("index.jsp").forward(request,response);
            e.printStackTrace();
            MyLog.log.debug(e.getMessage()+"注册的servlet");
        }
    }
}
