package NathanaelTristanBramantyo.JFood;
/**
 * Write a description of class Promo here.
 *
 * @author nathanaeltristan
 * @version 19/03/2020
 */

public class Promo
{
    // instance variables - replace the example below with your own
    private int id;
    private String code;
    private int discount;
    private int minPrice;
    private boolean active;


    /**
     * @param   id is the id of the promo
     * @param   code is the promo code
     * @param   discount is how much the promo will discount your purchase
     * @param   minPrice is the minimum purchase for the promo
     * @param   active is to see if the promo is active or not
     */
    public Promo(int id, String code, int discount, int minPrice, boolean active)
    {
        this.id = id;
        this.code = code;
        this.discount = discount;
        this.minPrice = minPrice;
        this.active = active;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     */
    public int getId()
    {
        return id;
    }

    public String getCode()
    {
        return code;
    }

    public int getDiscount()
    {
        return discount;
    }

    public int getMinPrice()
    {
        return minPrice;
    }

    public boolean getActive()
    {
        return active;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public void setDiscount(int discount)
    {
        this.discount = discount;
    }

    public void setMinPrice(int minPrice)
    {
        this.minPrice = minPrice;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public String toString()
    {
        return "Id = " + getId() + "\nCode = " + getCode() +
                "\nDiscount = " + getDiscount() + "\nMinPrice = " + getMinPrice() +
                "\nActiveStatus = " + getActive();
    }




}