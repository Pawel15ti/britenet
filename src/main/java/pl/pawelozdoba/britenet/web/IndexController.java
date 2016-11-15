package pl.pawelozdoba.britenet.web;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named // to jest kontroler o nazwie indexController
@ViewScoped
public class IndexController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String welcomeMessage="Hello world";

	public String getWelcomeMessage() {
		return welcomeMessage;
	}

	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}
	
	
}
