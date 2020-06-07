package NathanaelTristanBramantyo.JFood.invoice;
import NathanaelTristanBramantyo.JFood.Customer;
import NathanaelTristanBramantyo.JFood.Food;
import NathanaelTristanBramantyo.JFood.PaymentType;
import NathanaelTristanBramantyo.JFood.Promo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Write a description of class CashlessInvoice here.
 *
 * @author nathanaeltristan
 * @version 19/03/2020
 */
public class CashlessInvoice extends Invoice
{
    // instance variables - replace the example below with your own
    private static final PaymentType PAYMENT_TYPE = PaymentType.CASHLESS;
    private Promo promo;

    /**
     * Constructor for objects of class CashInvoice
     * @param id is the id of the current invoice
     * @param foods is an array list that consist of object of Food class that specifies a list of foods the customer orders in the current invoice
     * @param customer is a customer class object of the customer who orders in respect of this current invoice
     * @param promo is a promo class object that this invoice use for if any promo is used
     */
    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        super(id, foods, customer);
    }

    public CashlessInvoice(int id, ArrayList<Food> foods, Customer customer, Promo promo)
    {
        super(id, foods, customer);
        this.promo = promo;
    }

    /**
     * getter for current invoice's payment type
     * @return an integer value of this invoice delivery fee
     */
    @Override
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }

    /**
     * getter for current invoice's promo in object of Promo class
     * @return an object of Promo class if this invoice use any valid promo code
     */
    public Promo getPromo()
    {
        return promo;
    }

    /**
     * setter for current invoice's promo
     * @param promo is the promo that this invoice is going to use
     */
    public void setPromo(Promo promo)
    {
        this.promo = promo;
    }

    /**
     * this method is to calculate the total price for current invoice
     */
    public void setTotalPrice()
    {
        super.totalPrice = 0;
        //loop trough arraylist makanan dari Invoice
        for(Food foodList : getFoods())
        {
            //totalkan harga makanan
            super.totalPrice=super.totalPrice+foodList.getPrice();
        }
        //jika total harga memenuhi syarat promo dan promo aktif maka:
        if (promo != null && getPromo().getActive() == true && super.totalPrice > getPromo().getMinPrice())
        {
            super.totalPrice = super.totalPrice  - promo.getDiscount();
        }
        //jika tidak ada promo maka:
        else
        {
            super.totalPrice = super.totalPrice + 0;
        }
    }

    /**
     * this method is to return a complete string of the invoice informations
     * @return a String about the information of current invoice
     */
    public String toString()
    {
        //String manipulation buat list makanan yang dibeli
        String foods = "";
        for (Food foodList : getFoods()) {
            foods = foods + foodList.getName() + ", ";
        }
        foods = foods.substring(0, foods.length() - 2);

        //hitung total harga
        setTotalPrice();

        //set waktu sekarang
        String timeNow = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        timeNow = sdf.format(super.getDate().getTime());

        //return value
        //if promo tidak ada / tidak aktif / total harga tidak memenuhi syarat promo maka:
        if(promo == null || promo.getActive() == false || super.totalPrice  < getPromo().getMinPrice())
        {
            return "==========INVOICE==========\n" +
                    "ID: " + super.getId() +
                    "\nFood: " + foods +
                    "\nDate: " + timeNow +
                    "\nCustomer: " + super.getCustomer().getName() +
                    "\nTotal Price: " + getTotalPrice() +
                    "\nStatus: " + super.getInvoiceStatus() +
                    "\nPayment Type: " + PAYMENT_TYPE +"\n";

        }
        //jika kondisi promo dipenuhi maka:
        else
        {
            return "==========INVOICE==========\n" +
                    "ID: " + super.getId() +
                    "\nFood: " + foods +
                    "\nDate: " + timeNow +
                    "\nPromo: " + promo.getCode() +
                    "\nCustomer: " + super.getCustomer().getName() +
                    "\nTotal Price: " + getTotalPrice() +
                    "\nStatus: " + super.getInvoiceStatus() +
                    "\nPayment Type: " + PAYMENT_TYPE +"\n";
        }

    }
}