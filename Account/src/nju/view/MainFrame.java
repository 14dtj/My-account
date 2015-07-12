package nju.view;

import javax.swing.*;

public class MainFrame {
	private JFrame mainFrame;
	private StartPanel startPanel;
	public MainFrame(){
		componentsInstantiation();
		initComponents();
		mainFrame.setVisible(true);
	}
	private void initComponents() {
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
		mainFrame.setSize(1080, 700);
		mainFrame.setLocation((screenSize.width - 1080) / 2,screenSize.height-700/2-400);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		mainFrame.getContentPane().add(startPanel);
	}
	private void componentsInstantiation() {
		mainFrame = new JFrame("My account");
		startPanel = new StartPanel();
		
	}
}
