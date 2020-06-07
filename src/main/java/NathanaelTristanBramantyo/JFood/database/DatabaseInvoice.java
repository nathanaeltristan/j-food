package NathanaelTristanBramantyo.JFood.database;
import NathanaelTristanBramantyo.JFood.invoice.Invoice;
import NathanaelTristanBramantyo.JFood.exception.InvoiceNotFoundException;
import NathanaelTristanBramantyo.JFood.invoice.InvoiceStatus;
import NathanaelTristanBramantyo.JFood.exception.OngoingInvoiceAlreadyExistException;

import java.util.ArrayList;

public class DatabaseInvoice {

    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    /**
     * this method is getter for every invoice in invoice's database
     * @return ArrayList<Invoice> is the array list of every invoice in the invoice's database
     */
    public static ArrayList<Invoice>  getDatabaseInvoice()
    {
        return INVOICE_DATABASE;
    }

    /**
     * this method is to get the id of the last invoice added to invoice's database
     * @return an integer of the last invoice's id
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * this method is to get some invoice by specifying it's id
     * @param id is the invoice's id for the expected invoice object this method returns
     * @return an Invoice class object in respect of the id specified in the parameter
     * @throws InvoiceNotFoundException to check whether the invoice that goes by the id in the parameter exist or not
     */
    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException
    {
        for (Invoice invoice : INVOICE_DATABASE)
        {
            if (invoice.getId() == id)
            {
                return invoice;
            }
        }
        throw new InvoiceNotFoundException(id);
    }

    /**
     * this method is to get every invoice under one customer
     * @param customerId is the customer's id for the expected array list invoice that the customer have
     * @return an ArrayList of Invoice object that the customer have
     */
    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId)
    {
        ArrayList<Invoice> invoiceList = new ArrayList<Invoice>();
        for (Invoice invoice : INVOICE_DATABASE)
        {
            if(invoice.getCustomer().getId() == customerId)
            {
                invoiceList.add(invoice);
            }
        }
        return invoiceList;
    }

    /**
     * this method is to add invoice to the array list in the DatabaseInvoice that hold every invoice registered
     * @param invoice is a Invoice class object that wanted to be added to the DatabaseInvoice class array list
     * @return a boolean, true if the invoice is successfully added
     */
    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistException
    {
        int customerId = invoice.getCustomer().getId();
        for (Invoice iterasi : INVOICE_DATABASE)
        {
            if(iterasi.getCustomer().getId() == customerId && iterasi.getInvoiceStatus() == InvoiceStatus.ONGOING)
            {
                throw new OngoingInvoiceAlreadyExistException(invoice);
            }
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;
    }

    /**
     * this method is to change the invoice status for the invoice going by the id specified in the id parameter
     * @param id is the id of the invoice that wanted to be changed the status of
     * @param invoiceStatus is the status enum that wanted to be assigned to the invoice
     * @return a boolean, true if the invoice's status is successfully changed
     */
    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus)
    {
        for (Invoice invoice : INVOICE_DATABASE)
        {
            if(invoice.getId() == id && invoice.getInvoiceStatus().equals(InvoiceStatus.ONGOING))
            {
                invoice.setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }

    /**
     * this method is to remove an invoice going by the id specified in the id parameter
     * @param id is the id of the invoice that wanted to removed
     * @return a boolean, true if the invoice's status is successfully removed
     */
    public static boolean removeInvoice(int id) throws InvoiceNotFoundException
    {
        for (Invoice invoice : INVOICE_DATABASE)
        {
            if(invoice.getId() == id)
            {
                INVOICE_DATABASE.remove(invoice);
                return true;
            }
        }
        throw new InvoiceNotFoundException(id);
    }

}