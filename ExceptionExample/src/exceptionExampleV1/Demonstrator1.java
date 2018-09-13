package exceptionExampleV1;

public class Demonstrator1 
{
	/*Demonstrates the normal flow of the program.
	 No exceptions yet. */ 
	 

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Demonstrator1 demo = new Demonstrator1();
		demo.methodA();
	}
	
	private void methodA()
	{
		System.out.println("Started methodA");
		methodB();
		System.out.println("Ended methodA");
	}

	private void methodB()
	{
		System.out.println("Started methodB");
		methodC();
		System.out.println("Ended methodB");
	}
	
	private void methodC()
	{
		System.out.println("Started methodC");
		System.out.println("Ended methodC");
	}
}
