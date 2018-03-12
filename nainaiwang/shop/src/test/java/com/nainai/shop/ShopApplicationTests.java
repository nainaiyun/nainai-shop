package com.nainai.shop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.Jedis;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopApplicationTests {
	private final static int num =2000;
	RestTemplate restTemplate = new RestTemplate();
	private  String url = "http://127.0.0.1:8080/user/all/1/3";
	private static CountDownLatch countDownLatch =new CountDownLatch(num);
	@Test
	public void contextLoads() throws InterruptedException {
		for (int i=0;i<num;i++){
			//启动线程
			new Thread(new UserRequest()).start();
			countDownLatch.countDown();

		}
		Thread.sleep(5000);
	}

	public class UserRequest implements Runnable {

		@Override
		public void run() {
			try {
				countDownLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String result = restTemplate.getForEntity(url,String.class).getBody();
			System.out.println(result);
		}

	}

	@Test
	public void Jedis(){
		Jedis jedis = new Jedis("127.0.0.1",6379);
		jedis.set("yanhaopeng","颜浩鹏");

	}

}






