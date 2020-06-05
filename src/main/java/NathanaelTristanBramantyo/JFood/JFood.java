package NathanaelTristanBramantyo.JFood;
/**
 * Write a description of class JFood here.
 *
 * @author nathanaeltristan
 * @version 20/02/2020
 */

import NathanaelTristanBramantyo.JFood.database.DatabaseCustomer;
import NathanaelTristanBramantyo.JFood.database.DatabaseFood;
import NathanaelTristanBramantyo.JFood.database.DatabasePromo;
import NathanaelTristanBramantyo.JFood.database.DatabaseSeller;
import NathanaelTristanBramantyo.JFood.exception.EmailAlreadyExistException;
import NathanaelTristanBramantyo.JFood.exception.PromoCodeAlreadyExistException;
import NathanaelTristanBramantyo.JFood.exception.SellerNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.GregorianCalendar;

@SpringBootApplication
public class JFood {

    public static void main(String[] args) {

        //LOCATION
        Location location1 = new Location("DKI Jakarta", "Capital", "Jakarta Selatan");

        //SELLER
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Hosea Yoarana", "hosea@ui.ac.id", "081234567891", location1));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Leonardus Wijaya", "leo@ui.ac.id", "082345678912", location1));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Michael Ariyanto", "michael@ui.ac.id", "083456789123", location1));

        //FOOD
        try{
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Spaghetti Bolognese", DatabaseSeller.getSellerById(1), 25000, FoodCategory.WESTERN));
        }
        catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"French Fries", DatabaseSeller.getSellerById(1), 20000, FoodCategory.SNACKS));
        }
        catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Fried Rice", DatabaseSeller.getSellerById(2), 18000, FoodCategory.RICE));
        }
        catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Ramen", DatabaseSeller.getSellerById(2), 15000, FoodCategory.NOODLES));
        }
        catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Black Bean Bun", DatabaseSeller.getSellerById(2), 10000, FoodCategory.BAKERY));
        }
        catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Takoyaki", DatabaseSeller.getSellerById(2), 35000, FoodCategory.JAPANESE));
        }
        catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Americano", DatabaseSeller.getSellerById(3), 45000, FoodCategory.COFFEE));
        }
        catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Orange Juice", DatabaseSeller.getSellerById(3), 48000, FoodCategory.BEVERAGES));
        }
        catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }



        //Customer
        Calendar calendar = new GregorianCalendar(2020, 6, 1);
        try {
            DatabaseCustomer.addCustomer(new Customer(DatabaseCustomer.getLastId()+1, "Tristan", "tristan@ui.ac.id", "akubukanwibu123"));
        }
        catch (EmailAlreadyExistException e){
            System.out.println(e.getMessage());
        }

        //Promo
        try {
            DatabasePromo.addPromo(new Promo(DatabasePromo.getLastId()+1, "palugada", 5000, 10000, true));
        }
        catch (PromoCodeAlreadyExistException e){
            System.out.println(e.getMessage());
        }

        SpringApplication.run(JFood.class, args);
    }

}