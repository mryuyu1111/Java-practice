package exceptionExampleV1;

public class Demonstrator4 
{
	/* See that methodB throws ExceptionB, but catches ExceptionB2. 
	 * So in this class, if methodB throws an exception, methodA catches it. 
	 * And if methodC throws an exception, methodB catches it. 
	 * Make sure you understand the exception hierarchy. See what happens if you 
	 * catch Exception instead of ExceptionB*/
	
	public static void main(String[] args) 
	{
		Demonstrator4 demo = new Demonstrator4();
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
		
		try
		{
			if (value > 0.5)
				throw new ExceptionB("Value from methodB is greater than 0.5");
			methodC(); 
		}
		catch (ExceptionB2 e)
		{
			System.out.println("In methodB - Caught exceptionB2: "+e.getMessage());
		}
		
		System.out.println("Ended methodB");
	}
	
	private void methodC()throws ExceptionB2
	{
		System.out.println("Started methodC");
		
		Double value = Math.random();	
		System.out.println("Value in methodC is: "+value);
		
		if (value > 0.5)
			throw new ExceptionB2("Value from methodC is greater than 0.5");
		System.out.println("Ended methodC");
	}
}
