package nju.model;
import java.util.*;
public class BaseModel extends Observable{

	protected void updateChange(UpdateMessage message){
		
		super.setChanged();
		super.notifyObservers(message);
		
	}
}
