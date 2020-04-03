import java.util.ArrayList;

public class DatabaseInvoice
{

    private static final ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int lastId = 0;

    public static ArrayList<Invoice> getInvoiceDatabase()
    {

        return INVOICE_DATABASE;

    }

    public static int getLastId()
    {

        return lastId;

    }

    public static Invoice getInvoiceById(int id)
    {

        for(Invoice invoice : INVOICE_DATABASE)
        {
            if (invoice.getId() == id)
            {
                return invoice;
            }
        }
        return null;
    }

    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId)
    {
        ArrayList<Invoice> temp = new ArrayList<Invoice>();
        for(Invoice invoice : INVOICE_DATABASE)
        {
            if (invoice.getCustomer().getId() == customerId)
            {
                temp.add(invoice);
            }
        }
        return temp;
    }

    public static boolean addInvoice(Invoice invoice)
    {

        if (invoice.getInvoiceStatus().equals(InvoiceStatus.ONGOING))
        {
            return false;
        }
        else
        {
            INVOICE_DATABASE.add(invoice);
            lastId = invoice.getId();
            return true;

        }

    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus)
    {
        for (Invoice invoice : INVOICE_DATABASE)
        {
            if (invoice.getId() == id)
            {
                invoice.setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }

    public static boolean removeInvoice(int id)
    {

        for(Invoice invoice : INVOICE_DATABASE)
        {
            if (invoice.getId() == id)
            {
                INVOICE_DATABASE.remove(invoice);
                return true;
            }
        }
        return false;

    }

    /**
     * getListSeller() is used to return the current list of seller
     *
     * @return    listSeller that contains some String
     */

}