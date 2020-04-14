package NathanaelTristanBramantyo.JFood;
/**
 * Enumeration class PaymentType - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum PaymentType
{
    CASHLESS("Cashless"),
    CASH("Cash");
    
    private String paymentType;
    
    PaymentType(String typePayment)
    {
        this.paymentType = paymentType;
    }
    
    public String toString()
    {
        return paymentType;
    }
}