package commanddesign.observer;
//AutoPartInv is an object having methods to attach and detach observers to a client object
import java.util.ArrayList;
import java.util.List;

public class AutoPartInv {
    private List<AutoPartInvObserver> autopartinvobservers = new ArrayList<AutoPartInvObserver>();
    private int state;
    
    public int getState() {
        return state;
    }
    
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(AutoPartInvObserver autopartinvobserver){
        autopartinvobservers.add(autopartinvobserver);
    }

    public void notifyAllObservers(){
        for (AutoPartInvObserver autopartinvobserver : autopartinvobservers) {
        autopartinvobserver.update();
        }
    } 	
    
}
