package com.x.doctor.dao;

import java.io.IOException;

public interface socketDao {
    public void closeSocket() throws IOException;

    public void closeSockets() throws IOException;
}
