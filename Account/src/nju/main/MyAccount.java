package nju.main;

import nju.controller.msqueue.OperationQueue;
import nju.model.*;
import nju.view.MainFrame;

public class MyAccount {

	public static void main(String[] args) {
		//create and initialize UI
		MainFrame ui = new MainFrame();
		
		//create and initialize model
		SystemModel systemModel = new SystemModel();
		DataModel dataModel = new DataModel();
		
		//set observers
		systemModel.addObserver(ui.getStartPanel());
		
		//start operation queue thread
		OperationQueue operationQueue = new OperationQueue(dataModel, systemModel);
		Thread operationThread = new Thread(operationQueue);
		operationThread.start();
	}

}
