package NathanaelTristanBramantyo.JFood;
/**
 * Enumeration class FoodCategory - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum FoodCategory
{
    BEVERAGES("Beverages"),
    COFFEE("Coffee"),
    WESTERN("Western"),
    SNACKS("Snacks"),
    RICE("Rice"),
    NOODLES("Noodles"),
    BAKERY("Bakery"),
    JAPANESE("Japanese");

    private String status;

    FoodCategory(String status)
    {
        this.status = status;
    }

    public String toString()
    {
        return status;
    }
}