/**
 * Class Customer berisi id, nama, email, password, dan tanggal join dari customer.
 *
 *
 * @author  nathanaeltristan
 * @version 20/02/2020
 */

public class Customer
{
    /* Bagian ini adalah bagian deklarasi variabel. */
    private int id;             //id dari customer
    private String name;        //nama dari customer
    private String email;       //email dari customer
    private String password;    //password dari customer untuk mengakses    
    private String joinDate;    //kapan customer mengakses pertama kali

    
    /* Bagian ini adalah constructor dari class Customer */
    /**
     * @param id
     * @param name
     * @param email
     * @param password
     * @param joinDate
     */
    public Customer(int id, String name, String email, String password, String joinDate)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
    }
    
    
    /* Bagian ini adalah bagian method dari class Customer. */
    // ini adalah getter.
    /**
     * Mengambil dan menyimpan id dari customer.
     * @return id
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Mengambil dan menyimpan nama dari customer.
     * @return name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Mengambil dan menyimpan email dari customer.
     * @return email
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * Mengambil dan menyimpan password dari customer.
     * @return password
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * Mengambil dan menyimpan joinDate dari customer.
     * @return joinDate
     */
    public String getJoinDate()
    {
        return joinDate;
    }
    
    // ini adalah setter.
    /**
     * Menetapkan nilai id awal dari customer.
     * @param id
     */
    public void setId (int id)
    {
        this.id = id;
    }
    
    /**
     * Menetapkan string nama awal dari customer.
     * @param name
     */
    public void setName (String name)
    {
        this.name = name;
    }
    
    /**
     * Menetapkan string email awal dari customer.
     * @param email
     */
    public void setEmail (String email)
    {
        this.email = email;
    }
    
    /**
     * Menetapkan string password awal dari customer.
     * @param password
     */
    public void setPassword (String password)
    {
        this.password = password;
    }
    
    /**
     * Menetapkan string joinDate awal dari customer.
     * @param joinDate
     */
    public void setJoinDate (String joinDate)
    {
        this.joinDate = joinDate;
    }
    
    /**
     * Bagian ini adalah bagian untuk print variabel yang ada di class Customer.
     * @param printData
     */
    public void printData()
    {
        System.out.println(name);       //yang diprint adalah nama customer yang membeli makanan
    }
}