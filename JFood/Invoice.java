/**
 * Class Invoice berisi id dari invoice, id dan total harga dari makanan,
 * tanggal pembelian, dan nama customer.
 *
 *
 * @author  nathanaeltristan
 * @version 20/02/2020
 */

public class Invoice
{
    /* Bagian ini adalah bagian deklarasi variabel. */
    private int id;                 //id dari invoice
    private int idFood;             //id makanan yang dipesan
    private String date;            //tanggal invoice
    private int totalPrice;         //total harga yang ada di invoice
    private Customer customer;      //nama customer yang membeli makanan
    private PaymentType paymentType;
    private InvoiceStatus status;

    
    /* Bagian ini adalah constructor dari class Invoice */
    /**
     * @param id            
     * @param idFood        
     * @param date          
     * @param totalPrice    
     * @param customer      
     */
    public Invoice(int id, int idFood, String date, int totalPrice, Customer customer, PaymentType paymentType, InvoiceStatus status)
    {
        this.id = id;
        this.idFood = idFood;
        this.date = date;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.paymentType = paymentType;
        this.status = status;
    }

    
    /* Bagian ini adalah bagian method dari class Invoice. */
    // ini adalah getter.
    /**
     * Method yang digunakan untuk mengambil id dari invoice.
     * @return id
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Method yang digunakan untuk mengambil id makanan dari invoice.
     * @return idFood
     */
    public int getIdFood()
    {
        return idFood;
    }
    
    /**
     * Method yang digunakan untuk mengambil nama dari seller.
     * @return date
     */
    public String getDate()
    {
        return date;
    }
    
    /**
     * Integer memiliki value return dari variable.
     * @return totalPrice
     */
    public int getTotalPrice()
    {
        return totalPrice;
    }
    
    /**
     * Mengambil parameter dari Class Customer.
     * @return customer
     */
    public Customer getCustomer()
    {
        return customer;
    }
    
    public PaymentType getPaymentType()
    {
        return paymentType;
    }
    
    public InvoiceStatus getInvoiceStatus()
    {
        return status;
    }
    
    // ini adalah setter.
    /**
     * Menetapkan nilai id awal dari invoice.
     * @param id            id dari invoice
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Menetapkan nilai id makanan awal dari invoice.
     * @param idFood        merupakan id dari makanan yang tertera di invoice
     */
    public void setIdFood(int idFood)
    {
        this.idFood = idFood;
    }
    
    /**
     * Menetapkan string tanggal awal dari invoice.
     * @param date          merupakan tanggal invoice dikeluarkan
     */
    public void setDate(String date)
    {
        this.date = date;
    }
    
    /**
     * Menetapkan string harga makanan awal dari invoice.
     * @param totalPrice    merupakan harga makanan
     */
    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    
    /**
     * Menetapkan data customer yang memesan makanan.
     * @param customer      merupakan data dari customer
     */
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    
    public void setPaymentType(PaymentType paymentType)
    {
        this.paymentType = paymentType;
    }
    
    public void setInvoiceStatus(InvoiceStatus status)
    {
        this.status = status;
    }
    
    /**
     * Bagian ini adalah bagian untuk print variabel yang ada di class Invoice.
     */
    public void printData()
    {
        System.out.println("================INVOICE================");
        System.out.println("ID: "+ id);
        System.out.println("Food ID: "+ idFood);
        System.out.println("Date: "+ date);
        System.out.println("Customer: "+ customer.getName());
        System.out.println("Total Price: "+ totalPrice); //yang diprint adalah total harga makanan yang dibeli
        System.out.println("Status: "+ InvoiceStatus.FINISHED);
    }
}