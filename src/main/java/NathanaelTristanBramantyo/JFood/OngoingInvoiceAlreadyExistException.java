package NathanaelTristanBramantyo.JFood;
public class OngoingInvoiceAlreadyExistException extends Exception
{
    private Invoice invoice_error;

    public OngoingInvoiceAlreadyExistException(Invoice invoice_input)
    {
        super("Ongoing Invoice: ");
        this.invoice_error = invoice_input;
    }

    @Override
    public String getMessage()
    {
        return super.getMessage() + invoice_error.getId() + " still ongoing";
    }
}
