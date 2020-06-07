package NathanaelTristanBramantyo.JFood.exception;

public class SellerNotFoundException extends Exception {

    private int seller_error;

    public SellerNotFoundException (int seller_input)
    {
        super("Seller ID: ");
        this.seller_error = seller_input;
    }

    @Override
    public String getMessage()
    {
        return super.getMessage() + seller_error + " not found";
    }
}