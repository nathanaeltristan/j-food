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
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Leonardus Wijaya", "leo@ui.ac.id", "082345678912", location1));

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

        SpringApplication.run(JFood.class, args);
    }

}