public class CustomerNotFoundException extends Exception
{
    private int customer_error;

    CustomerNotFoundException(int customer_input)
    {
        super("Customer ID: ");
        customer_error = customer_input;
    }

    public String getMessage()
    {
        return super.getMessage() + customer_error + "not found";
    }
}
