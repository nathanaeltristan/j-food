/**
 * Write a description of class JFood here.
 *
 * @author nathanaeltristan
 * @version 20/02/2020
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.Object;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class JFood {
    public static void main(String[] args_) {
        Location location = new Location("Jakarta", "Capital", "Kebayoran Lama Utara");

        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId() + 1, "John", "john@gmail.com", "085155343144", location));

        Calendar calendar = new GregorianCalendar(2020, 04, 02);

        //DatabaseFood.addFood(new Food(1, "Caramel Macchiato", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 45000, FoodCategory.COFFEE));
        //DatabaseFood.addFood(new Food(2, "Asian Dolce Latte", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 25000, FoodCategory.COFFEE));
        //DatabaseFood.addFood(new Food(3, "Ramen", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 75000, FoodCategory.JAPANESE));

        //System.out.println("Daftar Food Category Coffee: ");
        //for (Food food : DatabaseFood.getFoodByCategory(FoodCategory.COFFEE))
        //{
        //    System.out.println(food.getName());
        //}
        //System.out.println(DatabaseFood.getFoodByCategory(FoodCategory.COFFEE));

        // DatabaseCustomer.addCustomer(new Customer(13, "Hosea", "hosea@gmail.com", "AkuWibu345", calendar));
        //DatabaseCustomer.addCustomer(new Customer(45, "Hosea", "hosea@gmail.com", "AkuWibu123", 2020, 04, 02));
        // DatabaseCustomer.addCustomer(new Customer(35, "Rama", "rama@gmail.com", "AkuBukanWibu234"));

        //System.out.println("Daftar Customer: ");
        //for (Customer customer : DatabaseCustomer.getCustomerDatabase())
        //{
        //   System.out.println(customer.getName());
        //}
        //System.out.println(DatabaseCustomer.getCustomerDatabase());

        // DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId() + 1, "pastipas", 50000, 100000, true));
        //  DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId() + 1, "pastipas", 20000, 200000, true));

        //  System.out.println("\nDaftar Promo: ");
        //  for (Promo promo : DatabasePromo.getPromoDatabase())
        //  {
        //      System.out.println(promo.getCode());
        //  }

        //  ArrayList<Food> foods1 = new ArrayList<>();
        //foods1.add(DatabaseFood.getFoodById(3));
        //ArrayList<Food> foods2 = new ArrayList<>();
        //  foods2.add(DatabaseFood.getFoodById(1));
        //foods2.add(DatabaseFood.getFoodById(2));

        //DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId() + 1, foods2, DatabaseCustomer.getCustomerById(1), 2000));
        //for (Invoice invoice : DatabaseInvoice.getInvoiceByCustomer(1))
        // {
        //     invoice.setTotalPrice();
        //  }
        //  DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1, foods1, DatabaseCustomer.getCustomerById(1), DatabasePromo.getPromoById(DatabasePromo.getLastId())));
        // for (Invoice invoice : DatabaseInvoice.getInvoiceByCustomer(1))
        // {
        //     invoice.setTotalPrice();
        // }

        //System.out.println("\nDaftar Invoice: ");
        // for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        // {
        //     System.out.println(invoice.toString() + "\n");
        // }

        // for (Invoice invoice : DatabaseInvoice.getInvoiceByCustomer(1))
        // {
        //    invoice.setInvoiceStatus(InvoiceStatus.FINISHED);
        // }

        // DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1, foods1, DatabaseCustomer.getCustomerById(2), DatabasePromo.getPromoById(DatabasePromo.getLastId())));

        //Customer Email
        try {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Rama", "rama@ui.ac.id", "Password2123"));
        } catch (EmailAlreadyExistException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Hizkia", "hizkia@gmail.com", "wkwkwkwk123"));
        } catch (EmailAlreadyExistException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Tristan", "tristan@gmail.com", "bukanwibU11", calendar));
        } catch (EmailAlreadyExistException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Tristan", "tristan@gmail.com", "bukanwibU11", 2020, 4, 9));
        } catch (EmailAlreadyExistException e) {
            System.out.println(e.getMessage());
        }

        //Promo Exist
        try {
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId() + 1, "palugada45", 5000, 20000, false));
        } catch (PromoCodeAlreadyExistException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId() + 1, "palugada45", 5000, 20000, true));
        } catch (PromoCodeAlreadyExistException e) {
            System.out.println(e.getMessage());
        }

        //Customer ID
        try {
            DatabaseCustomer.removeCustomer(4);
        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //Food ID
        try {
            DatabaseFood.removeFood(4);
        } catch (FoodNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //Seller ID
        try {
            DatabaseSeller.getSellerById(3);
        } catch (SellerNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //Promo ID
        try {
            DatabasePromo.removePromo(3);
        } catch (PromoNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //Add Food
        try {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Caramel Macchiato", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 28000, FoodCategory.COFFEE));
        } catch (SellerNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Asian Dolce Latte", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 25000, FoodCategory.COFFEE));
        } catch (SellerNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Ramen", DatabaseSeller.getSellerById(DatabaseSeller.getLastId()), 27000, FoodCategory.JAPANESE));
        } catch (SellerNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //Yang masuk ke database
        System.out.println("\n");
        System.out.println("==========YANG MASUK DATABASE CUSTOMER===========");
        for (Customer customers : DatabaseCustomer.getCustomerDatabase())
        {
            System.out.println(customers);
        }

        System.out.println("===========YANG MASUK DATABASE PROMO===========");
        for (Promo promo : DatabasePromo.getPromoDatabase())
        {
            System.out.println(promo);
        }

        System.out.println("===========YANG MASUK DATABASE FOOD===========");
        for (Food food : DatabaseFood.getFoodDatabase())
        {
            System.out.println(food);
        }

        //Threading
        //Add ArrayList Food
        ArrayList<Food> newFood = new ArrayList<Food>();
        ArrayList<Food> newFood2 = new ArrayList<Food>();
        ArrayList<Food> newFood3 = new ArrayList<Food>();

        try {
            newFood.add(DatabaseFood.getFoodById(1));
        }
        catch(FoodNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            newFood2.add(DatabaseFood.getFoodById(1));
        }
        catch (FoodNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            newFood2.add(DatabaseFood.getFoodById(2));
        }
        catch (FoodNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            newFood3.add(DatabaseFood.getFoodById(3));
        }
        catch (FoodNotFoundException e){
            System.out.println(e.getMessage());
        }

        //Add Invoice
        try {
            DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId() + 1, newFood, DatabaseCustomer.getCustomerById(1), 5000));
        }
        catch(CustomerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId() + 1, newFood2, DatabaseCustomer.getCustomerById(2), 6000));
        }
        catch(CustomerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            DatabaseInvoice.addInvoice(new CashInvoice(DatabaseInvoice.getLastId() + 1, newFood3, DatabaseCustomer.getCustomerById(3), 7000));
        }
        catch(CustomerNotFoundException e){
            System.out.println(e.getMessage());
        }

        //Kalkulasi Invoice
        for (Invoice invoice : DatabaseInvoice.getInvoiceDatabase())
        {
            Thread calculate = new Thread(new PriceCalculator(invoice));
            calculate.start();
        }
    }
}