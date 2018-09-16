import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class ItemListGenerator{
//It takes list of items and put their information into system for begening of billing process
 public HashMap<String, Item> getAllItems() {
 
  HashMap<String, Item> itemMap = new HashMap<String, Item>();
 
  //file you want to access
  File itemFile = new File("itemlist.csv");
 
 
  try {
   //reading file
   Scanner scanner = new Scanner(itemFile);
  
   //loop until you reach end of file
   while (scanner.hasNext()) {
   
    //reading one line at a time
    String fileRecord = scanner.nextLine();

    //Chopping line based on comas (,)
    String[] fileRecordSplit = fileRecord.split(",");  
   
    //Creating list in system
    Item item = new Item();
    item.setId(fileRecordSplit[0]);
    item.setDescription(fileRecordSplit[1]);
   
    //putting price into system for billing
    Cost price = new Cost();
    price.setAmount(Double.parseDouble(fileRecordSplit[2]));
    
    item.setCost(price);
   
    itemMap.put(item.getId(), item); //creating itemid (key for it)
   }
  } catch (FileNotFoundException e) {
   e.printStackTrace();
  }

  return itemMap;
 }
}
