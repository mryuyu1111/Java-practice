import java.util.*;
 
class Palindrome
{
  public static void main(String args[])
  {
	Palindrome tester = new Palindrome();
    String inputString;
    Scanner in = new Scanner(System.in);
 
    System.out.println("Input a string");
    inputString = in.nextLine();
 
    System.out.println(tester.compareBack(inputString));
    System.out.println(tester.reverse(inputString));
  }
  
  String compareBack(String s)
  {
	  int length  = s.length();
	    int i, begin, end, middle;
	 
	    begin  = 0;
	    end    = length - 1;
	    middle = (begin + end)/2;
	 
	    for (i = begin; i <= middle; i++) {
	      if (s.charAt(begin) == s.charAt(end)) {
			begin++;
			end--;
		  }
	      else {
		    break;
	      }
	    }
	    if (i == middle + 1) {
	      return "Palindrome";
	    }
	    else {
	      return "Not a palindrome";
	    } 	
  }
  
  String reverse(String s)
  {
	  String reverse = "";
	  
	  for(int i = s.length() - 1; i >= 0; i--)
	  {
		  reverse += s.charAt(i);
	  }
	  
	  if (reverse.equals(s))
		  return "Palindrome";
	  else
		  return "Not a Palindrome";
  }
}