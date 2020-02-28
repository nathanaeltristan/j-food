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
    /* Bagian ini adalah bagian deklarasi variabel. */
    private String province;        //provinsi lokasi penjualan makanan
    private String description;     //deskripsi dari provinsi lokasi penjualan makanan
    private String city;            //kota lokasi penjualan makanan

    
    /* Bagian ini adalah constructor dari class Location */
    /**
     * @param province
     * @param description
     * @param city
     */
    public Location(String province, String description, String city)
    {
        this.province = province;
        this.description = description;
        this.city = city;
    }

    
    /* Bagian ini adalah bagian method dari class Location. */
    // ini adalah getter.
    /**
     * Method yang digunakan untuk mengambil provinsi dari lokasi.
     * @return province
     */
    public String getProvince()
    {
        return province;
    }
    
    /**
     * Method yang digunakan untuk mengambil deskripsi provinsi dari lokasi.
     * @return description
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Method yang digunakan untuk mengambil kota dari lokasi.
     * @return city
     */
    public String getCity()
    {
        return city;
    }
    
    // ini adalah setter.
    /**
     * Menetapkan string provinsi awal dari lokasi.
     * @param province
     */
    public void setProvince(String province)
    {
        this.province = province;
    }
    
    /**
     * Menetapkan string deskripsi provinsi awal dari lokasi.
     * @param description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    /**
     * Menetapkan string kota awal dari lokasi.
     * @param city
     */
    public void setCity(String city)
    {
        this.city = city;
    }
    
    /**
     * Bagian ini adalah bagian untuk print variabel yang ada di class Location.
     * @param printData
     */
    public void printData()
    {
        System.out.println(province);   //yang diprint adalah provinsi dari lokasi
    }
}