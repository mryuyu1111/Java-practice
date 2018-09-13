import java.io.Serializable;


public class Grade implements Serializable
{   
   private int grade1;
   private int grade2;
 /*  
   public Grade()
   {
	   grade1=89;
	   grade2=91;
   }
  */
   
   public Grade(int grade1, int grade2)
   {
	   this.grade1 = grade1;
	   this.grade2 = grade2;
   }
   
    public int getGrade1() 
    {    
		return grade1;
	}

	public void setGrade1(int grade1) {
		this.grade1 = grade1;
	}

	public int getGrade2() {
		return grade2;
	}

	public void setGrade2(int grade2) {
		this.grade2 = grade2;
	}
}
