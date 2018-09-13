package SpringAOP;

//ADVICE
public class ConsoleLog {
	
	public void displayEntry()
	{
		System.out.println("Entering a method...");
	}
	
	public void displayEntryMethod2()
	{
		System.out.println("Entering a method2...");
	}
	
	public void displayReturnClassB()
	{
		System.out.println("Class B was returned.");
	}
	
//	public void aroundCall()
//	{
//		System.out.println("Yippee!!");
//	}
	
}
