package NathanaelTristanBramantyo.JFood.controller;

import NathanaelTristanBramantyo.JFood.*;
import NathanaelTristanBramantyo.JFood.database.DatabaseCustomer;
import NathanaelTristanBramantyo.JFood.database.DatabaseFood;
import NathanaelTristanBramantyo.JFood.database.DatabaseInvoice;
import NathanaelTristanBramantyo.JFood.database.DatabasePromo;
import NathanaelTristanBramantyo.JFood.exception.CustomerNotFoundException;
import NathanaelTristanBramantyo.JFood.exception.FoodNotFoundException;
import NathanaelTristanBramantyo.JFood.exception.InvoiceNotFoundException;
import NathanaelTristanBramantyo.JFood.exception.OngoingInvoiceAlreadyExistException;
import NathanaelTristanBramantyo.JFood.invoice.CashInvoice;
import NathanaelTristanBramantyo.JFood.invoice.CashlessInvoice;
import NathanaelTristanBramantyo.JFood.invoice.Invoice;
import NathanaelTristanBramantyo.JFood.invoice.InvoiceStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/invoice")
@CrossOrigin(origins = "*", allowedHeaders = "")
@RestController
public class InvoiceController {

    /**
     * Method to prints all invoice in the data base
     * @return all invoice in database
     */
    @RequestMapping("")
    public ArrayList<Invoice> getAllInvoice()
    {
        return DatabaseInvoice.getInvoiceDatabase();
    }

    /**
     * Method to get invoice from id
     * @param id variable to store id of invoice
     * @return single invoice object
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable int id) throws InvoiceNotFoundException {
        Invoice invoice = DatabaseInvoice.getInvoiceById(id);
        return invoice;
    }

    /**
     * Method to get invoice from customer
     * @param customerId variable to store id of customer
     * @return single invoice object
     */
    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByCustomer(@PathVariable int customerId) throws InvoiceNotFoundException {
        ArrayList<Invoice> invoices = DatabaseInvoice.getInvoiceByCustomer(customerId);
        return invoices;
    }

    /**
     * Method to get invoice from customer with ongoing status
     * @param customerId variable to store id of customer
     * @return single invoice object
     */
    @RequestMapping(value = "/customerOngoing/{customerId}", method = RequestMethod.GET)
    public Invoice getInvoiceOngoingByCustomer(@PathVariable int customerId) throws InvoiceNotFoundException {
        ArrayList<Invoice>invoices = DatabaseInvoice.getInvoiceByCustomer(customerId);
        for(Invoice invoice:invoices){
            if(invoice.getInvoiceStatus() == InvoiceStatus.ONGOING){
                return invoice;
            }
        }
        return null;
    }

    /**
     * Method to change invoice status
     * @param id variable to store id of invoice
     * @param status variabel to store status invoice
     * @return single invoice object if success, null if failed
     */
    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@RequestParam(value="id") @PathVariable int id, @RequestParam(value="status") InvoiceStatus status) throws InvoiceNotFoundException {
        if (DatabaseInvoice.changeInvoiceStatus(id, status))
        {
            return DatabaseInvoice.getInvoiceById(id);
        }
        return null;
    }

    /**
     * Method to remove invoice
     * @param id variable to store id of invoice
     * @return true if success, null if failed
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@PathVariable int id) {
        try
        {
            DatabaseInvoice.removeInvoice(id);
        } catch (InvoiceNotFoundException e)
        {
            e.printStackTrace();
            return null;
        }
        return true;
    }

    /**
     * Method to adds new invoice into database with cash payment type
     * @param foodIdList variable that stores all foods that was purchased
     * @param customerId variable that stores id of the customer
     * @param deliveryFee variable that stores delivery fee
     * @return object invoice that was added to database
     */
    @RequestMapping(value = "/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value="foodList") ArrayList<Integer> foodIdList,
                                  @RequestParam(value="customerId") int customerId,
                                  @RequestParam(value="deliveryFee",required = false,defaultValue = "0") int deliveryFee)
    {
        ArrayList<Food> menu = new ArrayList<>();
        for (Integer foodId : foodIdList)
        {
            try
            {
                menu.add(DatabaseFood.getFoodById(foodId));
            } catch (FoodNotFoundException e) {
                e.printStackTrace();
            }

        }
        try{
            Invoice invoice = new CashInvoice(DatabaseInvoice.getLastId() + 1, menu, DatabaseCustomer.getCustomerById(customerId), deliveryFee);
            DatabaseInvoice.addInvoice(invoice);
            DatabaseInvoice.getInvoiceById(DatabaseInvoice.getLastId()).setTotalPrice();
            return invoice;
        }
        catch (OngoingInvoiceAlreadyExistException | CustomerNotFoundException | InvoiceNotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Method to adds new invoice into database with cashless payment type
     * @param foodIdList variable that stores all foods that was purchased
     * @param customerId variable that stores id of the customer
     * @param promoCode variable that stores promo code
     * @return object invoice that was added to database
     */
    @RequestMapping(value = "/createCashlessInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(@RequestParam(value="foodList") ArrayList<Integer> foodIdList,
                                      @RequestParam(value="customerId") int customerId,
                                      @RequestParam(value="promoCode",required = false) String promoCode)
    {
        ArrayList<Food> menu = new ArrayList<>();
        for (Integer foodId : foodIdList)
        {
            try
            {
                menu.add(DatabaseFood.getFoodById(foodId));
            } catch (FoodNotFoundException e) {
                e.printStackTrace();
            }

        }

        Promo promo = DatabasePromo.getPromoByCode(promoCode);
        try{
            Invoice invoice = new CashlessInvoice(DatabaseInvoice.getLastId() + 1, menu, DatabaseCustomer.getCustomerById(customerId), promo);
            DatabaseInvoice.addInvoice(invoice);
            DatabaseInvoice.getInvoiceById(DatabaseInvoice.getLastId()).setTotalPrice();
            return invoice;
        }
        catch (OngoingInvoiceAlreadyExistException | CustomerNotFoundException | InvoiceNotFoundException e){
            System.out.println(e.getMessage());
        }return null;
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public Invoice cancelTransaction(@RequestParam(value="id") int id_invoice) throws InvoiceNotFoundException {
        DatabaseInvoice.getInvoiceById(id_invoice).setInvoiceStatus(InvoiceStatus.CANCELLED);
        return DatabaseInvoice.getInvoiceById(id_invoice);
    }

    @RequestMapping(value = "/finish", method = RequestMethod.POST)
    public Invoice finishTransaction(@RequestParam(value="id") int id_invoice) throws InvoiceNotFoundException {
        DatabaseInvoice.getInvoiceById(id_invoice).setInvoiceStatus(InvoiceStatus.FINISHED);
        return DatabaseInvoice.getInvoiceById(id_invoice);
    }
}
