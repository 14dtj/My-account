package nju.view;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

import nju.model.po.UserPO;

public class ButtonSignUp extends MyButton{
	
	public ButtonSignUp(Component c) {
		super(c);
	}

	public class ButtonListener implements MouseListener{
		private JTextField firstName,lastName,password;
		
		public ButtonListener(JTextField first,JTextField last, JTextField password ){
			this.firstName=first;
			this.lastName=last;
			this.password=password;
		}
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			isIn=true;
			repaint();
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			isIn=false;
			repaint();
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			String name = firstName.getText()+" "+lastName.getText();
			String pass = password.getText();
			UserPO user = new UserPO(name, pass);
			systemController.signUp(user);
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
