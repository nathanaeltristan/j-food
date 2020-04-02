/**
 * Write a description of class JFood here.
 *
 * @author nathanaeltristan
 * @version 20/02/2020
 */

import javax.xml.crypto.Data;
import java.util.*;


public class JFood
{
    public static void main(String[] args_)
    {
        Location location = new Location("Jakarta", "Capital", "Kebayoran Lama Utara");

        DatabaseSeller.addSeller(new Seller(29, "John", "john@gmail.com", "085155343144", location));

        Calendar calendar = new GregorianCalendar(2020,04,02);

        DatabaseFood.addFood(new Food(1, "Caramel Macchiato", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 45000, FoodCategory.COFFEE));
        DatabaseFood.addFood(new Food(2, "Asian Dolce Latte", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 25000, FoodCategory.COFFEE));
        DatabaseFood.addFood(new Food(3, "Ramen", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 75000, FoodCategory.JAPANESE));

        System.out.println("Daftar Food Category Coffee: ");
        for (Food food : DatabaseFood.getFoodByCategory(FoodCategory.COFFEE))
        {
            System.out.println(food.getName());
        }

        DatabaseCustomer.addCustomer(new Customer(13, "Hosea", "hosea@gmail.com", "AkuWibu345", calendar));
        DatabaseCustomer.addCustomer(new Customer(45, "Hosea", "hosea@gmail.com", "AkuWibu123", 2020, 04, 02));
        DatabaseCustomer.addCustomer(new Customer(35, "Rama", "rama@gmail.com", "AkuBukanWibu234"));

        System.out.println("Daftar Customer: ");
        for (Customer customer : DatabaseCustomer.getCustomerDatabase())
        {
            System.out.println(customer.getName());
        }
    }
}