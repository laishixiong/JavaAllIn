package com.plugin;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * 鼠标点击
 *
 * @author laishixiong
 * @time 2022/9/24 10:19
 */
@Slf4j
@Data
public class MouseClick {

	private static volatile MouseClick mouseClick;

	//避免机器检测，模拟真实用户的操作，但是性能上面比不模拟要慢,默认关闭
	private boolean avoidDetection = false;

	private Robot robot;

	//鼠标点击之间的阈值,100~~100+200之间
	private int clickIntervalThreshold = 200;


	private MouseClick() {
	}


	/**
	 * 单例
	 *
	 * @param
	 * @return
	 * @author laishixiong
	 * @time 2022/9/24 11:15
	 */
	public static MouseClick getSingleton() {
		if (mouseClick == null) {
			synchronized (MouseClick.class) {
				if (mouseClick == null) {
					mouseClick = new MouseClick();
					try {
						mouseClick.init();
					} catch (AWTException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return mouseClick;
	}

	/**
	 * 初始化一些数据，可以多次调用
	 *
	 * @param
	 * @return
	 * @author laishixiong
	 * @time 2022/9/24 11:15
	 */
	public void init() throws AWTException {
		robot = new Robot();
	}

	public void click(int x, int y, int clickNum, int clickInterval) {

	}

	/**
	 * 产生一个模拟鼠标点击和释放过程的停顿
	 *
	 * @param
	 * @return
	 * @author laishixiong
	 * @time 2022/9/24 10:51
	 */
	public int generatorClickIntervalTime() {
		return (int) Math.random() * clickIntervalThreshold + 100;
	}


	public void click(int x, int y) {
		//移动鼠标到指定坐标
		mouseMove(x, y);
		//模拟鼠标左键点击
		robot.mousePress(KeyEvent.BUTTON1_MASK);
		if (avoidDetection) {
			//是否模拟人类操作
			robot.delay(generatorClickIntervalTime());
		}
		//模拟鼠标左键松手
		robot.mouseRelease(KeyEvent.BUTTON1_MASK);
	}

	/**
	 * 模拟双击
	 *
	 * @param
	 * @return
	 * @author laishixiong
	 * @time 2022/9/24 11:18
	 */
	public void doubleClick(int x, int y) {
		click(x, y);
		robot.delay(650);
		click(x, y);
	}


	/**
	 * 滚轮 输入的值为几，就代表鼠标滚轮滚几下
	 *
	 * @param
	 * @return
	 * @author laishixiong
	 * @time 2022/9/24 10:59
	 */
	public void mouseWheel(int wheelAmt) {
		robot.mouseWheel(wheelAmt);
	}

	public void mouseMove(int x, int y) {
		robot.mouseMove(x, y);
	}

}
