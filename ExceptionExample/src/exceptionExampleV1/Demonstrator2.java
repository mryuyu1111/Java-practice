package exceptionExampleV1;

public class Demonstrator2 
{
	/*Demonstrates doing something that throws an exception.
	 * See that if methodB throws an exception, the rest of methodB
	 * did not execute and neither did methodC.*/
	
	public static void main(String[] args) throws ExceptionB 
	{
		Demonstrator2 demo = new Demonstrator2();
		demo.methodA();
	}
	
	
	
	
	private void methodA() throws ExceptionB
	{
		System.out.println("Started methodA");		
		methodB();
		System.out.println("Ended methodA");
	}

	private void methodB() throws ExceptionB
	{
		System.out.println("Started methodB");
		
		Double value = Math.random();	
		System.out.println("Value is: "+value);
		if (value > 0.5)
			throw new ExceptionB();
		
		methodC();
		System.out.println("Ended methodB");
	}
	
	private void methodC()
	{
		System.out.println("Started methodC");
		System.out.println("Ended methodC");
	}
}
