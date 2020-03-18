package com.x.doctor.daoimpl;

import com.x.doctor.dao.DbDao;
import org.apache.log4j.Logger;

import java.sql.*;

public class DbDaoImpl implements DbDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public void openDb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Logger.getLogger(DbDaoImpl.class).debug(e.getMessage()+"加载数据库的时候出问题啦");
        }
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor","root","admin");
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(DbDaoImpl.class).debug(e.getMessage()+"连接数据库的时候出问题啦");
        }


    }

    @Override
    public void closeDb() throws SQLException {
        if(con!=null) con.close();
        if(ps!=null) ps.close();
        if(rs!=null) rs.close();
    }
}
