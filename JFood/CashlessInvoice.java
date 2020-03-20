/**
 * Write a description of class CashlessInvoice here.
 *
 * @author nathanaeltristan
 * @version 19/03/2020
 */
public class CashlessInvoice extends Invoice
{
        private static final PaymentType PAYMENT_TYPE = PaymentType.Cashless;
        private Promo promo;
    
    /**
     * Constructor for objects of class CashlessInvoice
     */
    public CashlessInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus)
    {
       super(id, food, date, customer, invoiceStatus);
    }
    
       
    public CashlessInvoice(int id, Food food, String date, Customer customer, InvoiceStatus invoiceStatus, Promo promo)
    {
       super(id, food, date, customer, invoiceStatus);
       this.promo = promo;
    }
    
    @Override
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    
    public Promo getPromo()
    {
        return promo;
    }
    
    public void setPromo(Promo promo)
    {
        this.promo = promo;
    }
    
    public void setTotalPrice()
    {
        if(promo != null
        && getFood().getPrice() >= promo.getMinPrice()
        && promo.getActive() == true)
        {
            super.totalPrice = (getFood().getPrice() - promo.getDiscount());
        }
        else 
        {
            super.totalPrice = getFood().getPrice();
        }
    }
    
    public void printData()
    {
        System.out.println("==========INVOICE==========");
        System.out.println("ID: " + super.getId());
        System.out.println("Food: " + super.getFood().getName());
        System.out.println("Date: " + super.getDate());
        System.out.println("Customer: " + super.getCustomer().getName());
        if(getFood().getPrice() != totalPrice)
        {
            System.out.println("Promo: "+ promo.getCode());
        }
        System.out.println("Total Price: " + super.totalPrice);
        System.out.println("Status: " + super.getInvoiceStatus());
        System.out.println("Payment Type: " + getPaymentType());
    }
}
