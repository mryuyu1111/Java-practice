package mockito;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestLoginAuthenticator 
{
	private ArrayList<User> users;
	private User mockUser1, mockUser2, mockUser3;
	private LoginAuthenticator authenticator;
	
	@Before
	public void setUp()
	{
		users = new ArrayList<User>();
		mockUser1 = mock(User.class);
		when(mockUser1.getPassword()).thenReturn("my password");
		when(mockUser1.getUserName()).thenReturn("Lingyu");
		
		mockUser2 = mock(User.class);
		when(mockUser2.getPassword()).thenReturn("something else");
		when(mockUser2.getUserName()).thenReturn("someone");
		
		mockUser3 = mock(User.class);
		when(mockUser3.getPassword()).thenReturn("aap");
		when(mockUser3.getUserName()).thenReturn("aa");
		
		users.add(mockUser1);
		users.add(mockUser2);
		users.add(mockUser3);
		
		
	}
	
	@Test
	public void testPasswordMatch_ReturnsTrue()
	{
		authenticator = new LoginAuthenticator();
		assertTrue(authenticator.passwordMatch(users, "my password"));
	}
	
	@Test
	public void testPasswordMatch_ReturnsTrue_v2()
	{
		authenticator = new LoginAuthenticator();
		assertTrue(authenticator.passwordMatch(users, "something else"));
	}
	
	@Test
	public void testPasswordMatch_ReturnsFalse()
	{
		authenticator = new LoginAuthenticator();
		assertFalse(authenticator.passwordMatch(users, "dsafsadvg"));
	}
	
	@Test
	public void testPasswordMatch_ReturnsFalse_WhenGiveNull()
	{
		authenticator = new LoginAuthenticator();
		assertFalse(authenticator.passwordMatch(users, ""));
	}
	
	@Test
	public void restReturnMatchedUser_returnsCorrectUser()
	{
		authenticator = new LoginAuthenticator();
		
		try
		{
			User result = authenticator.returnMatchedUser(users, "Lingyu", "my password");
			assertTrue(result.getPassword().equals("my password") && 
					   result.getUserName().equals("Lingyu"));
		}
		catch (NoUserException e)
		{
			assertTrue(false);
		}
	}	
	
	@Test //bad example
	public void restReturnMatchedUser_throwsException()
	{
		authenticator = new LoginAuthenticator();
		
		try
		{
			User result = authenticator.returnMatchedUser(users, "Lingyu", "fvgfffff");
		}
		catch (NoUserException e)
		{
			assertTrue(true);
		}
	}	
	
	@Test (expected = NoUserException.class)//better example
	public void restReturnMatchedUser_throwsException_v2() throws NoUserException
	{
		authenticator = new LoginAuthenticator();
		authenticator.returnMatchedUser(users, "Lingyu", "fvgfffff");
	}	
	
	@Test
	public void testLogUserActivity_callsCorrectMethod()
	{
		authenticator = new LoginAuthenticator();
		authenticator.logUserActivity(mockUser1, "extra string");
		verify(mockUser1, times(1)).writeUserDetails("extra string");
	}
}
