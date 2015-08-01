package nju.view;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import nju.config.ComponentsConfig;
import nju.config.ConfigReader;
import nju.config.FrameConfig;

public class StartPanel extends JPanel{
	private List<Component> components= null;
	private JTextField firstName = null;
	private JTextField lastName = null;
	private JPasswordField passWord = null;
	
	public StartPanel(){
		this.setLayout(null);
		initComponent();
	}
	public void initComponent(){
		//�����Ϸ����
		FrameConfig fCfg = ConfigReader.getFrameConfig();
		//��ò�������
		List<ComponentsConfig> layersCfg = fCfg.getLayersConfig();
		components  = new ArrayList<Component>(layersCfg.size());
		for(int i=0;i<3;i++){
			ComponentsConfig cfg = layersCfg.get(i);
			//���ù��캯����������
			Component layer;
			try {
				//��������
				Class<?> cls = Class.forName("nju.view.Component");
				//��ù��캯��
				Constructor ctr = cls.getConstructor(int.class,int.class,int.class,int.class,String.class);
				layer = (Component) ctr.newInstance(
						cfg.getX(),cfg.getY(),cfg.getW(),cfg.getH(),cfg.getName());
				//�Ѵ�����Layer������뼯����
				components.add(layer);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		

		firstName = new JTextField(10);
		lastName = new JTextField(10);
		passWord = new JPasswordField(10);
	
		firstName.setBounds(layersCfg.get(3).getX(),layersCfg.get(3).getY(),
				layersCfg.get(3).getW(),layersCfg.get(3).getH());
		lastName.setBounds(layersCfg.get(4).getX(),layersCfg.get(4).getY(),
				layersCfg.get(4).getW(),layersCfg.get(4).getH());
		passWord.setBounds(layersCfg.get(5).getX(),layersCfg.get(5).getY(),
				layersCfg.get(5).getW(),layersCfg.get(5).getH());
        passWord.setEchoChar('*');
		add(firstName);
		add(lastName);
		add(passWord);
	}


	
	public void paintComponent(Graphics g){
		FrameConfig fc = ConfigReader.getFrameConfig();
		g.drawImage(Images.BACKGROUND_IMAGE, 0, 0, fc.getWidth(),fc.getHeight(),this);
//		g.drawImage(Images.SIGN_UP_IMAGE,312 , 66, 456,568, this);
		//������Ϸ����
		for(int i=0;i<components.size();components.get( i++).createComponent(g));
	}
}
