package nju.view;

import java.awt.*;

import javax.swing.*;

public class StartPanel extends JPanel{
	
	public void paintComponent(Graphics g){
		g.drawImage(Images.BACKGROUND_IMAGE, 0, 0, 1080,700,this);
		g.drawImage(Images.SIGN_UP_IMAGE,426 , 208, 228, 284, this);
	}
}
