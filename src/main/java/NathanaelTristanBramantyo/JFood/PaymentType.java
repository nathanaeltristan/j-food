package NathanaelTristanBramantyo.JFood;
/**
 * Enumeration class PaymentType - write a description of the enum class here
 *
 * @author nathanaeltristan
 * @version (version number or date here)
 */

public enum PaymentType
{
    CASHLESS("Cashless"),
    CASH("Cash");

    private String cara_bayar;

    PaymentType(String cara_bayar)
    {
        this.cara_bayar = cara_bayar;
    }

    public String toString()
    {
        return cara_bayar;
    }

}