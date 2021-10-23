package commanddesign;
//We have concrete command classes ViewLogin implementing Order interface which will do actual command processing
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewLogin implements Order {
    private Login login;

   public ViewLogin(Login train){
      this.login = train;
   }

    public void execute() {
        try {
            login.view();
        } catch (IOException ex) {
            Logger.getLogger(ViewLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}    

