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
    private static int lastId;
    public static ArrayList<Promo> getPromoDatabase()
    {

        return PROMO_DATABASE;

    }

    public static int getLastId()
    {

        return lastId;

    }

    public static Promo getPromoById(int id)
    {

        for(Promo promo : PROMO_DATABASE)
        {
            if (promo.getId() == id)
            {
                return promo;
            }
        }
        return null;
    }

    public static Promo getPromoByCode(String code)
    {

        for(Promo promo : PROMO_DATABASE)
        {
            if (promo.getCode() == code)
            {
                return promo;
            }
        }
        return null;
    }

    public static boolean addPromo(Promo promo)
    {

        for (Promo promo1 : PROMO_DATABASE)
        {
            if (promo.getCode() == promo1.getCode())
            {
                return false;
            }
        }
        PROMO_DATABASE.add(promo);
        lastId = promo.getId();
        return true;

    }

    public static boolean activePromo(int id)
    {
        for (Promo promo : PROMO_DATABASE)
        {
            if (promo.getId() == id)
            {
                promo.setActive(true);
                return true;
            }
        }
        return false;
    }

    public static boolean deactivePromo(int id)
    {
        for (Promo promo : PROMO_DATABASE)
        {
            if (promo.getId() == id)
            {
                promo.setActive(false);
                return true;
            }
        }
        return false;
    }

    public static boolean removePromo(int id)
    {

        for(Promo promo : PROMO_DATABASE)
        {
            if (promo.getId() == id)
            {
                PROMO_DATABASE.remove(promo);
                return true;
            }
        }
        return false;

    }

    /**
     * getListPromo() is used to return the current list of promotion
     *
     * @return    listPromo that contains some String
     */

}