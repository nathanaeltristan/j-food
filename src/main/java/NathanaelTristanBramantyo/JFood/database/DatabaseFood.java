package NathanaelTristanBramantyo.JFood.database;
import NathanaelTristanBramantyo.JFood.Food;
import NathanaelTristanBramantyo.JFood.FoodCategory;
import NathanaelTristanBramantyo.JFood.exception.FoodNotFoundException;

import java.util.ArrayList;

/**
 * Class DatabaseFood adalah .
 *
 *
 * @author  nathanaeltristan
 * @version 27/02/2020
 */

public class DatabaseFood
{
    private static ArrayList<Food> FOOD_DATABASE = new ArrayList<Food>();
    private static int lastId = 0;

    /**
     * this method is getter for every food in food's database
     * @return ArrayList<Food> is the array list of every food in the food's database
     */
    public static ArrayList<Food> getFoodDatabase()
    {
        return FOOD_DATABASE;
    }

    /**
     * this method is to get the id of the last food added to food's database
     * @return an integer of the last food's id
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * this method is to get some food by specifying it's id
     * @param id is the food's id for the expected food object this method returns
     * @return a Food class object in respect of the id specified in the parameter
     * @throws FoodNotFoundException to check whether the food that goes by the id in the parameter exist or not
     */
    public static Food getFoodById(int id) throws FoodNotFoundException
    {
        for (Food foods : FOOD_DATABASE)
        {
            if (foods.getId() == id)
            {
                return foods;
            }
        }
        throw new FoodNotFoundException(id) ;
    }

    /**
     * this method is to get every food under one seller
     * @param sellerId is the seller's id for the expected array list food that the seller sells
     * @return an ArrayList of Food object that the seller sells
     */
    public static ArrayList<Food> getFoodBySeller(int sellerId)
    {
        ArrayList<Food> foodList = new ArrayList<Food>();
        for (Food foods : FOOD_DATABASE)
        {
            if(foods.getSeller().getId() == sellerId)
            {
                foodList.add(foods);
            }
            else
            {
                foodList = null;
            }
        }
        return foodList;
    }

    /**
     * this method is to get every food under the specified food category from FoodCategory enum
     * @param foodCategory is the expected category for every food's array list returned
     * @return an ArrayList<Food> array list of food that have the category field same as foodCategory specified in the parameter
     */
    public static ArrayList<Food> getFoodByCategory(FoodCategory foodCategory)
    {
        ArrayList<Food> foodList = new ArrayList<Food>();
        for (Food foods : FOOD_DATABASE)
        {
            if(foods.getCategory().equals(foodCategory))
            {
                foodList.add(foods);
            }
        }
        return foodList;
    }

    /**
     * this method is to add food to the array list in the DatabaseFood that hold every food registered
     * @param food is a Food class object that wanted to be added to the DatabaseFood class array list
     * @return a boolean, true if the food is successfully added
     */
    public static boolean addFood(Food food)
    {
        FOOD_DATABASE.add(food);
        lastId = food.getId();
        return true;
    }

    /**
     * this method is to remove some food from database array list by specifying it's id
     * @param id is the food's id for the expected food object this method returns
     * @return a Food class object in respect of the id specified in the parameter
     * @throws FoodNotFoundException to check whether the food that goes by the id in the parameter exist or not
     */
    public static boolean removeFood(int id) throws FoodNotFoundException
    {
        for(Food foods : FOOD_DATABASE)
        {
            if(foods.getId() == id)
            {
                FOOD_DATABASE.remove(foods);
                return true;
            }
        }
        throw new FoodNotFoundException(id);
    }
}