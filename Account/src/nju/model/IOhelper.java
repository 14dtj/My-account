package nju.model;

import java.io.*;
import java.util.ArrayList;

import nju.model.po.UserPO;

/**
 * handle specific IO operation
 * @author 
 *
 */
public class IOhelper {

	static BufferedReader reader = null;
	static BufferedWriter writer = null;
	private static final String USERURL = "data/users.data";
	private static final String SPLITSIGN = ":";
	
	/**
	 * add a user to "users.data"
	 * @param user
	 * @return whether handle the operation successfully
	 */
	public static boolean signUp(UserPO user){
		//save data
		ArrayList<String> buffer = new ArrayList<String>();
		//initialize
		try {
			reader = new BufferedReader(new FileReader(USERURL));
			//verify that no same name
			String temp = "";
			while((temp = reader.readLine())!=null){
				buffer.add(temp);
				if(user.getName().equals(temp.split(SPLITSIGN)[0])){
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
			writer = new BufferedWriter(new FileWriter(USERURL));
			for(String already:buffer){
				writer.write(already+"\n");
			}
			writer.write(user.getName()+SPLITSIGN+user.getPassword());
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
	
	/**
	 * search a user and verify the name and password
	 * @param user
	 * @return whether handle the operation successfully
	 */
	public static boolean signIn(UserPO user){
		try {
			reader = new BufferedReader(new FileReader(USERURL));
			String userRead = "";
			while((userRead = reader.readLine())!=null){
				String[] userGet = userRead.split(SPLITSIGN);
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
