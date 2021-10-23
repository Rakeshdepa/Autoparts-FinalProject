package autopartsmanagementsystem;

import commanddesign.Login;
import commanddesign.ViewLogin;
import commanddesign.LoginInvoker;
import java.io.IOException;

public class AutoPartsManagementSystem {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
          
        
        System.out.println("Auto Parts MANAGEMENT SYSTEM");
        System.out.println("            -----------------------------");
        System.out.println("          /     /''''''''''''''''''''''\\  \\");
        System.out.println("         /     /________________________\\  \\");
        System.out.println(" ======     *   ======================   *   =========");
        System.out.println("{ Auto   *     * Part     Management  *     * System  |");
        System.out.println(" -------*   O   *------------------- *   O   *--------|");
        System.out.println("         *     *                      *     *          ");
        System.out.println("            *                            *             ");
        System.out.println();
        
//ADMIN LOGIN USING COMMAND DESIGN PATTERN   
//In this command design pattern we are encapsulating  a request as an object,
//which lets us parameterize other objects with different requests and support undoable operations.
//We have created an interface Order.java which is acting as a command                
//will use ADMIN class to demonstrate command pattern.                
               
//Create a command interface.                        
                        Login login = new Login();                        
//Create a request class.                        
                        ViewLogin viewLoginOrder = new ViewLogin(login);
//Creating a command invoker class.                         
                        LoginInvoker loginInvoker = new LoginInvoker();
                      
                        loginInvoker.takeOrder(viewLoginOrder);
                        loginInvoker.placeOrders();
    }




// keyin methos is for input of character and numeric types only in main menu

class Keyin {

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
  public static String inString(String prompt) {
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

  public static char inChar(String prompt) {
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

  public static double inDouble(String prompt) {
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
    

