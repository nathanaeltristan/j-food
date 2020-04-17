package NathanaelTristanBramantyo.JFood.controller;

import NathanaelTristanBramantyo.JFood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public class InvoiceController
{
    @RequestMapping("")
    public ArrayList<Invoice> getAllInvoice()
    {
        return DatabaseInvoice.getInvoiceDatabase();
    }

    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable int id)
    {
        Invoice invoice = null;
        try
        {
            invoice = DatabaseInvoice.getInvoiceById(id);
        }
        catch (InvoiceNotFoundException notfound)
        {
            System.out.println(notfound.getMessage());
        }
        return invoice;
    }

    @RequestMapping(value = "/invoice/customer/{customerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByCustomer(@PathVariable int customerId)
    {
        ArrayList<Invoice> cust = null;
        cust = DatabaseInvoice.getInvoiceByCustomer(customerId);
        return cust;
    }

    @RequestMapping(value = "/invoice/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam InvoiceStatus status)
    {
        Invoice invoice = null;
        if(status == InvoiceStatus.ONGOING)
        {
            DatabaseInvoice.changeInvoiceStatus(id, status);
            try
            {
                invoice = DatabaseInvoice.getInvoiceById(id);
            }
            catch (InvoiceNotFoundException notfound)
            {
                System.out.println(notfound.getMessage());
            }
            return invoice;
        }
        else
        {
            return null;
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@PathVariable int id)
    {
        try
        {
            DatabaseInvoice.removeInvoice(id);
        }
        catch(InvoiceNotFoundException i)
        {
            i.getMessage();
            return null;
        }
        return true;
    }

    @RequestMapping(value = "/invoice/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(@RequestParam(value = "foodIdList")ArrayList<Integer> foodList,
                                      @RequestParam(value = ))
    {
        Invoice cashlessInvoice = null;
        ArrayList<Food> foodList = new ArrayList<>();

        for (Integer foodId : foodList)
        {
            try {
                foodList.add(DatabaseFood.getFoodById(foodId));
            }
            catch (FoodNotFoundException notfound)
            {
                System.out.println(notfound.getMessage());
            }
        }

        try
        {
            cashlessInvoice = new CashlessInvoice(DatabaseInvoice.getLastId()+1, foodList, DatabaseCustomer.getCustomerById(1));
        }
        catch (CustomerNotFoundException c)
        {
            System.out.println(c.getMessage());
        }
    }
}
