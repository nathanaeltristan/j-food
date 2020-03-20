/**
 * Class Invoice berisi id dari invoice, id dan total harga dari makanan,
 * tanggal pembelian, dan nama customer.
 *
 *
 * @author  nathanaeltristan
 * @version 20/02/2020
 */

public abstract class Invoice
{
   /**
     * The variable for class Invoice
     */
    private int id;
    private Food Food;
    private String date;
    protected int totalPrice;
    private Customer customer;
    private InvoiceStatus invoiceStatus;
    
    /**
     * Constructor for objects in class Invoice
     * 
     * @param id (invoice's id)
     * @param idFood (invoice's food id)
     * @param date (invoice's date)
     * @param totalprice (invoice's total price)
     * @param customer (invoice's customer)
     */
    public Invoice(int id, Food Food, String date, Customer customer,  InvoiceStatus invoiceStatus)
    {
       this.id = id;
       this.Food = Food;
       this.date = date;
       this.customer = customer;
       this.totalPrice = totalPrice;
       this.invoiceStatus = invoiceStatus;
    }

    /**
     * Gets the invoice's id
     *
     * @return id
     */
    public int getId()
    {
        return id;
    }
    /**
     * Gets the invoice's food id
     *
     * @return idFood
     */
    public Food getFood()
    {
        return Food;
    }
    /**
     * Gets the invoice's date
     *
     * @return date
     */
    public String getDate()
    {
        return date;
    }
    /**
     * Gets the invoice's total price
     *
     * @return totalPrice
     */
    public int getTotalPrice()
    {
        return totalPrice;
    }
    /**
     * Gets the invoice's customer
     *
     * @return customer
     */
    public Customer getCustomer()
    {
        return customer;
    }
    /**
     * Gets the invoice's payment type
     *
     * @return paymenType
     */
    public abstract PaymentType getPaymentType();
    
    /**
     * Gets the invoice's status
     *
     * @return status
     */
    public InvoiceStatus getInvoiceStatus()
    {
        return invoiceStatus;
    }
    /**
     * Sets the invoice's id
     * 
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
     * Sets the invoice's food id
     * 
     * @param idFood
     */
     public void setFood(Food Food)
    {
        this.Food = Food;
    }
    /**
     * Sets the invoice's date
     * 
     * @param date
     */
    public void setDate(String date)
    {
        this.date = date;
    }
    /**
     * Sets the invoice's total price
     * 
     * @param totalPrice
     */
    public abstract void setTotalPrice();
    
    /**
     * Sets the invoice's customer
     * 
     * @param customer
     */
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    
      
    /**
     * Sets the invoice's status
     * 
     * @param status
     */
    public void setInvoiceStatus(InvoiceStatus InvoiceStatus)
    {
        this.invoiceStatus = invoiceStatus;
    }
     /**
     * To print out (printData)
     * 
     * @param idFood
     * @param totalPrice
     */
    public abstract void printData();
    
    
   
    
}
