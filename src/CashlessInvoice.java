import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;
import java.text.*;

/**
 * Write a description of class CashlessInvoice here.
 *
 * @author nathanaeltristan
 * @version 19/03/2020
 */
public class CashlessInvoice extends Invoice
{

    private static PaymentType PAYMENT_TYPE = PaymentType.CASHLESS;
    private Promo promo;

    /**
     * Constructor for objects of class CashlessInvoice
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
     * getPaymentType() is used to return Invoice's payment method
     *
     * @return    the paymentType of CashlessInvoice instance
     */
    public PaymentType getPaymentType()
    {

        return PAYMENT_TYPE;

    }

    /**
     * getPromo() is used to return CashlessInvoice's promotion
     *
     * @return    the promo of CashlessInvoice instance
     */
    public Promo getPromo()
    {

        return promo;

    }

    /**
     * setPromo() is used to change CashlessInvoice's promotion
     *
     * @param   promo to overwrite the current instance's promo
     */
    public void setPromo(Promo promo)
    {

        this.promo = promo;

    }

    /**
     * setTotalPrice() is used to change Invoice's total price
     *
     */
    public void setTotalPrice()
    {
        int tempPrice = 0;
        for (Food food : getFoods())
        {
            tempPrice += food.getPrice();
        }
        if (getPromo() != null && getPromo().getActive() == true && tempPrice > getPromo().getMinPrice())
        {

            this.totalPrice = (tempPrice - getPromo().getDiscount());

        }
        else
        {

            this.totalPrice = tempPrice;

        }

    }

    public String toString()
    {
        int tempPrice = 0;
        String foodName = "";
        for (Food food : getFoods())
        {
            tempPrice += food.getPrice();
            foodName += food.getName() + ", ";
        }
        SimpleDateFormat format1 = new SimpleDateFormat("dd MMMM yyyy");
        String date = format1.format(getDate().getTime());
        if (getPromo() != null && getPromo().getActive() == true && tempPrice > getPromo().getMinPrice())
        {

            return "\n================Invoice================" + "\n" +
                    "ID: " + getId() + "\n" +
                    "Name: " + foodName + "\n" +
                    "Date: " + date + "\n" +
                    "Customer: " + getCustomer().getName() + "\n" +
                    "Promo: " + getPromo().getCode() + "\n" +
                    "Total Price: " + totalPrice + "\n" +
                    "Status: " + getInvoiceStatus() + "\n" +
                    "Payment Type: " + getPaymentType() + "\n";


        }
        else
        {

            return "\n================Invoice================" + "\n" +
                    "ID: " + getId() + "\n" +
                    "Name: " + foodName + "\n" +
                    "Date: " + date + "\n" +
                    "Customer: " + getCustomer().getName() + "\n" +
                    "Total Price: " + totalPrice + "\n" +
                    "Status: " + getInvoiceStatus() + "\n" +
                    "Payment Type: " + getPaymentType() + "\n";

        }

    }
}