package NathanaelTristanBramantyo.JFood.database;
import NathanaelTristanBramantyo.JFood.Seller;
import NathanaelTristanBramantyo.JFood.exception.SellerNotFoundException;

import java.util.ArrayList;

/**
 * Class DatabaseSeller adalah .
 *
 *
 * @author  nathanaeltristan
 * @version 28/02/2020
 */

public class DatabaseSeller
{
    // instance variables - replace the example below with your own
    private static ArrayList<Seller> SELLER_DATABASE = new ArrayList<Seller>();
    private static int lastId = 0;

    public static ArrayList<Seller> getSellerDatabase()
    {
        return SELLER_DATABASE;
    }

    public static int getLastId()
    {
        return lastId;
    }

    public static Seller getSellerById(int id) throws SellerNotFoundException
    {
        for (Seller seller : SELLER_DATABASE)
        {
            if (seller.getId() == id)
            {
                return seller;
            }
        }
        throw new SellerNotFoundException(id);
    }

    public static boolean addSeller(Seller seller)
    {
        SELLER_DATABASE.add(seller);
        lastId = seller.getId();
        return true;
    }

    public static boolean removeSeller(int id) throws SellerNotFoundException
    {
        for (Seller seller : SELLER_DATABASE)
        {
            if (seller.getId() == id)
            {
                SELLER_DATABASE.remove(seller);
                return true;
            }
        }
        throw new SellerNotFoundException(id);
    }


}