package NathanaelTristanBramantyo.JFood;
/**
 * Write a description of class JFood here.
 *
 * @author nathanaeltristan
 * @version 20/02/2020
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JFood {

    public static void main(String[] args) {

        //LOCATION & SELLER
        Location location1 = new Location("DKI Jakarta", "Jakarta Selatan", "Capital");
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Leonardus Wijaya", "leo@ui.ac.id", "082345678912", location1));

        //FOOD
        try{
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Spaghetti Bolognese", DatabaseSeller.getSellerById(1), 25000, FoodCategory.WESTERN));
        }
        catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId()+1,"Coca Cola", DatabaseSeller.getSellerById(1), 20000, FoodCategory.BEVERAGES));
        }
        catch (SellerNotFoundException e){
            System.out.println(e.getMessage());
        }

        SpringApplication.run(JFood.class, args);
    }

}