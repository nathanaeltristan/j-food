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

    public static Seller getSellerById(int id)
    {

        for(Seller seller : SELLER_DATABASE)
        {
            if (seller.getId() == id)
            {
                return seller;
            }
        }
        return null;
    }

    public static boolean addSeller(Seller seller)
    {

        SELLER_DATABASE.add(seller);
        lastId = seller.getId();
        return true;

    }

    public static boolean removeSeller(int id)
    {

        for(Seller seller : SELLER_DATABASE)
        {
            if (seller.getId() == id)
            {
                SELLER_DATABASE.remove(seller);
                return true;
            }
        }
        return false;

    }

    /**
     * getListSeller() is used to return the current list of seller
     *
     * @return    listSeller that contains some String
     */

}