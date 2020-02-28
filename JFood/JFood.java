
/**
 * Write a description of class JFood here.
 *
 * @author nathanaeltristan
 * @version 20/02/2020
 */
public class JFood
{
    public static void main(String[] args_)
    {
        Location location = new Location("Jakarta", "Capital", "Jakarta Selatan");
        Seller seller = new Seller(1, "Tristan", "nathanael.tristan@ui.ac.id", "085155343144", location);
        Food food = new Food(1, "Steak", seller, 75000, "Beef");
        Customer customer = new Customer(1, "John", "john@ui.ac.id", "12345678", "19/11/1998");
        Invoice invoice = new Invoice(1, 1, "27/02/2020", 25000, customer);
        
        
        seller.printData();
        food.printData();
        seller.setName("Rama");
        seller.printData();
    }
}