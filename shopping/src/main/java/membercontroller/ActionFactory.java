//Page Controller

package membercontroller;

import membercontroller.action.*;
import productcontrolleraction.IndexAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return instance;
	}	
	public Action getAction(String command) {
		Action action = null;
		if((command.equals("join"))) {
			action = new JoinAction();
		} else if(command.equals("login")) {
			action = new LoginAction();
		} else if(command.equals("logout")) {
			action = new LogoutAction();
		} else if(command.equals("zipcode")) {
			action = new ZipcodeAction();
		} else if(command.equals("idcheck")) {
			action = new IdCheckAction();
		}
		
		return action;
	}
}
