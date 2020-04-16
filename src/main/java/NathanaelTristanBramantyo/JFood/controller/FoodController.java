package NathanaelTristanBramantyo.JFood.controller;

import NathanaelTristanBramantyo.JFood.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RequestMapping("/food")
@RestController
public class FoodController
{
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Food> getAllFood()
    {
        return DatabaseFood.getFoodDatabase();
    }

    @RequestMapping(value = "/food/{id}", method = RequestMethod.GET)
    public Food getFoodById(int id)
    {
        Food food = null;
        try
        {
            food = DatabaseFood.getFoodById(id);
        }
        catch (FoodNotFoundException nf)
        {
            System.out.println(nf.getMessage());
        }
        return food;
    }

    @RequestMapping("/food/seller/{sellerId}")
    public ArrayList<Food> getFoodBySeller(int sellerId) throws SellerNotFoundException
    {
        ArrayList<Food> food = null;
        food = DatabaseFood.getFoodBySeller(sellerId);
        return food;
    }

    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public ArrayList<Food> getFoodByCategory(@PathVariable FoodCategory category)
    {
        ArrayList<Food> food = null;
        food = DatabaseFood.getFoodByCategory(category);
        return food;
    }

    @RequestMapping(value = "/food}", method = RequestMethod.POST)
    public Food addFood(@RequestParam(value = "name") String name,
                        @RequestParam(value = "price") int price,
                        @RequestParam(value = "sellerId") int sellerId,
                        @RequestParam(value = "category") FoodCategory category)
    {
        Food food = null;
        try
        {
            food = new Food(DatabaseFood.getLastId()+1, name, DatabaseSeller.getSellerById(sellerId), price, category);
        }
        catch (SellerNotFoundException nf)
        {
            nf.getMessage();
            return null;
        }
        DatabaseFood.addFood(food);
        return food;
    }
}
