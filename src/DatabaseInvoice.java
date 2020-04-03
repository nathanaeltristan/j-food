import java.util.ArrayList;

public class DatabaseInvoice {
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
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
        ArrayList<Invoice> kembali = new ArrayList<Invoice>();
        for(Invoice invoice : INVOICE_DATABASE)
        {
            if(invoice.getId() == customerId)
            {
                kembali.add(invoice);
            }
        }
        if(kembali.isEmpty())
        {
            return null;
        }
        return kembali;
    }

    public static boolean addInvoice(Invoice invoice)
    {
        for(Invoice invoicenew : INVOICE_DATABASE)
        {
            if(invoicenew.getInvoiceStatus().equals(InvoiceStatus.ONGOING))
            {
                return false;
            }
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }

    public static boolean changeInvoice(InvoiceStatus invoiceStatus)
    {
        for(Invoice invoice : INVOICE_DATABASE)
        {
            if(invoiceStatus.equals(InvoiceStatus.ONGOING))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean removeInvoice(int id)
    {

    }
}
