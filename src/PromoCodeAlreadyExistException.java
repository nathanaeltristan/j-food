public class PromoCodeAlreadyExistException
{
    private Promo promo_error;

    public PromoCodeAlreadyExistException(Promo promo_input)
    {
        super("Promo Code: ");
        customer_error = customer_input;
    }

    public String getMessage()
    {
        return super.getMessage() + promo_error.getCode() + "not found";
    }
}
