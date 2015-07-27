package nju.model;

import java.io.*;
import java.util.ArrayList;

import nju.model.po.UserPO;

public class IOhelper {

	static BufferedReader reader = null;
	static BufferedWriter writer = null;
	
	public static boolean signUp(UserPO user){
		//save data
		ArrayList<String> buffer = new ArrayList<String>();
		//initialize
		try {
			reader = new BufferedReader(new FileReader("data/users.data"));
			//verify that no same name
			String temp = "";
			while((temp = reader.readLine())!=null){
				buffer.add(temp);
				if(user.getName().equals(temp.split(" ")[0])){
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		//write new user
		try {
			writer = new BufferedWriter(new FileWriter("data/users.data"));
			for(String already:buffer){
				writer.write(already+"\n");
			}
			writer.write(user.getName()+" "+user.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}
	
	public static boolean signIn(UserPO user){
		try {
			reader = new BufferedReader(new FileReader("data/users.data"));
			String userRead = "";
			while((userRead = reader.readLine())!=null){
				String[] userGet = userRead.split(" ");
				if(userGet[0].equals(user.getName())&&userGet[1].equals(user.getPassword())){
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}
	
}
