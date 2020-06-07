package NathanaelTristanBramantyo.JFood;
/**
 * Write a description of class Promo here.
 *
 * @author nathanaeltristan
 * @version 19/03/2020
 */
public class Promo
{
    private int id;
    private String code;
    private int discount;
    private int minPrice;
    private boolean active;

    /**
     * Constructor for objects of class Promo
     * @param id is to hold the value of promo's id
     * @param code is to hold promo's code
     * @param discount to hold the value of promo's discount
     * @param minPrice to hold the minimum price of the food for this promo to be valid
     * @param active is to hold boolean value, if true then the promo is active, otherwise the promo is not valid/expired
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
     * this is the getter of promo's id
     * @return id of the promo
     */
    public int getId()
    {
        return id;
    }

    /**
     * this is the getter of promo's code
     * @return code of the promo
     */
    public String getCode()
    {
        return code;
    }

    /**
     * this is the getter of promo's discount value
     * @return integer value of the promo's discount
     */
    public int getDiscount()
    {
        return discount;
    }

    /**
     * this is the getter of promo's code
     * @return code of the promo
     */
    public int getMinPrice()
    {
        return minPrice;
    }

    /**
     * this is the getter of promo's active status
     * @return boolean true if active otherwise flase
     */
    public boolean getActive()
    {
        return active;
    }

    /**
     * this is the setter of promo's id
     * @param id to set the promo's id
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * this is the setter of promo's code
     * @param code to set the promo's code
     */
    public void setCode(String code)
    {
        this.code = code;
    }

    /**
     * this is the setter of promo's discount value
     * @param discount to set the promo's discount
     */
    public void setDiscount(int discount)
    {
        this.discount = discount;
    }

    /**
     * this is the setter of the minimum price to use this promo
     * @param minPrice to set the minimum price of this promo
     */
    public void setMinPrice(int minPrice)
    {
        this.minPrice = minPrice;
    }

    /**
     * this is the setter to activate current promo
     * @param active, boolean value, input true to activate the promo
     */
    public void setActive(boolean active)
    {
        this.active = active;
    }

    /**
     * this method is to print any data in Promo class
     */
    public String toString()
    {
        return "Id = " + getId() + "\nCode = " + getCode() +
                "\nDiscount = " + getDiscount() + "\nMinPrice = " + getMinPrice() +
                "\nActiveStatus = " + getActive();
    }




}