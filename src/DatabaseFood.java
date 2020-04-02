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
    /* Bagian ini adalah bagian deklarasi variabel. */
    private static String listFood;
    private static ArrayList<Food> FOOD_DATABASE;
    private static int lastId;

    
    /* Bagian ini adalah constructor dari class DatabaseFood */
    /**
     * @param listFood
     */
    
    public static Food getFoodById(int id)
    {
        for (Food foods : FOOD_DATABASE)
        {
            if(foods.getId() == id)
            {
                return foods;
            }
        }
        return null;
    }

    public static ArrayList<Food> getFoodBySeller(int sellerId)
    {
        ArrayList<Food> list = new ArrayList<>();
        for (Food food : FOOD_DATABASE)
        {
            if(food.getSeller().getId() == sellerId)
            {
                list.add(food);
            }
        }
        return list;
    }

    public static ArrayList<Food> getFoodDatabase()
    {
        return FOOD_DATABASE;
    }

    public int getLastId()
    {
        return lastId;
    }

    public static ArrayList<Food> getFoodByCategory(FoodCategory category)
    {
        ArrayList<Food> list = new ArrayList<>();
        for (Food food : FOOD_DATABASE)
        {
            if(food.getCategory() == category)
            {
                list.add(food);
            }
        }
        return list;
    }
    
    /* Bagian ini adalah bagian method dari class DatabaseFood. */
    /**
     * Boolean hanya memiliki dua value datatype, yes atau no, on atau off, true atau false.
     * @param food
     */
    public static boolean addFood(Food food)
    {
        FOOD_DATABASE.add(food);
        lastId = food.getId();
        return true;
    }
    
    /**
     * Boolean hanya memiliki dua value datatype, yes atau no, on atau off, true atau false.
     * @param food
     */
    public static boolean removeFood(Food food)
    {
        for(Food food : FOOD_DATABASE)
        {
            if (food.getId() == id)
            {
                FOOD_DATABASE.remove(food);
                return true;
            }
        }
        return false;
    }
}