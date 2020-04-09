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

    private static final ArrayList<Food> FOOD_DATABASE = new ArrayList<Food>();
    private static int lastId = 0;

    public static ArrayList<Food> getFoodDatabase()
    {

        return FOOD_DATABASE;

    }

    public static int getLastId()
    {

        return lastId;

    }

    public static Food getFoodById(int id) throws FoodNotFoundException
    {
        for(Food food : FOOD_DATABASE)
        {
            if (food.getId() == id)
            {
                return food;
            }
        }
        throw new FoodNotFoundException(id);
    }

    public static ArrayList<Food> getFoodBySeller(int sellerId)
    {
        ArrayList<Food> foodList = new ArrayList<Food>();
        for (Food food : FOOD_DATABASE)
        {
            if (food.getSeller().getId() == sellerId)
            {
                foodList.add(food);
            }
        }
        return foodList;
    }

    public static ArrayList<Food> getFoodByCategory(FoodCategory foodCategory)
    {
        ArrayList<Food> foodList = new ArrayList<Food>();
        for(Food food : FOOD_DATABASE)
        {
            if (food.getCategory().equals(foodCategory))
            {
                foodList.add(food);
            }
        }
        return foodList;
    }

    public static boolean addFood(Food food)
    {

        FOOD_DATABASE.add(food);
        lastId = food.getId();
        return true;

    }

    public static boolean removeFood(int id) throws FoodNotFoundException
    {

        for(Food food : FOOD_DATABASE)
        {
            if (food.getId() == id)
            {
                FOOD_DATABASE.remove(food);
                return true;
            }
        }
        throw new FoodNotFoundException(id);
    }
    /**
     * getListFood() is used to return the current list of food
     *
     * @return    listFood that contains some String
     */


}