package commanddesign.iteratordesign;
//Creating a concrete class which implements the Container interface. 
//This class has inner class SeatingIterator that implements the Iterator interface.

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class IncomeRepository implements Container {
   public String income[] = {"Total Income Generated is $"};

    public IncomeRepository() {
        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get("IncomeData.txt")));
            int sum = 0;
            File f = new File("IncomeData.txt");
            Scanner scanner = new Scanner(f);
        while (scanner.hasNext()){
            sum += scanner.nextInt();
        }
            income[0] += String.valueOf(sum);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
   public Iterator getIterator() {
      return new SeatingIterator();
   }

   private class SeatingIterator implements Iterator {

      int index;

      public boolean hasNext() {
      
         if(index < income.length){
            return true;
         }
         return false;
      }

      public Object next() {
      
         if(this.hasNext()){
            return income[index++];
         }
         return null;
      }		
   }
}
