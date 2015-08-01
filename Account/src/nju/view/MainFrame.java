package nju.view;

import javax.swing.*;

import nju.config.ConfigReader;
import nju.config.FrameConfig;

public class MainFrame {
	private JFrame mainFrame;
	private StartPanel startPanel;
	
	public MainFrame(){
		componentsInstantiation();
		initComponents();
		mainFrame.setVisible(true);
	}
	
	public StartPanel getStartPanel() {
		return startPanel;
	}
	
	private void initComponents() {
		FrameConfig fc = ConfigReader.getFrameConfig();
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
		mainFrame.setSize(fc.getWidth(), fc.getHeight());
		mainFrame.setLocation((screenSize.width - fc.getWidth()) / 2,screenSize.height-fc.getHeight()/2-400);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.getContentPane().add(startPanel);
	}
	private void componentsInstantiation() {
		mainFrame = new JFrame("My account");
		startPanel = new StartPanel();
		
	}
}
