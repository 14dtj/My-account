package nju.model;

import nju.model.po.UserPO;

/**
 * handle sign in, sign up and check out operation
 * @author 
 *
 */
public class SystemModel extends BaseModel{

	public SystemModel() {
		
	}
	
	/**
	 * open method to sign up a user
	 * @param user:UserPO
	 */
	public void signUp(UserPO user){
		updateChange(new UpdateMessage("signUp", IOhelper.signUp(user)));
	}
	
	/**
	 * open method to sign in
	 * @param user:UserPO
	 */
	public void signIn(UserPO user){
		updateChange(new UpdateMessage("signIn", IOhelper.signIn(user)));
	}
	
	public void checkOut(){
		
	}
}
