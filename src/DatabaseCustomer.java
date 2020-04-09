import java.util.ArrayList;

/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author nathanaeltristan
 * @version 05/03/2020
 */
public class DatabaseCustomer
{

    private static final ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<Customer>();
    private static int lastId = 0;

    public static ArrayList<Customer> getCustomerDatabase()
    {

        return CUSTOMER_DATABASE;

    }

    public static int getLastId()
    {

        return lastId;

    }

    public static Customer getCustomerById(int id) throws CustomerNotFoundException
    {

        for(Customer customer : CUSTOMER_DATABASE)
        {
            if (customer.getId() == id)
            {
                return customer;
            }
        }
        throw new CustomerNotFoundException(id);
    }

    public static boolean addCustomer(Customer customer) throws EmailAlreadyExistException
    {
        for(Customer customer1 : CUSTOMER_DATABASE)
        {
            if (customer.getEmail() == customer1.getEmail())
            {
                throw new EmailAlreadyExistException(customer);
            }
        }
        CUSTOMER_DATABASE.add(customer);
        lastId = customer.getId();
        return true;

    }

    public static boolean removeCustomer(int id) throws CustomerNotFoundException
    {

        for(Customer customer : CUSTOMER_DATABASE)
        {
            if (customer.getId() == id)
            {
                CUSTOMER_DATABASE.remove(customer);
                return true;
            }
        }
        throw new CustomerNotFoundException(id);

    }


    /**
     * getListCustomer() is used to return the current list of seller
     *
     * @return    listSeller that contains some String
     */


}