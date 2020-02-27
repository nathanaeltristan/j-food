
/**
 * Write a description of class JFood here.
 *
 * @nathanaeltristan
 * @20022020
 */
public class JFood
{
    public static void main(String[] args_)
    {
        Location location = new Location("Jakarta", "Capital", "Jakarta Selatan");
        Seller seller = new Seller(1, "Tristan", "nathanael.tristan@ui.ac.id", "085155343144", location);
        Food food = new Food(1, "Cordon bleu", seller, 25000, "Beef");
        Customer customer = new Customer(1, "John", "john.tristan@ui.ac.id", "12345678", "21/11/1999");
        Invoice invoice = new Invoice(1, 1, "27/02/2020", 25000, customer);
        
        location.printData();
        seller.printData();
        customer.printData();
    }
}