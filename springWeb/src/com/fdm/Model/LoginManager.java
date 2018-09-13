package com.fdm.Model;

import com.fdm.springMVCIntro.User;

public class LoginManager {
	public boolean allowLogin(User user)
	{
		if(user.getFirstname().equalsIgnoreCase("Craig") && user.getLastname().equalsIgnoreCase("Newman"))
			return true;
		else
			return false;
	}

}
