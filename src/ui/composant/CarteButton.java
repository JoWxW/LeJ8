package ui.composant;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class CarteButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	private int buttonHeight;
	private int buttonWidth;
	private int[] pixels;

	public CarteButton(String id) {
		this.setActionCommand(id);
		image = loadImage("sources/" + id + ".gif");

		buttonWidth = image.getWidth();
		buttonHeight = image.getHeight();

		// 读取图片数据
		pixels = new int[buttonWidth * buttonHeight];
		// 抓取像素数据
		PixelGrabber pg = new PixelGrabber(image, 0, 0, buttonWidth, buttonHeight, pixels, 0, buttonWidth);
		try {
			pg.grabPixels();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 必须设置！否则会有残影！
		this.setOpaque(false);

		this.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
		// this.addMouseListener(new MouseHandler());
	}

	public CarteButton(String id, boolean candidate) {
		this.setActionCommand(id);
		image = loadImage("sources/" + id + ".gif");
		buttonWidth = image.getWidth();
		buttonHeight = image.getHeight();

		// 读取图片数据
		pixels = new int[buttonWidth * buttonHeight];
		// 抓取像素数据
		PixelGrabber pg = new PixelGrabber(image, 0, 0, buttonWidth, buttonHeight, pixels, 0, buttonWidth);
		try {
			pg.grabPixels();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 必须设置！否则会有残影！
		this.setOpaque(false);

		this.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
		// this.addMouseListener(new MouseHandler());

		if (!candidate) {
			 float[] scales = {0.5f,0.5f,0.5f,0.5f };
             float[] offsets = new float[4];
             RescaleOp rop = new RescaleOp(scales, offsets, null);
             // 执行
             rop.filter(image,image);
		}
	}

	// 读取图片文件
	public BufferedImage loadImage(String filename) {
		File file = new File(filename);

		if (!file.exists())
			return null;

		try {
			return ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	// 覆盖此方法绘制自定义的图片
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, this);
		/*
		 * if(mouseOn) g.drawImage(image_over, 0, 0, this); else if(mousePressed)
		 * g.drawImage(image_pressed, 0, 0, this);
		 */
	}

	// 覆盖此方法绘制自定义的边框
	public void paintBorder(Graphics g) {
		// 不要边框
	}

	public boolean contains(int x, int y) {
		// 不判定的话会越界，在组件之外也会激发这个方法
		if (!super.contains(x, y))
			return false;

		int alpha = (pixels[(buttonWidth * y + x)] >> 24) & 0xff;

		repaint();
		if (alpha == 0) {
			return false;
		} else {
			return true;
		}
	}

	// 处理进入、离开图片范围的消息
	/*
	 * class MouseHandler extends MouseAdapter { public void mouseExited(MouseEvent
	 * e){ mouseOn = false; repaint(); } public void mouseEntered(MouseEvent e){
	 * mouseOn = true; repaint(); } public void mousePressed(MouseEvent e){ mouseOn
	 * = false; mousePressed = true; repaint(); } public void
	 * mouseReleased(MouseEvent e){ //防止在按钮之外的地方松开鼠标 if(contains(e.getX(),
	 * e.getY())) mouseOn = true; else mouseOn = false;
	 * 
	 * mousePressed = false; repaint(); } }
	 */

}
