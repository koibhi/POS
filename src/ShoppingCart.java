import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class ShoppingCart {

 //creating arraylist for itemlist
 static ArrayList<String> itemlist = new ArrayList<String>();

 //creating item id
 public void create() {
  Scanner scanr = new Scanner(System.in);
  String Id = "0";
 
  do {
   //Begging for input
   System.out.println("Enter ItemId, [0 = Exit] : ");
   Id = scanr.next();
   
   if (!Id.equals("0")) {
    itemlist.add(Id);
   }
  
  } while (!Id.equals("0"));
 }

 //Returning list of items
 public ArrayList<String> read() {
  return itemlist;
 }

 // deleting list of items
 public void delete(String id) {
  itemlist.remove(id);
 }

// creating list of items based on item ids
 public ArrayList<Item> loadItem(ArrayList<String> itemIds) {
 
  ArrayList<Item> purchased = new ArrayList<Item>();
 
  ItemListGenerator itemManager = new ItemListGenerator();
  HashMap<String,Item> allItems = itemManager.getAllItems();
 
  for (int i = 0; i < itemIds.size(); i++) {
   purchased.add(allItems.get(itemIds.get(i)));
  }
  return purchased;
 }
}
