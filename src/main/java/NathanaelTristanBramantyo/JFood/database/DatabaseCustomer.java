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
    /*
     * dibawah ini adalah deklarasi variabel untuk class Food
     * variabel ini akan digunakan untuk menyimpan data yang bersangkutan
     */
    public static boolean addCustomer(Customer customer) throws EmailAlreadyExistException{

        for(int i = 0; i < CUSTOMER_DATABASE.size(); i++){

            if (customer.getEmail().equals(CUSTOMER_DATABASE.get(i).getEmail())){

                throw new EmailAlreadyExistException(customer);

            }

        }

        CUSTOMER_DATABASE.add(customer);
        lastId = customer.getId();

        return true;
    }

    public static boolean removeCustomer(int id) throws CustomerNotFoundException{

        boolean status = false;

        for(int i = 0; i < CUSTOMER_DATABASE.size(); i++){

            if (id == CUSTOMER_DATABASE.get(i).getId()){

                CUSTOMER_DATABASE.remove(i);
                status = true;

            }

        }

        throw new CustomerNotFoundException(id);

    }

    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<Customer>();

    private static int lastId = 0;

    /**
     * Method untuk mendapatkan nilai dari listSeller
     * @return variabel listSeller
     */
    /*
     * method ini digunakan untuk mendapatkan nilai dari category
     * hasilnya method ini akan mengembalikan nilai category
     */

    public static ArrayList<Customer> getCustomerDatabase(){

        return CUSTOMER_DATABASE;

    }

    public static int getLastId(){

        return lastId;

    }

    public static Customer getCustomerById (int id) throws CustomerNotFoundException{

        for(int i = 0; i < CUSTOMER_DATABASE.size(); i++){

            if (id == CUSTOMER_DATABASE.get(i).getId()){

                return CUSTOMER_DATABASE.get(i);

            }

        }

        throw new CustomerNotFoundException(id);

    }

    public static Customer getCustomerLogin (String email, String password){

        for(int i = 0; i < CUSTOMER_DATABASE.size(); i++){

            if (email.equals(CUSTOMER_DATABASE.get(i).getEmail()) && password.equals(CUSTOMER_DATABASE.get(i).getPassword())){

                return CUSTOMER_DATABASE.get(i);

            }

        }

        return null;

    }
}
