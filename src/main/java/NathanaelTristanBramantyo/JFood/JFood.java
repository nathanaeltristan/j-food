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

    public static void main(String[] args)
    {
        Location location1 = new Location("Jakarta", "Ibukota", "Jakarta Selatan");
        Location location2 = new Location("Jawa Barat", "Universitas Indonesia", "Depok");
        Location location3 = new Location("DI Yogyakarta", "Kampung Halaman", "Ponjong");

        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Nathanael", "nathanael@gmail.com", "081380744170", location1));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Tristan", "tristan@gmail.com", "081380744170", location2));
        DatabaseSeller.addSeller(new Seller(DatabaseSeller.getLastId()+1, "Bramantyo", "bramantyo@gmail.com", "081380744170", location3));

        try
        {
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Bakmie Bangka", DatabaseSeller.getSellerById(1), 45000, FoodCategory.NOODLES));
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Asian Dolce Latte", DatabaseSeller.getSellerById(2), 50000, FoodCategory.COFFEE));
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Croissant", DatabaseSeller.getSellerById(3), 35000, FoodCategory.BAKERY));
            DatabaseFood.addFood(new Food(DatabaseFood.getLastId() + 1, "Ramen", DatabaseSeller.getSellerById(1), 40000, FoodCategory.JAPANESE));
        }
        catch(SellerNotFoundException s)
        {
            s.getMessage();
        }

        SpringApplication.run(JFood.class, args);
    }

}