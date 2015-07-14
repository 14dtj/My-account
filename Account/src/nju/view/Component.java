package nju.view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Component {
	private int x;
	private int y;
	private int width;
	private int height;
	private String path="Images/";
	public Component(int x,int y,int width,int height,String name){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		path=path+name+".png";
	}
	public void createComponent(Graphics g){
		Image image;
		try {
			image = ImageIO.read(new FileInputStream(path));
			g.drawImage(image, x, y, width,height,null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
