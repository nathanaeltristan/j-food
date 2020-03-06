
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
        Location location = new Location("Jakarta", "Capital", "Tangsel");
        Seller seller = new Seller(1, "Frenzel", "f@ui.ac.id", "085155343144", location);
        Food food = new Food(1, "Caramel Macchiato", seller, 45000, FoodCategory.COFFEE);
        Customer customer = new Customer(1, "Timothy", "john@ui.ac.id", "12345678", "19/11/1998");
        Invoice invoice = new Invoice(1, 1, "2020-01-01", 45000, customer, PaymentType.CASH, InvoiceStatus.FINISHED);
        
        
        invoice.printData();
    }
}