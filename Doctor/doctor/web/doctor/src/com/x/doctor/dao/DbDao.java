package com.x.doctor.dao;

import java.sql.SQLException;

public interface DbDao {
    public void openDb();

    public void closeDb() throws SQLException;
}
