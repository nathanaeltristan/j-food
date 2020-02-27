
/**
 * Write a description of class Location here.
 *
 * @nathanaeltristan
 * @27022020
 */
public class Location
{
    // instance variables - replace the example below with your own
    private String province;
    private String description;
    private String city;

    
    public Location(String province, String description, String city)
    {
        this.province = province;
        this.description = description;
        this.city = city;
    }

    
    public String getProvince()
    {
        return province;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public void setProvince(String province)
    {
        this.province = province;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public void setCity(String city)
    {
        this.city = city;
    }
    
    public void printData()
    {
        System.out.println(province);
    }
}
