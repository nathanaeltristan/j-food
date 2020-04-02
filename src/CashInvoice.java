/**
 * Write a description of class CashInvoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CashInvoice extends Invoice
{
    // instance variables
    private static PaymentType PAYMENT_TYPE = PaymentType.CASH;
    private int deliveryFee;

    /**
     * First constructor for CashInvoice
     * @param id, the id of the invoice
     * @param food, the food object
     * @param date, the date when the invoice was made
     * @param customer, the customer listed in the invoice
     * @param invoiceStatus, the status of the invoice based on the InvoiceStatus class
     */
    public CashInvoice(int id, Food food, String date,
                        Customer customer, InvoiceStatus invoiceStatus)
    {
        super(id,food,date,customer,invoiceStatus);
    }
    
    /**
     * First constructor for CashInvoice
     * @param id, the id of the invoice
     * @param food, the food object
     * @param date, the date when the invoice was made
     * @param customer, the customer listed in the invoice
     * @param invoiceStatus, the status of the invoice based on the InvoiceStatus class
     */
    public CashInvoice(int id, Food food, String date,
                        Customer customer, InvoiceStatus invoiceStatus,
                        int deliveryFee)
    {
        super(id,food,date,customer,invoiceStatus);
        this.deliveryFee = deliveryFee;
    }

    /**
     * @return PAYMENT_TYPE, returns the cashless payment type
     */
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    
    /**
     * @return delivery fee, returns the delivery fee required, if any
     */
    public int getDeliveryFee()
    {
        return deliveryFee;
    }
    
    /**
     * @param deliveryFee, inputs the delivery fee
     */
    public void setDeliveryFee(int deliveryFee)
    {
        this.deliveryFee = deliveryFee;
    }
    
    /**
     * Abstract method for calculating total price
     */
    public void setTotalPrice()
    {
        if(deliveryFee != 0)
        {
            super.totalPrice = getFood().getPrice() + deliveryFee;
        }
        
        else
        {
            super.totalPrice = getFood().getPrice();
        }         
    }
    
    public void printData()
    {
        if(deliveryFee != 0)
        {
            System.out.println("==========INVOICE==========");
            System.out.println("ID: " + super.getId());
            System.out.println("Food: " + super.getFood().getName());
            System.out.println("Date: " + super.getDate());
            System.out.println("Customer: " + super.getCustomer().getName());
            System.out.println("Delivery Fee: " + getDeliveryFee());
            System.out.println("Total Price: " + super.getTotalPrice());
            System.out.println("Invoice Status: " + super.getInvoiceStatus());
            System.out.println("Payment Type: " + PAYMENT_TYPE);
        }
        
        else
        {
            System.out.println("==========INVOICE==========");
            System.out.println("ID: " + super.getId());
            System.out.println("Food: " + super.getFood().getName());
            System.out.println("Date: " + super.getDate());
            System.out.println("Customer: " + super.getCustomer().getName());
            System.out.println("Total Price: " + super.getTotalPrice());
            System.out.println("Delivery Fee: 0");
            System.out.println("Invoice Status: " + super.getInvoiceStatus());
            System.out.println("Payment Type: " + PAYMENT_TYPE);
        }
    }
}