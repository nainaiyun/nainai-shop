package com.nainai.shop;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by haopeng yan on 2018/1/9 21:03.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public class RedisClient {
    //tcp
    Socket socket;
    private OutputStream outputStream;
    private InputStream inputStream;
    public RedisClient (String host,int port) throws IOException {
        socket = new Socket(host, port);
        outputStream =socket.getOutputStream();
        inputStream = socket.getInputStream();

    }
    public String set(String key ,String value) throws IOException {
        //组装报文
        StringBuffer command = new StringBuffer();
        command.append("*3").append("\r\n");
        command.append("$3").append("\r\n");
        command.append("SET").append("\r\n");
        command.append("$").append(key.getBytes().length).append("\r\n");
        command.append(key).append("\r\n");
        command.append("$").append(value.getBytes().length).append("\r\n");
        command.append(value).append("\r\n");

        //发送报文，接受相应
        return exeCommand(command);
    }
    public String get(String key ) throws IOException {
        //组装报文
        StringBuffer command = new StringBuffer();
        command.append("*2").append("\r\n");
        command.append("$3").append("\r\n");
        command.append("GET").append("\r\n");
        command.append("$").append(key.getBytes().length).append("\r\n");
        command.append(key).append("\r\n");

        //发送报文，接受相应
        return exeCommand(command);
    }
    public String dbsize(String key ) throws IOException {
        //组装报文
        StringBuffer command = new StringBuffer();
        command.append("*1").append("\r\n");
        command.append("$6").append("\r\n");
        command.append("dbsize").append("\r\n");


        return exeCommand(command);
    }


    private String exeCommand (StringBuffer stringBuffer) throws IOException {
        //发送报文，接受相应
        outputStream.write(stringBuffer.toString().getBytes());
        byte[] result = new byte[1024];
        inputStream.read(result);
        return new String(result);
    }
}
