
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
        Food food1 = new Food(1, "Caramel Macchiato", seller, 45000, FoodCategory.COFFEE);
        Food food2 = new Food(2, "Asian Dolce Latte", seller, 25000, FoodCategory.COFFEE);
        Food food3 = new Food(3, "Green Tea Latte", seller, 15000, FoodCategory.COFFEE);
        Customer customer = new Customer(1, "Timothy", "john@ui.ac.id", "12345678", "19/11/1998");
        Promo promo = new Promo(1, "OVO12", 2500, 25000, true);
        Invoice invoice1 = new CashlessInvoice(1, food1, "12-03-2020", customer, InvoiceStatus.FINISHED);
        Invoice invoice2 = new CashlessInvoice(2, food2, "12-03-2020", customer, InvoiceStatus.FINISHED, promo);
        Invoice invoice3 = new CashlessInvoice(3, food3, "12-03-2020", customer, InvoiceStatus.FINISHED, promo);
        
        
        
        invoice1.setTotalPrice();
        invoice2.setTotalPrice();
        invoice3.setTotalPrice();
        invoice1.printData();
        invoice2.printData();
        invoice3.printData();
    }
}