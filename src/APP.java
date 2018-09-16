import java.util.HashMap;
import java.util.Iterator;


public class APP {

 public static void main(String[] args) {
  //getting list of items into billing system
  ItemListGenerator itemlist = new ItemListGenerator();
  HashMap<String, Item> iMap = itemlist.getAllItems();

  Iterator<String> iterator = iMap.keySet().iterator();

  System.out.println("Items Available              [ItemNumber, Description, Price]");

  while (iterator.hasNext()) {
   Item item = iMap.get(iterator.next()); 
   System.out.println(item.printStatus());
  }

  System.out.println("______________________________________");

  Saleslineitem cart = new Saleslineitem();
  cart.start();
  cart.checkOut();

  System.out.println("Do What really matters to you in life. Whatever it is , it should be worthy of you");
 }
}