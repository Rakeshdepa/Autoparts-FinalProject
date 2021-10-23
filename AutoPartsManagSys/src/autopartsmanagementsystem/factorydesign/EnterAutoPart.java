package autopartsmanagementsystem.factorydesign;
//Create concrete classes implementing the same interface.

import autopartsmanagementsystem.factorydesign.AutoPart;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class EnterAutoPart implements AutoPart {

    public void viewEnterAutoPart() {
        try {
            Scanner sc = new Scanner(System.in);                //object of Scanner class  
            String name = "IncomeData.txt";                  //variable name to store the file name  
            FileOutputStream fos = new FileOutputStream(name, true);  // true for append mode  

            System.out.print("Enter Part ID Only: ");
            String PartID = sc.nextLine();               //str stores the string which we have entered  

            ArrayList<String> lines = null;
            try {
                boolean isFound = false;
                lines = new ArrayList<>(Files.readAllLines(Paths.get("InventoryData.txt"))); // Handle a potential exception
                for (int i = 0; i < lines.size(); i++) {
                    String ID = lines.get(i);
                    if (PartID.equalsIgnoreCase(ID)) {
                        System.out.print("Enter Part Price: ");
                        String price = sc.nextLine() + "\n";                   //str stores the string which we have entered  
                        byte[] p = price.getBytes();                       //converts string into bytes  
                        fos.write(p);

                        fos.close();                                      //close the file  
                        System.out.println("file saved.");
                        isFound = true;
                        break;
                    }
                }
                if(isFound ==false){
                    System.out.println("Part Id not Exists");
                }

            } catch (IOException ex) {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewEnterSchedule() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
