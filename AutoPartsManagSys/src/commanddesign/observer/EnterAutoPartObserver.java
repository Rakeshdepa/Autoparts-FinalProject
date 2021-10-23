package commanddesign.observer;
//Create concrete observer classes
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class EnterAutoPartObserver extends AutoPartInvObserver {
    public EnterAutoPartObserver(AutoPartInv autopartinv){
        this.autopartinv = autopartinv;
        this.autopartinv.attach(this);
    }

    @Override
    public void update() {
        try{
            Scanner sc=new Scanner(System.in);                          //object of Scanner class  
            String name= "InventoryData.txt";                             //variable name to store the file name  
            FileOutputStream fos = new FileOutputStream(name, true);    // true for append mode  

            System.out.print("Enter Part Number: ");         
            String PartNumber=sc.nextLine()+"\n";                        //str stores the string which we have entered  
            byte[] pnumber = PartNumber.getBytes();                        //converts string into bytes  
            fos.write(pnumber);  
            
            System.out.print("Enter Part Name  : ");         
            String PartName=sc.nextLine()+"\n";                     //str stores the string which we have entered  
            byte[] pname = PartName.getBytes();                  //converts string into bytes  
            fos.write(pname); 
            
            System.out.print("Enter Part Price : ");         
            String PartPrice=sc.nextLine()+"\n";                     //str stores the string which we have entered  
            byte[] pprice = PartPrice.getBytes();                  //converts string into bytes  
            fos.write(pprice); 
            
            fos.close();                                                //close the file  
            System.out.println("file saved.");
        }
        catch(IOException e)
        {
        }
    }
    
}
