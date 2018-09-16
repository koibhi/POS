import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Saleslineitem {

 ShoppingCart cart = new ShoppingCart();

 //Now we are starting shopping process
 public void start() {
 
  int i = 0;
 
  Scanner scanr  = new Scanner(System.in);
 // cases for 1 = ADD, 2 = Remove, 0 = Exit
  do {
   System.out.println("Press [1 = ADD, 2 = Remove, 0 = Exit]");
   i = scanr.nextInt();
  
   switch(i) {
    case 1 : 
     add();
     break;
    case 2 :
     Scanner sc = new Scanner(System.in);
     System.out.println("please tell Item id you want to remove = ");
     String Id = sc.next();
     delete(Id);
     break;
    case 0 :
     break;
    default:
    System.out.println("Invalid choice.");

   }
  } while (i != 0);
 }

 
 public void add() {
  cart.create();
 }

//Bill creation
 public void checkOut() {
  //TODO: do validation if any
  ArrayList<String> Ids = cart.read();
 
  //Create details of each item based on the item id
  ArrayList<Item> purchased = cart.loadItem(Ids);

  double total = 0;
 
  System.out.println("__________items purchased____________");
 
  for (Item item : purchased) {
    total = total + item.getCost().getAmount();
    System.out.println(item.printStatus());
  }

  System.out.println("***********************************");
  System.out.println("Total Amount : " + total+"CAD");
  System.out.println("***********************************");
 
  //converting bill into a file
  recordBill(purchased);
 }

 //to record bill into a file 
 private void recordBill(ArrayList<Item> purchaseditems) {
  //create Transaction
  Bill bill = new Bill();
  bill.setId("T-788"); //Setting id for bill
 
  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
  bill.setDate(dateFormat.format(new Date()));
 
  Operator operator = new Operator();
  operator.setId("O-005");
  bill.setOperator(operator);
 
  Register machine = new Register();
  machine.setId("M-101");
  bill.setMachine(machine);
 
  //creating client info
  Client client = new Client();
  client.setId("C-101"); 
  bill.setClient(client); 

  //creating item objects from arraylist
  Item[] items = purchaseditems.toArray(new Item[purchaseditems.size()]);
  bill.setItems(items);
 
  //saving bill in file
   try {
             FileWriter writer = new FileWriter("Bill.csv", true); //if true means append mode
             BufferedWriter bufWriter =new BufferedWriter(writer);
             
             for (Item item : items) {             
              bufWriter.write(bill.getId());
              bufWriter.write(",");
              bufWriter.write(bill.getDate());
              bufWriter.write(",");
              bufWriter.write(bill.getOperator().getId());
              bufWriter.write(",");
              bufWriter.write(bill.getMachine().getId());
              bufWriter.write(",");
              bufWriter.write(bill.getClient().getId());
              bufWriter.write(",");
              bufWriter.write(item.getId());
              bufWriter.write(",");
                    
              bufWriter.write(String.valueOf(item.getCost().getAmount())); 
              bufWriter.write("\n");
             }
             
             bufWriter.flush();
             bufWriter.close();
             writer.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
 }

 public void delete(String Id) {
  cart.delete(Id);
 }
}
