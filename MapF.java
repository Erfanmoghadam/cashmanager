
import java.io.*;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class MapF{
 public static void main(String[] args) {
     HashMap<Integer, Integer> cash = new HashMap<>();
     try {
         FileWriter file = new FileWriter("D:\\F(for programming)\\Java Work Space\\cashManager\\src\\test.txt");
         String newLine = System.getProperty("line.separator");
         Random random = new Random();
         for (int i = 0; i < 100000; i++) {
             int randNumber = random.nextInt(500000);
             file.write(randNumber + "\n");
             //This condition reduce cash size if we want rapid access we can omit it or reduce the i
             if (i%10 == 3) {
                 cash.put(randNumber, i + 1);
             }
         }
         file.close();
         
/*      Formatter f = new Formatter("H:\\javap\\filed\\test.txt"); // to creat the file use with Formatter.
        f.format("%s" , "Ali is good boy");
        File file =  new File("H:\\javap\\filed\\test2.txt");//creat a file object
        file.createNewFile(); // we can put this in if() to sure the file created...
        Scanner scanner = new Scanner(file); // scanner method is used for reading a file
        if(file.exists()) // exists() method for .....
            System.out.println("the file exists"); 
        else
            System.out.println("not find this file");
        System.out.println(file.getClass()); //getName() method for file name
        // and hasNext() and next() methods use for exists and read word by word fle too.
       f.close();//you must close the file then end work with file
*/
     } catch (Exception e) {
         System.out.println(e);
     }
     List<String> lines = null;
     try {
         lines = Files.readAllLines(Paths.get("D:\\F(for programming)\\Java Work Space\\cashManager\\src\\test.txt"));
     } catch (IOException e) {
         e.printStackTrace();
     }
     Scanner scanner = new Scanner(System.in);
     boolean exit = false;
     while (!exit) {
         System.out.println("Please Enter a  Number little than 500000");
         String entered = scanner.nextLine();
         if (entered.equals("exit")){
             exit = true;
         }
         boolean found = false;
         if (!entered.equals("exit")) {
             int num = Integer.parseInt(entered);
                 if (cash.containsKey(num)) {
                     System.out.println("CashHit ,line: " + cash.get(num));
                     found = true;
                 }
         }
         int j = 0;
         if (!found) {

             for (String line : lines) {
                 j++;
                 if (line.equals(entered)) {
                     found = true;
                     //System.out.println("We found this number in line(" + j + ") at this file");
                     System.out.println("CashMiss, line: "+ j);
                     break;
                 } else {
                     found = false;
                 }
             }
         }
         if (!found&&!exit) {
             System.out.println("NotFound_CashMiss");
         }

     }
 }
}
