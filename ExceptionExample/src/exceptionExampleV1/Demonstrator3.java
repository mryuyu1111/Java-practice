package exceptionExampleV1;

public class Demonstrator3 
{
	/* Demonstrates that if we call a method that throws an exception,
	 * we can surround that method call with a try-catch block. 
	 * See how we can print the exception message that was caught.*/
	
	public static void main(String[] args) throws ExceptionB 
	{
		Demonstrator3 demo = new Demonstrator3();
		demo.methodA();
	}
	
	
	
	
	private void methodA() 
	{
		System.out.println("Started methodA");		
		try
		{
			methodB();
		}
		catch(ExceptionB e)
		{
			System.out.println("In methodA, caught ExceptionB from methodB: "+e.getMessage());
		}
		System.out.println("Ended methodA");
	}

	private void methodB() throws ExceptionB
	{
		System.out.println("Started methodB");
		
		Double value = Math.random();	
		System.out.println("Value in methodB is: "+value);
		if (value > 0.5)
			throw new ExceptionB("Value is greater than 0.5");
		
		methodC();
		System.out.println("Ended methodB");
	}
	
	private void methodC()
	{
		System.out.println("Started methodC");
		System.out.println("Ended methodC");
	}
}
