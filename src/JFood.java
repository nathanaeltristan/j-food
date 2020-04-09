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


public class JFood
{
    public static void main(String[] args_)
    {
        //Location location = new Location("Jakarta", "Capital", "Kebayoran Lama Utara");

        //DatabaseSeller.addSeller(new Seller(29, "John", "john@gmail.com", "085155343144", location));

        //Calendar calendar = new GregorianCalendar(2020,04,02);

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
            invoice.setInvoiceStatus(InvoiceStatus.FINISHED);
       // }

       // DatabaseInvoice.addInvoice(new CashlessInvoice(DatabaseInvoice.getLastId() + 1, foods1, DatabaseCustomer.getCustomerById(2), DatabasePromo.getPromoById(DatabasePromo.getLastId())));
        try {

            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId() + 1, "12345", 10000, 5000, false));

        }
        catch(PromoCodeAlreadyExistsException | PromoCodeAlreadyExistException error){

            System.out.println(error.getMessage());

        }

        try {

            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId() + 1, "12345", 7000, 5000, true));

        }
        catch(PromoCodeAlreadyExistsException | PromoCodeAlreadyExistException error){

            System.out.println(error.getMessage());

        }



        Location baselocation = new Location("Jakarta Selatan", "Capital", "Kebayoran Lama Utara");

        

        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId() + 1, "Tristan", "tristan@gmail.com", "081380744170", location));

        try {

            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Gilli", "gilbert@gmail.com", "1234"));

        }
        catch(EmailAlreadyExistsException | EmailAlreadyExistException error){

            System.out.println(error.getMessage());

        }

        try {

            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Gilli", "gilbert@gmail.com", "Abcd1234"));
        }
        catch(EmailAlreadyExistsException | EmailAlreadyExistException error){

            System.out.println(error.getMessage());

        }

        try {

            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Frenzel", "frenzel@gmail.com", "gilbert"));

        }
        catch(EmailAlreadyExistsException | EmailAlreadyExistException error){

            System.out.println(error.getMessage());

        }

        try {

            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Gilbert", "gilli@gmail.com", "ulala"));

        }
        catch(EmailAlreadyExistsException | EmailAlreadyExistException error){

            System.out.println(error.getMessage());

        }

        //System.out.println(DatabaseCustomer.getCustomerDatabase());

        try {

            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Paket Sehat Bahari 1", DatabaseSeller.getSellerByID(1), 15000, FoodCategory.Beverages));

        }
        catch(SellerNotFoundException error){

            System.out.println(error.getMessage());

        }

        try {

            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Paket Sehat Bahari 2", DatabaseSeller.getSellerByID(1), 3000, FoodCategory.Beverages));

        }
        catch(SellerNotFoundException error){

            System.out.println(error.getMessage());

        }

        try {

            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Paket Sehat Bahari 3", DatabaseSeller.getSellerByID(1), 5000, FoodCategory.Japanese));

        }
        catch(SellerNotFoundException error){

            System.out.println(error.getMessage());

        }

        ////////////////////////////////////////////////////////////////////////////////////////
        try {

            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId() + 1, "Gilli", "gilbert@gmail.com", "Abcd1234"));

        }
        catch(EmailAlreadyExistsException error){

            System.out.println(error.getMessage());

        }

        try {

            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId() + 1, "12345", 7000, 5000, true));

        }
        catch(PromoCodeAlreadyExistsException error){

            System.out.println(error.getMessage());

        }

        try {

            DatabasePromo.removePromo(3);

        }
        catch(PromoNotFoundException error){

            System.out.println(error.getMessage());

        }

        try {

            DatabaseSeller.getSellerByID(2);

        }
        catch(SellerNotFoundException error){

            System.out.println(error.getMessage());

        }

        try {

            DatabaseFood.getFoodByID(5);

        }
        catch(FoodNotFoundException error){

            System.out.println(error.getMessage());

        }

        try {

            DatabaseCustomer.getCustomerByID(4);

        }
        catch(CustomerNotFoundException error){

            System.out.println(error.getMessage());

        }

        System.out.println("=============================YANG MASUK DATABASE PROMO============================");
        System.out.println(DatabasePromo.getPromoDatabase());
        System.out.println("=============================YANG MASUK DATABASE SELLER============================");
        System.out.println(DatabaseSeller.getSellerDatabase());
        System.out.println("=============================YANG MASUK DATABASE FOOD============================");
        System.out.println(DatabaseFood.getFoodDatabase());
        System.out.println("=============================YANG MASUK DATABASE CUSTOMER============================");
        System.out.println(DatabaseCustomer.getCustomerDatabase());

        ArrayList<Food> pertama = new ArrayList<Food>();
        try {

            pertama.add(DatabaseFood.getFoodByID(1));

        }
        catch(FoodNotFoundException error){

            System.out.println(error.getMessage());

        }

        try {

            DatabaseInvoice.addInvoice(new CashInvoice (DatabaseInvoice.getLastId() + 1, pertama, DatabaseCustomer.getCustomerByID(1)));

        }
        catch(CustomerNotFoundException error){

            System.out.println(error.getMessage());

        }

        try {

            DatabaseInvoice.addInvoice(new CashInvoice (DatabaseInvoice.getLastId() + 1, pertama, DatabaseCustomer.getCustomerByID(2)));

        }
        catch(CustomerNotFoundException error){

            System.out.println(error.getMessage());

        }

        try {

            DatabaseInvoice.addInvoice(new CashInvoice (DatabaseInvoice.getLastId() + 1, pertama, DatabaseCustomer.getCustomerByID(3)));

        }
        catch(CustomerNotFoundException error){

            System.out.println(error.getMessage());

        }

        for(Invoice invoice : DatabaseInvoice.getInvoiceDatabase()){

            Thread object = new Thread(new PriceCalculator(invoice));
            object.start();

        }
    }
}