package NathanaelTristanBramantyo.JFood.invoice;
import NathanaelTristanBramantyo.JFood.Customer;
import NathanaelTristanBramantyo.JFood.Food;
import NathanaelTristanBramantyo.JFood.PaymentType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Write a description of class CashInvoice here.
 *
 * @author nathanaeltristan
 * @version 20/03/2020
 */
public class CashInvoice extends Invoice
{
    private static final PaymentType PAYMENT_TYPE = PaymentType.CASH;
    private int deliveryFee = 0;

    /**
     * Constructor for objects of class CashInvoice
     * @param id is the id of the current invoice
     * @param foods is an array list that consist of object of Food class that specifies a list of foods the customer orders in the current invoice
     * @param customer is a customer class object of the customer who orders in respect of this current invoice
     * @param deliveryFee is the value of delivery fee for the current invoice
     */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        super(id, foods, customer);
    }

    public CashInvoice(int id, ArrayList<Food> foods, Customer customer, int deliveryFee)
    {
        super(id, foods, customer);
        this.deliveryFee = deliveryFee;
    }

    /**
     * getter for current invoice's payment type
     * @return a payment type enum
     */
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }

    /**
     * getter for current invoice's delivery fee value in integer
     * @return an integer value of this invoice delivery fee
     */
    public int getDeliveryFee()
    {
        return deliveryFee;
    }

    /**
     * setter for this invoice's delivery fee
     * @param deliveryFee is the delivery fee that wanted to be specified in the current invoice
     */
    public void setDeliveryFee(int deliveryFee)
    {
        this.deliveryFee = deliveryFee;
    }

    /**
     * this method is to calculate the total price for current invoice
     */
    public void setTotalPrice()
    {
        super.totalPrice = 0;
        for(Food foodList : super.getFoods())
        {
            super.totalPrice = super.totalPrice + foodList.getPrice();
        }
        if(deliveryFee > 0)
        {
            super.totalPrice = super.totalPrice + deliveryFee;
        }

    }

    /**
     * this method is to return a complete string of the invoice informations
     * @return a String about the information of current invoice
     */
    public String toString()
    {
        //inisiasi total harga
        setTotalPrice();

        //inisiasi waktu sekarang
        String timeNow = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        timeNow = sdf.format(super.getDate().getTime());

        //String manipulation untuk list makanan yang dibeli
        String foods = "";
        for (Food foodList : getFoods())
        {
            foods = foods + foodList.getName() + ", ";
        }
        foods = foods.substring(0, foods.length() - 2);

        //return value
        return "==========INVOICE==========\n" +
                "ID : " + super.getId() +
                "\nFoods: " + foods +
                "\nDate: " + timeNow +
                "\nCustomer: " + super.getCustomer().getName() +
                "\nTotal Delivery Fee: " + deliveryFee +
                "\nTotal Price: " + super.getTotalPrice() +
                "\nStatus: " + super.getInvoiceStatus() +
                "\nPayment Type: " + PAYMENT_TYPE + "\n";
    }

}