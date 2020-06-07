package NathanaelTristanBramantyo.JFood.controller;

import NathanaelTristanBramantyo.JFood.*;
import NathanaelTristanBramantyo.JFood.database.DatabaseCustomer;
import NathanaelTristanBramantyo.JFood.database.DatabaseCustomerPostgre;
import NathanaelTristanBramantyo.JFood.exception.CustomerNotFoundException;
import NathanaelTristanBramantyo.JFood.exception.EmailAlreadyExistException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/customer")
@CrossOrigin(origins = " ", allowedHeaders = "*")
@RestController
public class CustomerController
{

    @RequestMapping("")
    public ArrayList<Customer> indexPage() {
        return DatabaseCustomer.getCustomerDatabase();
    }

    @RequestMapping(value="/customer/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable int id)
    {
        Customer customer = null;
        try
        {
            customer = DatabaseCustomerPostgre.getCustomer(id);
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return customer;
    }

    @RequestMapping(value = "/customer/{register}", method = RequestMethod.POST)
    public Customer register(@RequestParam(value="name") String name,
                             @RequestParam(value="email") String email,
                             @RequestParam(value="password") String password)
    {
        try
        {
            return DatabaseCustomerPostgre.insertCustomer(
                    DatabaseCustomerPostgre.getLastCustomerId()+1,
                    name,
                    email,
                    password);
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }

    }

    @RequestMapping(value = "/customer/{login}", method = RequestMethod.POST)
    public Customer loginCustomer(@RequestParam(value="email") String email,
                                  @RequestParam(value="password") String password)
    {
        Customer customer = null;

        try
        {
            customer = DatabaseCustomerPostgre.getLogin(email, password);
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
        return customer;

    }
}