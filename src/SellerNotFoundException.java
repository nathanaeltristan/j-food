public class SellerNotFoundException extends Exception
{
    private int seller_error;

    SellerNotFoundException (int seller_input)
    {
        super("Seller ID: ");
        seller_error = seller_input;
    }

    public String getMessage()
    {
        return super.getMessage() + seller_error + "not found";
    }
}