import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class UserTesting 
{
	@DataProvider(name="testCases_2")
	public static Object[][] checkLogin()
	{
		return new Object[][]  {
									{0, "s", "mahmok", "pass1"}, //Correct Username and Pass
									{-1, "s", "mahmok", "wrongpass"}, //Correct Username, wrong pass 
									{-1, "s", "wrongUser", "pass1"}, //wrong Username, correct pass
									{-1, "s", "wrongUser", "wrongPass"}//wrong username, wrond pass
								};
	}
	@Test(dataProvider="testCases_2")
	public void testLogin(int result, String kind, String username, String pass)
	{
		UI obj = new UI();
		obj.studentController.students.add(new Student("mahmok", "pass1"));
		Assert.assertEquals(result, obj.log_in(kind, username, pass));
	}
	
	
	
	
	
	
	
	@DataProvider(name="testCases_3")
	public static Object[][] checkRegister()
	{
		return new Object[][]  {
									{new User("mahmok1", "hello123")}, 
									{new User("mah123", "hello")}, 
									{new User("mahmok1234", "hello123")}, 
									{new User("mahmok", "hello")}
								};
	}
	@SuppressWarnings("deprecation")
	@Test(dataProvider="testCases_3")
	public void testRegister(User user)
	{
		Controller c = new Controller();	
		c.users.add(new User("mahmok1", "hello123"));
		c.users.add(new User("mah123", "hello"));
		c.users.add(new User("mahmok1234", "hello123"));
		c.users.add(new User("mahmok", "hello"));
		Assert.assertTrue(c.users.contains(user));
	}
}
