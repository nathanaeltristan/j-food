package NathanaelTristanBramantyo.JFood.invoice;
/**
 * Enumeration class InvoiceStatus - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum InvoiceStatus
{
    ONGOING("Ongoing"),
    FINISHED("Finished"),
    CANCELLED("Cancelled");
    
    private String status;
    
    InvoiceStatus(String status)
    {
        this.status = status;
    }
    
    public String toString()
    {
        return status;
    }
}
