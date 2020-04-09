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

    private static final ArrayList<Promo> PROMO_DATABASE = new ArrayList<Promo>();
    private static int lastId = 0;

    public static ArrayList<Promo> getPromoDatabase()
    {

        return PROMO_DATABASE;

    }

    public static int getLastId()
    {

        return lastId;

    }

    public static Promo getPromoById(int id) throws PromoNotFoundException
    {

        for(Promo promo : PROMO_DATABASE)
        {
            if (promo.getId() == id)
            {
                return promo;
            }
        }
        throw new PromoNotFoundException(id);
    }

    public static Promo getPromoByCode(String code)
    {

        for(Promo promo : PROMO_DATABASE)
        {
            if (promo.getCode().equals(code))
            {
                return promo;
            }
        }
        return null;
    }

    public static boolean addPromo(Promo promo) throws PromoCodeAlreadyExistException
    {

        for (Promo promo1 : PROMO_DATABASE)
        {
            if (promo1.getCode().equals(promo.getCode()))
            {
                throw new PromoCodeAlreadyExistException(promo);
            }
        }
        PROMO_DATABASE.add(promo);
        lastId = promo.getId();
        return true;

    }

    public static boolean activatePromo(int id)
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

    public static boolean deactivatePromo(int id)
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

    public static boolean removePromo(int id) throws PromoNotFoundException
    {

        for(Promo promo : PROMO_DATABASE)
        {
            if (promo.getId() == id)
            {
                PROMO_DATABASE.remove(promo);
                return true;
            }
        }
        throw new PromoNotFoundException(id);
    }

    /**
     * getListPromo() is used to return the current list of promotion
     *
     * @return    listPromo that contains some String
     */

}