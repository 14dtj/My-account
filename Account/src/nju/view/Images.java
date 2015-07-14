package nju.view;

import java.awt.Image;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Images {
	protected static ImageIcon createImageIcon(String path){
		ImageIcon icon = new ImageIcon(path);
		return icon;
	}
	protected static Image createImage(String path) {
		try {
			Image image = ImageIO.read(new FileInputStream(path));
			return image;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
	public static final Image BACKGROUND_IMAGE = createImage("Images/background.png");
//	public static final Image SIGN_UP_IMAGE = createImage("Images/signUp0.png");
//	public static final ImageIcon SIGN_UP_ICON = createImageIcon("Images/signUp.png");
//	public static final ImageIcon SIGN_UP_ICON1 = createImageIcon("Images/signUp1.png");
//	public static final ImageIcon CLEAN_ICON = createImageIcon("Images/clean.png");
//	public static final ImageIcon CLEAN_ICON1 = createImageIcon("Images/clean1.png");
	
}
