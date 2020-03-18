package com.x.doctor.dao;

import java.io.IOException;

public interface socketDao {
    void closeSocket() throws IOException;
    void closeSockets() throws IOException;
}
