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
    /* Bagian ini adalah bagian deklarasi variabel. */
    private int id;                 //id dari seller
    private String name;            //nama dari seller
    private String email;           //email dari seller
    private String phoneNumber;     //nomor telepon dari seller
    private Location location;      //lokasi seller

    
    /* Bagian ini adalah constructor dari class Seller */
    /**
     * @param id
     * @param name
     * @param email
     * @param phoneNumber
     * @param location
     */
    public Seller(int id, String name, String email, String phoneNumber, Location location)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }

    
    /* Bagian ini adalah bagian method dari class Seller. */
    /**
     * Method yang digunakan untuk mengambil id dari seller.
     * @return id
     */
    // ini adalah getter.
    public int getId()
    {
        return id;
    }
    
    /**
     * Method yang digunakan untuk mengambil nama dari seller.
     * @return name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Method yang digunakan untuk mengambil email dari seller.
     * @return email
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * Method yang digunakan untuk mengambil nomor telepon dari seller.
     * @return phoneNumber
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    /**
     * Mengambil data parameter dari lokasi seller.
     * @return location
     */
    public Location getLocation()
    {
        return location;
    }
    
    // ini adalah setter.
    /**
     * Menetapkan nilai id awal dari seller.
     * @param id        merupakan id dari penjual
     */
    public void setId (int id)
    {
        this.id = id;
    }
    
    /**
     * Menetapkan string nama awal dari seller.
     * @param name      merupakan nama dari penjual
     */
    public void setName (String name)
    {
        this.name = name;
    }
    
    /**
     * Menetapkan string email awal dari seller.
     * @param email     merupakan email dari penjual
     */
    public void setEmail (String email)
    {
        this.email = email;
    }
    
    /**
     * Menetapkan string nomor telepon awal dari seller.
     * @param phoneNumber   merupakan nomor telepon dari penjual
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * Menetapkan lokasi awal dari seller.
     * @param location     merupakan lokasi dari penjual
     */
    public void setLocation(Location location)
    {
        this.location = location;
    }
    
    /**
     * Bagian ini adalah bagian untuk print variabel yang ada di class Food.
     */
    public String toString()
    {
        return "Id = " + getId() 
        + "Name = " + getName() 
        + "Phone Number = " + getPhoneNumber() 
        + "Location =" + getLocation().getCity();
    }
}