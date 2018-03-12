package com.nainai.shop;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by haopeng yan on 2018/1/9 21:21.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
public class RedisClientTest {
    @Test
    public  void  setTest() throws IOException {
        RedisClient redisClient = new RedisClient("127.0.0.1",6379);
        redisClient.set("yanhao","haha");
        System.out.print(redisClient.get("yanhao"));
    }
}
