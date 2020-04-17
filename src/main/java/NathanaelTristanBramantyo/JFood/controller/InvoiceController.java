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

    @RequestMapping(value = "/createCashInvoice", method = RequestMethod.POST)
    public Invoice addCashInvoice(@RequestParam(value="name") String name,
                                  @RequestParam(value="foodIdList") ArrayList<Integer> foodIdList,
                                  @RequestParam(value="customerId") int customerId,
                                  @RequestParam(value="deliveryFee") int deliveryFee)
    {
        ArrayList<Food> foods = new ArrayList<>();
        for (int food : foodIdList)
        {
            try
            {
                foods.add(DatabaseFood.getFoodById(food));
            }
            catch (FoodNotFoundException e)
            {
                System.out.println(e.getMessage());
            }
        }

        try
        {
            Invoice invoice = new CashInvoice(DatabaseInvoice.getLastId()+1, foods, DatabaseCustomer.getCustomerById(customerId), deliveryFee);
            DatabaseInvoice.addInvoice(invoice);
            return invoice;
        }
        catch (CustomerNotFoundException | OngoingInvoiceAlreadyExistException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @RequestMapping(value = "/createCashlessInvoice", method = RequestMethod.POST)
    public Invoice addCashlessInvoice(@RequestParam(value="name") String name,
                                      @RequestParam(value="foodIdList") ArrayList<Integer> foodIdList,
                                      @RequestParam(value="customerId") int customerId,
                                      @RequestParam(value="promoCode") String promoCode)
    {
        ArrayList<Food> foods = new ArrayList<>();
        for (int food : foodIdList)
        {
            try
            {
                foods.add(DatabaseFood.getFoodById(food));
            }
            catch (FoodNotFoundException e)
            {
                System.out.println(e.getMessage());
            }
        }

        try
        {
            Invoice invoice = new CashlessInvoice(DatabaseInvoice.getLastId()+1, foods,
                    DatabaseCustomer.getCustomerById(customerId), DatabasePromo.getPromoByCode(promoCode));
            DatabaseInvoice.addInvoice(invoice);
            return invoice;
        }
        catch (CustomerNotFoundException | OngoingInvoiceAlreadyExistException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
