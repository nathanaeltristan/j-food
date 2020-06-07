package NathanaelTristanBramantyo.JFood.database;
import NathanaelTristanBramantyo.JFood.Customer;
import NathanaelTristanBramantyo.JFood.exception.CustomerNotFoundException;
import NathanaelTristanBramantyo.JFood.exception.EmailAlreadyExistException;

import java.util.ArrayList;

/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author nathanaeltristan
 * @version 05/03/2020
 */
public class DatabaseCustomer
{
    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<Customer>();
    private static int lastId = 0;

    public static ArrayList<Customer> getDatabaseCustomer()
    {
        return CUSTOMER_DATABASE;
    }

    /**
     * getter of customer's last id in the array list database
     * @return an integer of customer's last id in the database
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * this method is to return a Customer class object by it's id
     * @param id is the id of the expected customer that this method returns
     * @return a Customer object in respect to the id in the parameter id
     */
    public static Customer getCustomerById(int id) throws CustomerNotFoundException
    {
        for (Customer customer : CUSTOMER_DATABASE)
        {
            if (customer.getId() == id)
            {
                return customer;
            }
        }
        throw new CustomerNotFoundException(id);
    }

    /**
     * this method is to add a customer to array list database
     * @param customer is the Customer object that want to be added to the database
     * @return a boolean, true if the customer is succeeded to be added to the database, otherwise false
     * @throws EmailAlreadyExistException is to check whether the email that wanted to be added to database is already exist
     */
    public static boolean addCustomer(Customer customer) throws EmailAlreadyExistException
    {
        for (Customer iterasi : CUSTOMER_DATABASE)
        {
            if(iterasi.getEmail().equals(customer.getEmail()))
            {
                throw new EmailAlreadyExistException(customer);
            }
        }
        CUSTOMER_DATABASE.add(customer);
        lastId = customer.getId();
        return true;
    }

    /**
     * this method is to remove the specified customer from the database
     * @param id is the customer's id to point to the customer that wanted to be removed
     * @return a boolean, true if the customer is succeeded to be removed from the database, otherwise false
     * @throws CustomerNotFoundException is to check whether the customer that wanted to be removed from the database is exist or not
     */
    public static boolean removeCustomer(int id) throws CustomerNotFoundException
    {
        for(Customer customer : CUSTOMER_DATABASE)
        {
            if(customer.getId() == id)
            {
                CUSTOMER_DATABASE.remove(customer);
                return true;
            }
        }
        throw new CustomerNotFoundException(id);
    }

    /**
     * this method is check if the email and the password match for any customer
     * @param email is the customer's email that wanted to be match to the password
     * @param password is the customer's password for the email in this method's parameter
     * @return a boolean, true if the email and the password match for any Customer's object in the database that have the specified email, otherwise returns false
     */
    public static Customer getCustomerLogin(String email, String password)
    {
        for(Customer customers : CUSTOMER_DATABASE)
        {
            if(customers.getEmail().equals(email) && customers.getPassword().equals(password))
            {
                return customers;
            }
        }
        return null;
    }

}