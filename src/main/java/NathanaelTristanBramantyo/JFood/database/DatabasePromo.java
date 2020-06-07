package NathanaelTristanBramantyo.JFood.database;
import NathanaelTristanBramantyo.JFood.Promo;
import NathanaelTristanBramantyo.JFood.exception.PromoCodeAlreadyExistException;
import NathanaelTristanBramantyo.JFood.exception.PromoNotFoundException;

import java.util.ArrayList;

/**
 * Class DatabasePromo adalah .
 *
 *
 * @author  nathanaeltristan
 * @version 19/03/2020
 */

public class DatabasePromo
{
    private static ArrayList<Promo> PROMO_DATABASE = new ArrayList<Promo>();
    private static int lastId = 0;

    /**
     * this method is getter for every promo in promo's database
     * @return ArrayList<Promo> is the array list of every promo in the promo's database
     */
    public static ArrayList<Promo> getPromoDatabase()
    {
        return PROMO_DATABASE;
    }

    /**
     * this method is to get the id of the last promo added to promo's database
     * @return an integer of the last promo's id
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * this method is to get some promo by specifying it's id
     * @param id is the promo's id for the expected promo object this method returns
     * @return a Promo class object in respect of the id specified in the parameter
     * @throws PromoNotFoundException to check whether the promo that goes by the id in the parameter exist or not
     */
    public static Promo getPromoById(int id) throws PromoNotFoundException
    {
        for(Promo promo : PROMO_DATABASE)
        {
            if(promo.getId() == id)
            {
                return promo;
            }
        }
        throw new PromoNotFoundException(id);
    }

    /**
     * this method is to get some promo by specifying it's code
     * @param code is the promo's code for the expected promo object this method returns
     * @return a Promo class object in respect of it's code specified in the parameter
     */
    public static Promo getPromoByCode(String code)
    {
        for(Promo promo : PROMO_DATABASE)
        {
            if(promo.getCode().equals(code))
            {
                return promo;
            }
        }
        return null;
    }

    /**
     * this method is to add a promo to the array list in the DatabasePromo that hold every promo registered
     * @param promo is a Promo class object that wanted to be added to the DatabasePromo class array list
     * @return a boolean, true if the promo is successfully added
     */
    public static boolean addPromo (Promo promo) throws PromoCodeAlreadyExistException
    {
        for (Promo iterasi : PROMO_DATABASE)
        {
            if(iterasi.getCode().equals(promo.getCode()))
            {
                throw new PromoCodeAlreadyExistException(promo);
            }
        }
        PROMO_DATABASE.add(promo);
        lastId = promo.getId();
        return true;
    }


    /**
     * this method is to activate the promo by specifying it's id
     * @param id is the id of the promo that wanted to be activated
     * @return a boolean, true if the invoice is successfully activated
     */
    public static boolean activePromo (int id)
    {
        for(Promo promo : PROMO_DATABASE)
        {
            if (promo.getId() == id)
            {
                promo.setActive(true);
            }
        }
        return true;
    }

    /**
     * this method is to deactivate the promo by specifying it's id
     * @param id is the id of the promo that wanted to be deactivated
     * @return a boolean, true if the invoice is successfully deactivated
     */
    public static boolean deactivatePromo (int id)
    {
        for (Promo promo : PROMO_DATABASE)
        {
            if (promo.getId() == id)
            {
                promo.setActive(false);
            }
        }
        return true;
    }

    /**
     * this method is to remove a promo going by the id specified in the id parameter
     * @param id is the id of the promo that wanted to be removed
     * @return a boolean, true if the promo is successfully removed
     */
    public static boolean removePromo (int id) throws PromoNotFoundException
    {
        for (Promo promo : PROMO_DATABASE)
        {
            if (promo.getId() == id)
            {
                PROMO_DATABASE.remove(promo);
                return true;
            }
        }
        throw new PromoNotFoundException(id);
    }
}