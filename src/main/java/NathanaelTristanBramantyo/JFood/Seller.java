package NathanaelTristanBramantyo.JFood;
/**
 * Class Seller berisi id, nama, email, nomor telepon, dan location dari seller.
 *
 *
 * @author  nathanaeltristan
 * @version 20/02/2020
 */

public class Seller
{
    // instance variables - replace the example below with your own
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private Location location;

    /**
     * constructor for objects class seller
     * @param id is the id of seller
     * @param name is the name of seller
     * @param email is the email of seller
     * @param phoneNumber is phone number of seller
     * @param location is refering to an object of class Location that contain information of the seller
     */
    public Seller(int id, String name, String email, String phoneNumber,Location location)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    /**
     * this is getter of seller's id
     * @return id of the seller
     */
    public int getId()
    {
        return id;
    }

    /**
     * this is the getter of seller's name
     * @return name of the seller
     */
    public String getName()
    {
        return name;
    }

    /**
     * this is the getter of seller's email
     * @return email of the seller
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * this is the getter of seller's phone number
     * @return phone number of the seller
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public Location getLocation()
    {
        return location;
    }

    /**
     * this is setter of seller's id
     * @param id is the id of seller
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * this is setter of seller's name
     * @param name is the name of seller
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * this is the setter of seller's email
     * @param email is the email of seller
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * this is the setter of seller's phone number
     * @param phoneNumber is the phone number of seller
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    /**
     * this is a method to print any data in this class
     */
    public String toString()
    {
        return "Id = " + getId() + "\nNama = " + getName() +
                "\nPhoneNumber = " + getPhoneNumber() + "\nLocation = " + getLocation().getProvince();
    }
}