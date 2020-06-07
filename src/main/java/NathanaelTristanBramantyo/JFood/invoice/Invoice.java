package NathanaelTristanBramantyo.JFood.invoice;
import NathanaelTristanBramantyo.JFood.Customer;
import NathanaelTristanBramantyo.JFood.Food;
import NathanaelTristanBramantyo.JFood.PaymentType;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
    // instance variables - replace the example below with your own
    private int id;
    private ArrayList<Food> foods = new ArrayList<>();
    private Calendar date;
    protected int totalPrice;
    private Customer customer;
    // private PaymentType paymentType;
    private InvoiceStatus invoiceStatus;

    /**
     * This is the constructor for objects of Invoice class
     * @param id is to hold the value of invoice's id
     * @param idFood is to hold the value of invoice's food id
     * @param date is to hold the value of invoice's date
     * @param customer is to hold the customer object in the current invoice
     * @param totalPrice is to hold the value of total price of the current invoice
     */
    public Invoice(int id, ArrayList<Food> foods, Customer customer)
    {
        this.id = id;
        this.foods = foods;
        // this.date = date;
        this.customer = customer;
        this.date = new GregorianCalendar();
        this.invoiceStatus = InvoiceStatus.ONGOING;
    }

    /**
     * this is the getter of invoice's id
     * @return id of the invoice
     */
    public int getId()
    {
        return id;
    }

    /**
     * this is the getter of invoice's food id
     * @return food id of the invoice
     */
    public ArrayList<Food> getFoods()
    {
        return foods;
    }

    /**
     * this is the getter of invoice's date
     * @return date of the invoice
     */
    public Calendar getDate()
    {
        return date;
    }

    /**
     * this is the getter of invoice's total price
     * @return total price of the invoice
     */
    public int getTotalPrice()
    {
        return totalPrice;
    }

    /**
     * this is the getter of invoice's customer
     * @return a Customer Class object for current Invoice
     */
    public Customer getCustomer()
    {
        return customer;
    }

    /**
     * getter abstract method for overriding in every Invoice subclasses, which will return the payment type
     */
    public abstract PaymentType getPaymentType();

    public InvoiceStatus getInvoiceStatus()
    {
        return invoiceStatus;
    }

    /**
     * this is the setter of the invoice's date
     * @param date is date of the invoice
     */
    public void setDate(Calendar date)
    {
        this.date = date;
    }

    /**
     * this is the setter of invoice's date
     * @param year the year current invoice is created
     * @param month the month current invoice is created in integer
     * @param dayOfMonth the day current invoice is created in integer
     */
    public void setDate(int year, int month, int dayOfMonth)
    {
        this.date = new GregorianCalendar(year, month-1, dayOfMonth);
    }

    /**
     * this is the setter of the invoice's ordered foods
     * @param foods is an array list for every food ordered in the current invoice
     */
    public void setFoods(ArrayList<Food> foods)
    {
        this.foods = foods;
    }

    /**
     * this is the setter of the invoice's total price
     * @param totalPrice is total price in the invoice
     */
    public abstract void setTotalPrice();

    /**
     * this is the setter of the invoice's status
     * @param invoiceStatus is the for which enum invoice status that wanted to be assigned to this invoice
     */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus)
    {
        this.invoiceStatus = invoiceStatus;
    }

    /**
     * this method is to print any data in this class
     */
    public abstract String toString();



}