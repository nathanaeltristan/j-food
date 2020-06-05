package NathanaelTristanBramantyo.JFood.exception;

import NathanaelTristanBramantyo.JFood.Customer;

public class EmailAlreadyExistException extends Exception
{
    private Customer customer_error;

    public EmailAlreadyExistException(Customer customer_input)
    {
        super("Customer Email: ");
        this.customer_error = customer_input;
    }

    @Override
    public String getMessage()
    {
        return super.getMessage() + customer_error.getEmail() + " already exists";
    }
}
