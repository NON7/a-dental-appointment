package com.x.doctor.service;

import java.io.IOException;

public interface ChatService {
    String ClientService(String clientMessage) throws IOException;//发送数据
    String ServerService(String doctorMessage) throws IOException, InterruptedException;//接收数据

}
