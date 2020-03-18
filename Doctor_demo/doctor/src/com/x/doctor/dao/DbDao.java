package com.x.doctor.dao;

import java.sql.SQLException;

public interface DbDao {
    void openDb();

    void closeDb() throws SQLException;
}
