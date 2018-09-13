
public class numberconversiontesting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object[] x = { 1 , 2.0, 3L, 4f, new Integer(5), Integer.parseInt("6") };
		
		for(Object i : x)
		{
			System.out.println(i);
			System.out.println(i.getClass().toString());
		}

	}

}
