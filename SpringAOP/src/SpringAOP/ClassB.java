
package SpringAOP;

public class ClassB {

	public void method1()
	{
		System.out.println("Class B method1 actual action.");
	}
	
	
	public void method2()
	{
		System.out.println("Class B method2 actual action.");
		
	}
	
	
	public ClassB getInstance()
	{
		System.out.println("Class B Being Created!");
		return new ClassB();
	}
}
