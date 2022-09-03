package com.chan.discover;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DiscoverApplicationTests {

	@Test
	void contextLoads() {
		/**
		 * juc复习
		 */
		demo();
	}
	void demo(){
		new MyThread().start();
	}
	class MyThread extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(this.getClass().getName());
		}
	}
}
