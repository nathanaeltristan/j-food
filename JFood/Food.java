/**
 * Class Food berisi id, nama, harga, dan kategori dari Food dan nama seller.
 *
 *
 * @author  nathanaeltristan
 * @version 20/02/2020
 */

public class Food
{
    /* Bagian ini adalah bagian deklarasi variabel. */
    private int id;             //id dari makanan
    private String name;        //nama makanan
    private Seller seller;      //nama penjual makanan
    private int price;          //harga dari makanan
    private String category;    //kategori dari makanan
    
    
    /* Bagian ini adalah constructor dari class Food */
    /**
     * @param id        
     * @param name      
     * @param seller   
     * @param price
     * @param category  
     */
    public Food(int id, String name, Seller seller, int price, String category)
    {
        this.id = id;
        this.name = name;
        this.seller = seller;
        this.price = price;
        this.category = category;
    }

    
    // ini adalah getter (accessor).
    /**
     * Method yang digunakan untuk mengambil id dari makanan.
     * @return id
     */
    public int getId()
    {    
        return id;
    }
    
    /**
     * Method yang digunakan untuk mengambil nama dari makanan.
     * @return name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Method yang digunakan untuk mengambil data parameter dari penjual (seller).
     * @return seller
     */
    public Seller getSeller()
    {
        return seller;
    }
    
    /**
     * Method yang digunakan untuk mengambil harga dari makanan.
     * @return price
     */
    public int getPrice()
    {
        return price;
    }
    
    /**
     * Method yang digunakan untuk mengambil category dari makanan.
     * @return category
     */
    public String getCategory()
    {
        return category;
    }
    
    // ini adalah setter (mutator).
    /**
     * Menetapkan nilai id awal dari makanan.
     * @param id            merupakan id dari makanan
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    
    /**
     * Menetapkan string nama awal dari makanan.
     * @param name          merupakan nama dari makanan
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Menetapkan data awal dari penjual (seller).
     * @param seller        merupakan data penjual
     */
    public void setSeller(Seller seller)
    {    
        this.seller = seller;
    }
    
    /**
     * Menetapkan nilai harga awal dari makanan.
     * @param price         merupakan harga dari makanan
     */
    public void setPrice(int price)
    {
        this.price = price;
    }
    
    /**
     * Menetapkan string kategori awal dari makanan.
     * @param category      merupakan kategori dari makanan
     */
    public void setCategory(String category)
    {
        this.category = category;
    }
    
    /**
     * Bagian ini adalah bagian untuk print variabel yang ada di class Food.     
     */
    public void printData()
    {
        System.out.println(name);       //yang diprint adalah nama dari makanan
    }
}