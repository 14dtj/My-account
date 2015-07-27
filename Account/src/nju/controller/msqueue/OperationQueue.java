package nju.controller.msqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import nju.controller.operation.Operation;
import nju.model.*;

/**
 * When an operation is listened, the operation should be added to the
 * operation queue, the operation queue will execute these operations 
 * successively.
 * eg:Operation op = new CheckInOperation();
 *    OperationQueue.addOperation(op);
 * @author Cui
 * 2015Äê7ÔÂ27ÈÕ11:10:09
 */
public class OperationQueue implements Runnable{
	private static BlockingQueue<Operation> queue;
	
	public static boolean isRunning;
	
	public static boolean singleUpdateSwitch = true;
	
	/**
	 * model to handle data
	 */
	private static DataModel data;
	
	/**
	 * model to handle system change, such as check in or check out
	 */
	private static SystemModel system;
	
	public OperationQueue(DataModel dataModel, SystemModel systemModel){
		queue = new ArrayBlockingQueue<Operation>(1000);
		isRunning = true;
		
		data = dataModel;
		system = systemModel;
		
	}

	@Override
	public void run() {

		while(isRunning){
			Operation operation = getNewOperation();
			operation.execute();
		}
	}
	
	/**
	 * add to the operation queue 
	 * @param operation:Operation
	 * @return success or false
	 */
	public static boolean addOperation (Operation operation){
		try {
			queue.put(operation);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	private static Operation getNewOperation (){
		Operation  operation = null;
		try {
			operation = queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return operation;
	}

	public static DataModel getData() {
		return data;
	}

	public static void setData(DataModel data) {
		OperationQueue.data = data;
	}

	public static SystemModel getSystem() {
		return system;
	}

	public static void setSystem(SystemModel system) {
		OperationQueue.system = system;
	}

}
