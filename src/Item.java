
public class Item {

 private Cost price;
 private String id;
 private String des;

 public Cost getCost() {
  return price;
 }
 public void setCost(Cost price) {
  this.price = price;
 }
 public String getId() {
  return id;
 }
 public void setId(String id) {
  this.id = id;
 }
 public String getDescription() {
  return des;
 }
 public void setDescription(String des) {
  this.des = des;
 }

//returning string for billing purpose
 public String printStatus() {
  return  id + "," + 
    des + "," +
    price.getAmount() + "," 
    ;
 }
}