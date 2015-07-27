package nju.controller;

import nju.controller.msqueue.OperationQueue;
import nju.controller.operation.Operation;
import nju.controller.operation.SignInOperation;
import nju.controller.operation.SignUpOperation;
import nju.model.po.UserPO;

/**
 * control basic function of the system
 * @author Cui
 * 2015Äê7ÔÂ27ÈÕ11:25:57
 */
public class SystemController {
	
	public boolean signIn(UserPO user){
		Operation signIn = new SignInOperation(user);
		OperationQueue.addOperation(signIn);
		return true;
	}

	public boolean signUp(UserPO user){
		Operation signUp = new SignUpOperation(user);
		OperationQueue.addOperation(signUp);
		return true;
	}
	
	public boolean checkOut(){
		return false;
	}
}
