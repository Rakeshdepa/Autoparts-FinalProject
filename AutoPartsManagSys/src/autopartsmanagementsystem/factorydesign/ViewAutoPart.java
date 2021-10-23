package autopartsmanagementsystem.factorydesign;
//Create concrete classes implementing the same interface.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewAutoPart implements AutoPart{
    public void viewEnterAutoPart() {
       ArrayList<String> lines = null;
        try {
            lines = new ArrayList<>(Files.readAllLines(Paths.get("InventoryData.txt"))); // Handle a potential exception
        }
        catch (IOException ex) {
           
        }
        for(int i = 0; i<lines.size();i++){
            System.out.println("______________________________");
            System.out.println("Part ID     : "+lines.get(i));
            System.out.println("Part Name   : "+lines.get(i+1));
            System.out.println("Part Price  : "+lines.get(i+2));
            System.out.println("______________________________");
            i=i+2;
            System.out.println("\n");
        }
   }    
}
