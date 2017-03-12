import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class GameTesting
{
	@DataProvider(name="testCases_1")
	public static Object[][] checkTeacherGames()
	{
		return new Object[][]  {
									{1,"Game1234"}, 
									{0,"Game1"}, 
								};
	}
	@SuppressWarnings("deprecation")
	@Test(dataProvider="testCases_1")
	public void testTeacherGames(int result, String name)
	{
		TeacherController tc = new TeacherController();
		tc.teachers.add(new Teacher("Ahmed", "hello"));
		tc.teachers.get(0).MCQGames.add(new MCQGame("Game1"));	
		Assert.assertEquals(result, tc.checkMCQGame(name));
	}
	
	
	
	
	
	
	
	@DataProvider(name="testCases_2")
	public static Object[][] getGame()
	{
		return new Object[][]  {
									{"Game1234"}, 
									{"Game1"}, 
								};
	}
	@SuppressWarnings("deprecation")
	@Test(dataProvider="testCases_2")
	public void testGetGame(String name)
	{
		TeacherController tc = new TeacherController();
		tc.teachers.add(new Teacher("Ahmed", "hello"));
		tc.teachers.get(0).MCQGames.add(new MCQGame("Game1"));
		Controller c = new Controller();	
		Assert.assertNotNull(c.getMCQGame(name));
	}
}
