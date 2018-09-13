import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class ObjectToStore implements Serializable 
{   
   private static final long serialVersionUID = 2L;
   private String name;
   private int age;
   //private Grade grade;
   private MathGrade mathGrade;
   //public int writeCount; //to demonstrate custom reading/writing
   //public int readCount;
   
   public ObjectToStore(String name, int age)
   {
	   this.name = name;
	   this.age = age;
	 //  grade = new Grade(50,60);
	   mathGrade = new MathGrade(75);
	   //writeCount=0;
	   //readCount=0;
   }
   
  
   public static long getSerialversionuid() 
   {
	  return serialVersionUID;
   }
	
   public void setName(String name)
   {
	   this.name = name;
   }
   
   public String getName()
   {
	   return this.name;
   }
   
   public void setAge(int age)
   {
	   this.age = age;
   }
   
   public int getAge()
   {
	   return this.age;
   }
 /*  
   public Grade getGrade() 
   {
	   return grade;
   }

   public void setGrade(Grade grade) 
   {
	   this.grade = grade;
   }
   */
   
   
   public MathGrade getMathGrade() 
   {
	   return mathGrade;
   }
	
   public void setMathGrade(MathGrade mathGrade) 
   {
	  this.mathGrade = mathGrade;
   }
   
  
   /*
    private void writeObject(ObjectOutputStream out) throws IOException
   {
	   writeCount++;
	   out.defaultWriteObject();
   }
   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
   {
	   in.defaultReadObject();
	   readCount++;
   } 
   */
   
   
}
