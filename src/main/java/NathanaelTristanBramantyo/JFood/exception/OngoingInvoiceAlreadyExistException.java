package NathanaelTristanBramantyo.JFood.exception;

import NathanaelTristanBramantyo.JFood.invoice.Invoice;

public class OngoingInvoiceAlreadyExistException extends Exception
{
    Invoice invoice_error;

    public OngoingInvoiceAlreadyExistException(Invoice invoice_input)
    {
        super("Ongoing Invoice");
        this.invoice_error = invoice_input;
    }

    @Override
    public String getMessage()
    {
        return super.getMessage() + " already exist " + "with " +
                "Id: " + invoice_error.getId() + ", Customer: " + invoice_error.getCustomer().getName();
    }
}
