package NathanaelTristanBramantyo.JFood;

public class PriceCalculator implements Runnable
{
    Invoice invoice;
    public PriceCalculator(Invoice invoice)
    {
        this.invoice = invoice;
    }

    @Override
    public void run()
    {
        System.out.println("calculating invoice id: " + invoice.getId());
        invoice.setTotalPrice();
        System.out.println("finished calculating invoice id: " + invoice.getId());
    }

}