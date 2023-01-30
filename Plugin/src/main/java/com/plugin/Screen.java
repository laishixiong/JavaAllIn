package com.plugin;

import cn.hutool.core.io.IoUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * 屏幕工具
 * 在云桌面里面测试会出现不能用的情况
 *
 * @author laishixiong
 * @time 2022/9/24 10:19
 */
@Data
@Slf4j
public class Screen {

	private static volatile Screen screen;

	private Robot robot;
	//屏幕的宽度
	private double screenW;
	//屏幕的高度
	private double screenH;

	private Screen() {
	}

	public static Screen getSingleton() {
		if (screen == null) {
			synchronized (Screen.class) {
				if (screen == null) {
					screen = new Screen();
					screen.reloadScreenInfo();
					try {
						screen.robot = new Robot();
					} catch (AWTException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
		return screen;
	}

	/**
	 * 重新加载屏幕参数
	 *
	 * @param
	 * @return
	 * @author laishixiong
	 * @time 2022/9/24 10:26
	 */
	public void reloadScreenInfo() {
		Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = defaultToolkit.getScreenSize();
		screenH = screenSize.getHeight();
		screenW = screenSize.getWidth();
	}

	/**
	 * 获取指定坐标点的颜色
	 *
	 * @param
	 * @return
	 * @author laishixiong
	 * @time 2022/9/24 10:44
	 */
	public Color getPixelColor(int x, int y) {
		return robot.getPixelColor(x, y);
	}

	/**
	 * 截取指定区域的图片
	 *
	 * @param
	 * @return
	 * @author laishixiong
	 * @time 2022/9/24 11:32
	 */
	public BufferedImage screenShot(int x, int y, int w, int h) {
		//需要截图的区域
		Rectangle rectangle = new Rectangle(x, y, w, h);
		BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
		try {
			OutputStream outputStream = new FileOutputStream(new File("C:\\lsx\\"));
			ImageIO.write(bufferedImage,"jpg",outputStream);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return bufferedImage;
	}
}
