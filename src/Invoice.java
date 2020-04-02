import java.util.ArrayList;
import java.util.Calendar;

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

    private int id;
    private ArrayList<Food> foods;
    private Calendar date;
    protected int totalPrice = 0;
    private Customer customer;
    private InvoiceStatus invoiceStatus = InvoiceStatus.ONGOING;

    /**
     * Constructor for objects of class Invoice
     */
    public Invoice(int id, ArrayList<Food> foods, Customer customer)
    {

        this.id = id;
        this.foods = foods;
        this.customer = customer;
        this.date = Calendar.getInstance();

    }

    /**
     * getId() is used to return Invoice's ID
     *
     * @return    the Id of Invoice instance
     */
    public int getId()
    {

        return id;

    }

    /**
     * getFood() is used to return Invoice's food
     *
     * @return    the food of Invoice instance
     */
    public ArrayList<Food> getFoods()
    {

        return foods;

    }

    /**
     * getDate() is used to return Invoice's Date
     *
     * @return    the Date of Invoice instance
     */
    public Calendar getDate()
    {

        return date;

    }

    /**
     * getTotalPrice() is used to return Invoice's total price
     *
     * @return    the totalPrice of Invoice instance
     */
    public int getTotalPrice()
    {

        return totalPrice;

    }

    /**
     * getCustomer() is used to return Invoice's customer
     *
     * @return    the customer of Invoice instance
     */
    public Customer getCustomer()
    {

        return customer;

    }

    /**
     * getPaymentType() is used to return Invoice's payment method
     *
     * @return    the paymentType of Invoice instance
     */
    public abstract PaymentType getPaymentType();


    /**
     * getInvoiceStatus() is used to return Invoice's current status
     *
     * @return    the status of Invoice instance
     */
    public InvoiceStatus getInvoiceStatus()
    {

        return invoiceStatus;

    }

    /**
     * setId() is used to change Invoice's ID
     *
     * @param   id to overwrite the current instance's id
     */
    public void setId(int id)
    {

        this.id = id;

    }

    /**
     * setFood() is used to change Invoice's food
     *
     * @param   foods to overwrite the current instance's food
     */
    public void setFoods(ArrayList<Food> foods)
    {

        this.foods = foods;

    }

    /**
     * setDate() is used to change Invoice's date
     *
     * @param   date to overwrite the current instance's date
     */
    public void setDate(Calendar date)
    {

        this.date = date;

    }

    /**
     * setDate() is used to change Invoice's date
     *
     * @param   date to overwrite the current instance's date
     */
    public void setDate(int year, int month, int dayOfMonth)
    {

        this.date.set(year, month, dayOfMonth);

    }

    /**
     * setTotalPrice() is used to change Invoice's total price
     *
     * @param   totalPrice to overwrite the current instance's totalPrice
     */
    public abstract void setTotalPrice();

    /**
     * setCustomer() is used to change Invoice's customer
     *
     * @param   customer to overwrite the current instance's customer
     */
    public void setCustomer(Customer customer)
    {

        this.customer = customer;

    }

    /**
     * setInvoiceStatus() is used to change Invoice's status
     *
     * @param   status to overwrite the current instance's status
     */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus)
    {

        this.invoiceStatus = invoiceStatus;

    }

    public abstract String toString();
}