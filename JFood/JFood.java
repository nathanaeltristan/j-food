/**
 * Write a description of class JFood here.
 *
 * @author nathanaeltristan
 * @version 20/02/2020
 */

import java.util.*;


public class JFood
{
    public static void main(String[] args_)
    {
        Location location = new Location("Jakarta", "Capital", "Gandaria");
        
        Seller seller = new Seller(1, "Tristan", "nathanael.tristan@ui.ac.id", "085155343144", location);
        
        Food food1 = new Food(1, "Caramel Macchiato", seller, 45000, FoodCategory.COFFEE);
        Food food2 = new Food(2, "Asian Dolce Latte", seller, 25000, FoodCategory.COFFEE);
        Food food3 = new Food(3, "Green Tea Latte", seller, 15000, FoodCategory.COFFEE);
        
        Customer customer1 = new Customer(13, "Hosea", "hosea@gmail.com", "AkuWibu345", new GregorianCalendar(2020, 03, 26));
        Customer customer2 = new Customer(45, "Leonardus", "leonardus@gmail.com", "AkuWibu123", 2020, 03, 26);
        Customer customer3 = new Customer(35, "Michael", "michael@gmail.com", "AkuWibu234");
        
        System.out.println(customer1.toString());
        System.out.println(customer2.toString());
        System.out.println(customer3.toString());
    }
}