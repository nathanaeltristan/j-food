package NathanaelTristanBramantyo.JFood.controller;

import NathanaelTristanBramantyo.JFood.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RequestMapping("/food")
@CrossOrigin(origins = " ", allowedHeaders = "*")
@RestController
public class FoodController
{

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Food> getAllFood()
    {
        return DatabaseFood.getFoodDatabase();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Food getFoodById(@PathVariable int id)
    {
        Food food = null;
        try
        {
            food = DatabaseFood.getFoodById(id);
        }
        catch (FoodNotFoundException e)
        {
            e.getMessage();
            return null;
        }
        return food;
    }

    @RequestMapping(value = "/seller/{sellerId}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodBySeller(@PathVariable int sellerId) {
        ArrayList<Food> food = null;
        try
        {
            food = DatabaseFood.getFoodBySeller(sellerId);
        }
        catch (Exception e)
        {
            e.getMessage();
            return null;
        }
        return food;
    }

    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodByCategory(@PathVariable FoodCategory category)
    {
        ArrayList<Food> food = null;
        try
        {
            food = DatabaseFood.getFoodByCategory(category);
        }
        catch (Exception e)
        {
            e.getMessage();
            return null;
        }
        return food;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Food addFood(@RequestParam(value="name") String name,
                        @RequestParam(value="price") int price,
                        @RequestParam(value="category") FoodCategory category,
                        @RequestParam(value="sellerId") int sellerId)throws SellerNotFoundException
    {
        Food food = new Food(DatabaseFood.getLastId() + 1, name, DatabaseSeller.getSellerById(sellerId), price, category);
        try
        {
            DatabaseFood.addFood(food);
        }
        catch (Exception e)
        {
            e.getMessage();
            return null;
        }
        return food;
    }

}
