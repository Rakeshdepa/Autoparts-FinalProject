package commanddesign;
//Login uses command pattern to identify which object will execute which command based on the type of command
import autopartsmanagementsystem.factorydesign.SellAutoPartFactory;
import commanddesign.iteratordesign.IncomeRepository;
import commanddesign.iteratordesign.Iterator;
import commanddesign.observer.AutoPartInv;
import autopartsmanagementsystem.factorydesign.AutoPart;
import commanddesign.observer.ViewAutoPartObserver;
import commanddesign.observer.EnterAutoPartObserver;
import autopartsmanagementsystem.AutoPartsManagementSystem;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
      public void view() throws IOException {
       ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get("LoginData.txt"))); // Handle a potential exception       
       Scanner input =new Scanner(System.in);
       
       System.out.println("Enter Your Username: ");
       String usernameword=input.next();
       System.out.println("Enter Your Password: ");
       String passwordword=input.next();
       
       File f=new File("LoginData.txt");
	BufferedReader freader = new BufferedReader(new FileReader(f));
	String s;
        int i= 0;
	while((s = freader.readLine()) != null) {
        String username = lines.get(i);
        String password = lines.get(i+1);
	
	
        if(username.equalsIgnoreCase(usernameword)&& password.equalsIgnoreCase(passwordword)){
            int swValue;
            int InventoryValue;
            int CoachesValue;
            int ScheduleValue;
            int PassengerValue;
            while(true){
            // Displaying menu graphics
            System.out.println("Auto Parts Management System");
            System.out.println("Main Menu:");
            System.out.println("1. Auto Parts Inventory");
            System.out.println("2. Sell Auto Parts");
            System.out.println("3. Income Generated");
            System.out.println("4. Exit");
            swValue = Keyin.inInt("Select option: ");
            System.out.println("\n");
            
            switch (swValue) {

//CASE 2 IS INVENTORY MODULE USING OBSERVER DESIGN PATTERN 
//Observer pattern uses three actor classes. AutoPartInv, Observer and Client                    
                case 1:
                    System.out.println("Enter 1 to View All Inventory");
                    System.out.println("Enter 2 to Insert Item To Inventory");
                    InventoryValue = Keyin.inInt(" Select option: ");
                    System.out.println("\n");
                    
                    AutoPartInv autopartinv = new AutoPartInv();
                    
                    if(InventoryValue==1){
//Using ViewAutoPartObserver and concrete observer objects.
                        new ViewAutoPartObserver(autopartinv);
//AutoPart is an object having methods to attach and detach observers to a client object                        
                        autopartinv.setState(1);
                    }
                     else if(InventoryValue==2){
//Using ViewAutoPartObserver and concrete observer objects.                         
                        new EnterAutoPartObserver(autopartinv);
//AutoPart is an object having methods to attach and detach observers to a client object                        
                        autopartinv.setState(1);
                        break;
                    }
                    
                    break;
                    
//CASE 2 Sell Auto Part USING FACTORY DESIGN PATTERN
//We will use SellAutoPartFactory to get a object. It will pass information (viewSchedule,enterSchedule) 
//to SellAutoPartFactory to get the type of object it needs.                    
                case 2:
                    System.out.println("*****Sell AutoPart*****");
//Using the SellAutoPartFactory to get object of concrete class by passing an information such as type.                    
                    SellAutoPartFactory sellAutoPartFactory = new SellAutoPartFactory();

     
//get an object of EnterAutoPart and call its viewEnterAutoPart method.
                        AutoPart viewAutoPart = sellAutoPartFactory.getSellAutoPart("viewInventory");
                        viewAutoPart.viewEnterAutoPart();
                    
                        
                        
                   
//get an object of EnterAutoPart and call its viewEnterAutoPart method.
                        AutoPart enterAutoPart = sellAutoPartFactory.getSellAutoPart("sellAutoPart");
                        enterAutoPart.viewEnterAutoPart();
                    
                    
                    break;
                    

                    
//CASE 3 IS INCOME GENERATED USING ITERATOR DESIGN PATTERN
//We're creating an ITERATOR interface which narrates navigation method and a Container interface 
//which retruns the iterator. 
//Concrete classes implementing the Container interface will be responsible to implement Iterator interface and use it                                      
//Using the SeatingRepository to get iterator and print Types of seating class available.
                    case 3: 
                    IncomeRepository seatsRepository = new IncomeRepository();
                    for(Iterator iter = seatsRepository.getIterator(); iter.hasNext();){
                        String seat = (String)iter.next();
                        System.out.println(seat);
                    }
                    break;                   
                    
//CASE 4 IS EXITING PROGRAM 
                    case 4:
                        System.out.println("Thank You!!!");
                        System.exit(0);
                    
//CASE DEFAULT IS PRINTING OUT THE INVALID SELECTION BY THE USER
                    default:
                        System.out.println("Invalid selection");
                        break; // This break is not really necessary but its a formality
            }
            }
            
        }
      
        break;
        
        
  
        }
        System.out.println("WRONG USERNAME/PASSWORD. TRY AGAIN!!");
        view();
   }
      
static class Keyin {

  //*******************************
  //   support methods
  //*******************************
  //Method to display the user's prompt string
  public static void printPrompt(String prompt) {
    System.out.print(prompt + " ");
    System.out.flush();
  }

  //Method to make sure no data is available in the
  //input stream
  public static void inputFlush() {
    int dummy;
    int bAvail;

    try {
      while ((System.in.available()) != 0)
        dummy = System.in.read();
    } catch (java.io.IOException e) {
      System.out.println("Input error");
    }
  }

  //********************************
  //  data input methods for
  //string, int, char, and double
  //********************************
  public String inString(String prompt) {
    inputFlush();
    printPrompt(prompt);
    return inString();
  }

  public static String inString() {
    int aChar;
    String s = "";
    boolean finished = false;

    while (!finished) {
      try {
        aChar = System.in.read();
        if (aChar < 0 || (char) aChar == '\n')
          finished = true;
        else if ((char) aChar != '\r')
          s = s + (char) aChar; // Enter into string
      }

      catch (java.io.IOException e) {
        System.out.println("Input error");
        finished = true;
      }
    }
    return s;
  }

  public static int inInt(String prompt) {
    while (true) {
      inputFlush();
      printPrompt(prompt);
      try {
        return Integer.valueOf(inString().trim()).intValue();
      }

      catch (NumberFormatException e) {
        System.out.println("Invalid input. Not an integer");
      }
    }
  }

  public char inChar(String prompt) {
    int aChar = 0;

    inputFlush();
    printPrompt(prompt);

    try {
      aChar = System.in.read();
    }

    catch (java.io.IOException e) {
      System.out.println("Input error");
    }
    inputFlush();
    return (char) aChar;
  }

  public double inDouble(String prompt) {
    while (true) {
      inputFlush();
      printPrompt(prompt);
      try {
        return Double.valueOf(inString().trim()).doubleValue();
      }

      catch (NumberFormatException e) {
        System.out
            .println("Invalid input. Not a floating point number");
      }
    }
  }
}
    
    
  
}
  
  



