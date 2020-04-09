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
        ArrayList<Invoice> temp = new ArrayList<>();
        Customer customer = DatabaseCustomer.getCustomerById(customerId);
        for(Invoice invoice : INVOICE_DATABASE)
        {
            if (invoice.getCustomer().equals(customer))
            {
                temp.add(invoice);
            }
        }
        return temp;
    }

    public static boolean addInvoice(Invoice invoice)
    {
        int customerId = invoice.getCustomer().getId();
        for (Invoice invoice1 : INVOICE_DATABASE)
        {
            if (invoice1.getCustomer().getId() == customerId && invoice1.getInvoiceStatus() == InvoiceStatus.ONGOING)
            {
                return false;
            }
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }

    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus)
    {
        for (Invoice invoice : INVOICE_DATABASE)
        {
            if (invoice.getId() == id && invoice.getInvoiceStatus().equals(InvoiceStatus.ONGOING))
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