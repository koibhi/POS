
public class Bill {

 private String id;
 private Operator operator;
 private Register register;
 private Client client;
 private String date;
 private Item[] item;

 public String getDate() {
  return date;
 }
 public void setDate(String d) {
  this.date = d;
 }
 public Item[] getItems() {
  return item;
 }
 public void setItems(Item[] i) {
  this.item = i;
 }
 public String getId() {
  return id;
 }
 public void setId(String i) {
  this.id = i;
 }
 public Operator getOperator() {
  return operator;
 }
 public void setOperator(Operator o) {
  this.operator = o;
 }
 public Register getMachine() {
  return register;
 }
 public void setMachine(Register r) {
  this.register = r;
 }
 public Client getClient() {
  return client;
 }
 public void setClient(Client c) {
  this.client = c;
 }
}