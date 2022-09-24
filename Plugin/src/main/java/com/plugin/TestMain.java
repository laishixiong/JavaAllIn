package com.plugin;

import java.util.concurrent.TimeUnit;

/**
 * 测试类
 *
 * @author laishixiong
 * @time 2022/9/24 11:05
 */
public class TestMain {
	public static void main(String[] args) {
		TestMain testMain = new TestMain();
		//testMain.testClick();
		testMain.mouseMove();
	}

	public void testClick() {
		MouseClick mouseClick = MouseClick.getSingleton();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mouseClick.mouseMove(200, 200);
		mouseClick.mouseMove(200, 200);
		mouseClick.mouseMove(200, 200);

	}

	public void mouseMove(){
		MouseClick mouseClick = MouseClick.getSingleton();
		mouseClick.click(800,800);
	}
}
