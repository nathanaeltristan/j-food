import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.*;
import java.text.*;

/**
 * Write a description of class CashInvoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CashInvoice extends Invoice
{

    private static PaymentType PAYMENT_TYPE = PaymentType.CASH;
    private int deliveryFee = 0;

    /**
     * Constructor for objects of class CashInvoice
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
     * getPaymentType() is used to return Invoice's payment method
     *
     * @return    the paymentType of CashInvoice instance
     */
    public PaymentType getPaymentType()
    {

        return PAYMENT_TYPE;

    }

    /**
     * getDeliveryFee() is used to return CashInvoice's delivery fee
     *
     * @return    the deliveryFee of CashInvoice instance
     */
    public int getDeliveryFee()
    {

        return deliveryFee;

    }

    /**
     * setDeliveryFee() is used to change CashInvoice's delivery fee
     *
     * @param   deliveryFee to overwrite the current instance's deliveryFee
     */
    public void setDeliveryFee(int deliveryFee)
    {

        this.deliveryFee = deliveryFee;

    }

    /**
     * setTotalPrice() is used to change Invoice's total price
     *
     */
    public void setTotalPrice()
    {

        if (getDeliveryFee() != 0)
        {
            for (Food food : getFoods())
            {
                this.totalPrice += food.getPrice();
            }
            this.totalPrice += getDeliveryFee();

        }
        else
        {

            for (Food food : getFoods())
            {
                this.totalPrice += food.getPrice();
            }

        }

    }

    public String toString()
    {
        String foodName = "";
        for (Food food : getFoods())
        {
            foodName += food.getName() + ", ";
        }
        SimpleDateFormat format1 = new SimpleDateFormat("dd MMMM yyyy");
        String date = format1.format(getDate().getTime());
        if (getDeliveryFee() != 0)
        {

            return "================Invoice================" + "\n" +
                    "ID: " + getId() + "\n" +
                    "Name: " + foodName + "\n" +
                    "Date: " + date + "\n" +
                    "Customer: " + getCustomer().getName() + "\n" +
                    "Total Price: " + totalPrice + "\n" +
                    "Status: " + getInvoiceStatus() + "\n" +
                    "Payment Type: " + getPaymentType() + "\n" +
                    "Delivery Fee: " + getDeliveryFee();

        }
        else
        {

            return "================Invoice================" + "\n" +
                    "ID: " + getId() + "\n" +
                    "Name: " + foodName + "\n" +
                    "Date: " + date + "\n" +
                    "Customer: " + getCustomer().getName() + "\n" +
                    "Total Price: " + totalPrice + "\n" +
                    "Status: " + getInvoiceStatus() + "\n" +
                    "Payment Type: " + getPaymentType();

        }



    }
}