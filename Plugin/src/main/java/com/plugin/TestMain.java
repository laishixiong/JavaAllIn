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
		//testMain.mouseMove();
		//testMain.testScreen();
		//testMain.showMouseMove();
		testMain.screenShot();
	}

	public void mouseMove() {
		MouseClick mouseClick = MouseClick.getSingleton();
		mouseClick.mouseMove(200, 200);
	}

	public void testClick(){
		MouseClick mouseClick = MouseClick.getSingleton();
		mouseClick.click(800,800);
	}

	public void testScreen(){
		Screen screen = Screen.getSingleton();
		System.out.println(screen.getScreenW());
		System.out.println(screen.getScreenH());
	}

	public void showMouseMove(){
		Screen screen = Screen.getSingleton();
		MouseClick mouseClick = MouseClick.getSingleton();
		int w = (int) screen.getScreenW();
		int h = (int) screen.getScreenH();
		//右上角到左下角
		for (int i = 1; i <= 100; i++) {
			float tmp = i/100F;
			int cw = (int) (w *(1-tmp));
			int ch = (int) (h * (tmp));
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(cw+" "+ch);
			mouseClick.mouseMove(cw,ch);
		}
		//从左上角到右下角
		for (int i = 1; i <= 100; i++) {
			float tmp = i/100F;
			int cw = (int) (w *tmp);
			int ch = (int) (h * tmp);
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(cw+" "+ch);
			mouseClick.mouseMove(cw,ch);
		}
		//从左下角到左上角
		for (int i = 1; i <= 100; i++) {
			float tmp = i/100F;
			int cw = (int) (w *tmp);
			int ch = (int) (h * (1-tmp));
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(cw+" "+ch);
			mouseClick.mouseMove(cw,ch);
		}

	}


	public void screenShot(){
		Screen screen = Screen.getSingleton();
		screen.screenShot(20,20,400,600);
	}
}
