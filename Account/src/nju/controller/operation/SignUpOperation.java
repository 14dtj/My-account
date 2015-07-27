package nju.controller.operation;

import nju.controller.msqueue.OperationQueue;
import nju.model.SystemModel;
import nju.model.po.UserPO;

public class SignUpOperation extends Operation{

	UserPO user = null;
	
	public SignUpOperation(UserPO user) {
		this.user = user;
	}
	
	@Override
	public void execute() {
		SystemModel system = OperationQueue.getSystem();
		system.signUp(user);
	}

}
