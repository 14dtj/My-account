package nju.view;

import java.awt.Graphics;



import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import nju.controller.SystemController;


public class MyButton extends JLabel{
	protected ImageIcon image;
	protected Component component;
	protected boolean isIn;
	protected SystemController systemController;
	public MyButton(Component c){
		systemController = new SystemController();
		this.component = c;
		this.setBounds(c.getX(), c.getY(), c.getWidth(), c.getHeight());
		component.setX(0);
		component.setY(0);
		
	}
	
	public void paintComponent(Graphics g){
		if(isIn){
    		component.changePath();
    	}else{
    		component.setPath();
    	}
    	component.createComponent(g);
	}
}
