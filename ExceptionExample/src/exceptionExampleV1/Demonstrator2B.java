package exceptionExampleV1;

public class Demonstrator2B 
{
	/* Variation of Demonstrator2, shows that instead of the main method throwing
	 * an ExceptionB and then crashing my entire program, I can catch it in the
	 * main method and then continue executing the remainder of the main method. 
	 * Though I did not get to finish executing the code in methodC or the end of methodB.
	 * */
	
	public static void main(String[] args) 
	{
		Demonstrator2B demo = new Demonstrator2B();
		try {
			demo.methodA();
		}
		catch (ExceptionB e){		
			System.out.println("Dealt with method B's problem in the main method");
		}
		System.out.println("Didn't crash me, ha!");
		
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
