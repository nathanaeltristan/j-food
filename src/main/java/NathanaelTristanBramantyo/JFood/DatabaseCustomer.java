package NathanaelTristanBramantyo.JFood;
import java.util.ArrayList;

/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author nathanaeltristan
 * @version 05/03/2020
 */
public class DatabaseCustomer
{
    // instance variables - replace the example below with your own
    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<Customer>();
    private static int lastId = 0;

    /**
     * Constructor for objects of class DatabaseCustomer
     */
    public DatabaseCustomer()
    {
    }

    /**
     * Method to show customer database
     * @return customer database
     */
    public static ArrayList<Customer> getCustomerDatabase()
    {
        return CUSTOMER_DATABASE;
    }

    /**
     * Method to show last id
     * @return last id in database
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * Method to show customer by id
     * @return customer
     */
    public static Customer getCustomerById(int id) throws CustomerNotFoundException
    {
        for(Customer customer:CUSTOMER_DATABASE)
        {
            if (id == customer.getId())
            {
                return customer;
            }
        }
        throw new CustomerNotFoundException(id);
    }

    /**
     * Method to add customer
     * @return false default return param to check successability
     */
    public static boolean addCustomer(Customer customer) throws EmailAlreadyExistException
    {
        for(Customer customers:CUSTOMER_DATABASE)
        {
            if (customers.getEmail() == customer.getEmail())
            {
                throw new EmailAlreadyExistException(customer);
            }
        }
        CUSTOMER_DATABASE.add(customer);
        lastId = customer.getId();
        return true;
    }

    /**
     * Method to remove customer
     * @return false default return param to check successability
     */
    public static boolean removeCustomer(int id) throws CustomerNotFoundException
    {
        for(int i = 0;  i < CUSTOMER_DATABASE.size(); i++)
        {
            Customer customer = CUSTOMER_DATABASE.get(i);
            if (id == customer.getId())
            {
                CUSTOMER_DATABASE.remove(id);
                return true;
            }
        }
        throw new CustomerNotFoundException(id);
    }

    public static Customer getCostumerLogin(String email, String password)
    {
        for(Customer cust : CUSTOMER_DATABASE)
        {
            if(cust.getEmail().equals(cust.getEmail()) && cust.getPassword().equals(cust.getPassword()))
            {
                return cust;
            }
        }
        return null;
    }

}