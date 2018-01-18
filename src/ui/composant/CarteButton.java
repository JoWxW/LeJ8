package ui.composant;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

		// ��ȡͼƬ����
		pixels = new int[buttonWidth * buttonHeight];
		// ץȡ��������
		PixelGrabber pg = new PixelGrabber(image, 0, 0, buttonWidth, buttonHeight, pixels, 0, buttonWidth);
		try {
			pg.grabPixels();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// �������ã�������в�Ӱ��
		this.setOpaque(false);

		this.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
		// this.addMouseListener(new MouseHandler());
	}

	public CarteButton(String id, boolean candidate) {
		this.setActionCommand(id);
		image = loadImage("sources/" + id + ".gif");
		buttonWidth = image.getWidth();
		buttonHeight = image.getHeight();

		// ��ȡͼƬ����
		pixels = new int[buttonWidth * buttonHeight];
		// ץȡ��������
		PixelGrabber pg = new PixelGrabber(image, 0, 0, buttonWidth, buttonHeight, pixels, 0, buttonWidth);
		try {
			pg.grabPixels();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// �������ã�������в�Ӱ��
		this.setOpaque(false);

		this.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
		// this.addMouseListener(new MouseHandler());

		if (!candidate) {
			 float[] scales = {0.5f,0.5f,0.5f,0.5f };
             float[] offsets = new float[4];
             RescaleOp rop = new RescaleOp(scales, offsets, null);
             // ִ��
             rop.filter(image,image);
		}
	}

	// ��ȡͼƬ�ļ�
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

	// ���Ǵ˷��������Զ����ͼƬ
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, this);
		/*
		 * if(mouseOn) g.drawImage(image_over, 0, 0, this); else if(mousePressed)
		 * g.drawImage(image_pressed, 0, 0, this);
		 */
	}

	// ���Ǵ˷��������Զ���ı߿�
	public void paintBorder(Graphics g) {
		// ��Ҫ�߿�
	}

	public boolean contains(int x, int y) {
		// ���ж��Ļ���Խ�磬�����֮��Ҳ�ἤ���������
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



	

	

}
