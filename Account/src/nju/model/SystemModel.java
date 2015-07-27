package nju.model;

import nju.model.po.UserPO;

public class SystemModel extends BaseModel{

	public SystemModel() {
		
	}
	
	public void signUp(UserPO user){
		updateChange(new UpdateMessage("signUp", IOhelper.signUp(user)));
	}
	
	public void signIn(UserPO user){
		updateChange(new UpdateMessage("signIn", IOhelper.signIn(user)));
	}
}
