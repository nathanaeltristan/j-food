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
    public static ArrayList<Customer> getCustomerDatabase()
    {

        return CUSTOMER_DATABASE;

    }

    public static int getLastId()
    {

        return lastId;

    }

    public static Customer getCustomerById(int id)
    {

        for(Customer customer : CUSTOMER_DATABASE)
        {
            if (customer.getId() == id)
            {
                return customer;
            }
        }
        return null;
    }

    public static boolean addCustomer(Customer customer)
    {
        for(Customer customer1 : CUSTOMER_DATABASE)
        {
            if (customer.getEmail() == customer1.getEmail())
            {
                return false;
            }
        }
        CUSTOMER_DATABASE.add(customer);
        lastId = customer.getId();
        return true;

    }

    public static boolean removeCustomer(int id)
    {

        for(Customer customer : CUSTOMER_DATABASE)
        {
            if (customer.getId() == id)
            {
                CUSTOMER_DATABASE.remove(customer);
                return true;
            }
        }
        return false;

    }


    /**
     * getListCustomer() is used to return the current list of seller
     *
     * @return    listSeller that contains some String
     */


}
