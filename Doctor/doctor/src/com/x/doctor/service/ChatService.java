package com.x.doctor.service;

import java.io.IOException;

public interface ChatService {
    public String ClientService(String clientMessage) throws IOException;//发送数据
    public String erverService(String doctorMessage) throws IOException, InterruptedException;//接收数据

}
