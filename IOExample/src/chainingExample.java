import java.io.*;

class chainingExample 
{
  public static void main(String [] args) 
  {
    char[] in = new char[9];           // to store input
    int size = 0;
    try {
      
      //Using only a writer	
      File file1 = new File("thursday1.txt");// just an object
      FileWriter fw = new FileWriter(file1);  // create an actual file
                                             // & a FileWriter obj
      fw.write("howdy\nfolks\n");       // write characters to the file                                       
      fw.flush();                       // flush before closing
      fw.close();                       // close file when done
      
      FileReader fr = new FileReader(file1);  // create a FileReader object                                        
      size = fr.read(in);               // read the whole file!
      System.out.print(size + " ");     // how many bytes read
      for(char c : in)                  // print the array
        System.out.print(c);
      fr.close();                       // again, always close
      
      
      //combining classes makes reading/writing easier
      File file2 = new File("thursday2.txt");  // create a File object
      FileWriter fw2 = new FileWriter(file2);    // create a FileWriter
                                               // that will send its
      											// output to a File
      
      PrintWriter pw = new PrintWriter(fw2);    // create a PrintWriter
                                               // that will send its
                                               // output to a Writer
      pw.println("howdy");                     // write the data
      pw.println("folks");
      
      pw.flush();
      pw.close();

      FileReader fr2 = new FileReader(file2);
      BufferedReader br = new BufferedReader(fr2);
      String thisLine;
      
      while((thisLine = br.readLine()) != null)
         System.out.println("Read Line: "+thisLine);
          
      
    } catch(IOException e) { }
    
  }
}

