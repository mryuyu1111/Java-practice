package mockito;

import java.util.Collection;

public class LoginAuthenticator 
{
	public boolean passwordMatch(Collection<User> users, String password)
	{
		if (users != null)
			for (User user : users)
			{
				if (user.getPassword().equals(password))
					return true;
			}
		return false;
	}
	
	public User returnMatchedUser(Collection<User> users, 
								  String userName, String password) 
								  throws NoUserException
	{
		if (users != null)
			for (User user : users)
			{
				if (((user.getPassword().equals(password)) &&
					  user.getUserName().equals(userName)))
					return user;
			}
		throw new NoUserException();
	}
	
	public void logUserActivity(User user, String extra)
	{
		user.writeUserDetails(extra);
	}
}
