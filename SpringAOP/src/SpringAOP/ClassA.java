package SpringAOP;

public class ClassA {

	public void method1()
	{
		System.out.println("Class A method1 actual action.");
	}

	public int method2()
	{
		System.out.println("Class A method2 actual action.");
		return 1;
	}
	
	
	public int method2(int x)
	{
		System.out.println("Class A method2 WITH ARG actual action.");
		return 1;
	}
	
	public ClassB getInstance()
	{
		System.out.println("Class B Being Created!");
		return new ClassB();
	}


}
