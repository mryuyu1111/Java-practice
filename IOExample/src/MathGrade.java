import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class MathGrade extends Grade implements Serializable
{

	private int mathGrade1;
	
	public MathGrade()
	{
		super(20,30);
	}
	
	public MathGrade(int mathGrade1)
	{
		super(20, 30);
		this.mathGrade1 = mathGrade1;
	}

//	private void writeObject(ObjectOutputStream out) throws IOException
//	{
//		mathGrade1 = 13;
//		out.defaultWriteObject();
//	}

	
	public int getMathGrade1() {
		return mathGrade1;
	}

	public void setMathGrade1(int mathGrade1) {
		this.mathGrade1 = mathGrade1;
	}
}
