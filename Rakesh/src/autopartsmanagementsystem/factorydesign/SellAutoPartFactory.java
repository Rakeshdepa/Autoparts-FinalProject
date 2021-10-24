package autopartsmanagementsystem.factorydesign;
//Creating a SellAutoPartFactory to generate object of concrete class based on given information.

public class SellAutoPartFactory {
   //use getSchedule method to get object of manager 
   public AutoPart getSellAutoPart(String getSchedule){
       if(getSchedule == null){
           return null;
       }
       if(getSchedule.equalsIgnoreCase("viewInventory")){
           return new ViewAutoPart();
       }
       else if(getSchedule.equalsIgnoreCase("sellAutoPart")){
           return new EnterAutoPart();
       }
       return null;
   }    
}
