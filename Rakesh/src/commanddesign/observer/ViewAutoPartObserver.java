package commanddesign.observer;
//Create concrete observer classes
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewAutoPartObserver extends AutoPartInvObserver {
    public ViewAutoPartObserver(AutoPartInv autopartinv){
        this.autopartinv = autopartinv;
        this.autopartinv.attach(this);
    }

    @Override
    public void update() {
        ArrayList<String> lines = null;
        try {
            lines = new ArrayList<>(Files.readAllLines(Paths.get("InventoryData.txt"))); // Handle a potential exception
        } catch (IOException ex) {
            Logger.getLogger(ViewAutoPartObserver.class.getName()).log(Level.SEVERE, null, ex);
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
