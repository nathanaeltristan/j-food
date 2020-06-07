package NathanaelTristanBramantyo.JFood;
/**
 * Class Location berisi nama dan deskripsi provinsi,
 * dan nama kota dari provinsi.
 *
 *
 * @author  nathanaeltristan
 * @version 27/02/2020
 */

public class Location
{
    private String province;
    private String city;
    private String description;

    /**
     * Constructor for initiate the location
     * @param province is the the province name
     * @param city is the city name
     * @param description is the desc. of the city
     */
    public Location(String province, String city, String description)
    {
        this.province = province;
        this.city = city;
        this.description = description;
    }

    /**
     * This method is the getter of province
     * @return name of the province
     */
    public String getProvince()
    {
        return province;
    }

    /**
     * This method is the getter of city name
     * @return name of the city
     */
    public String getCity()
    {
        return city;
    }

    /**
     * this is the getter of description
     * @return the description of the city
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * this is the setter of province
     * @param province is holding the name of the province
     */
    public void setProvince(String province)
    {
        this.province = province;
    }

    /**
     * this is the setter of city
     * @param city is holding the name of the city
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * this is the setter of description
     * @param description is holding the description of the city
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * this is to print any data in this class
     */
    public String toString()
    {
        return "Province = " + getProvince() + "\nCity = " + getCity() +
                "\nDescription = " + getDescription();
    }

}