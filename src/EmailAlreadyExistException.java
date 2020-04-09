public class EmailAlreadyExistException extends Exception
{
    private Customer customer_error;

    public EmailAlreadyExistException(Customer customer_input)
    {
        super("Customer Email: ");
        customer_error = customer_input;
    }

    public String getMessage()
    {
        return super.getMessage() + customer_error.getEmail() + "not found";
    }
}
