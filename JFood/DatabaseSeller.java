/**
 * Class DatabaseSeller adalah .
 *
 *
 * @author  nathanaeltristan
 * @version 28/02/2020
 */

public class DatabaseSeller
{
    /* Bagian ini adalah bagian deklarasi variabel. */
    private String listSeller;

    
    /* Bagian ini adalah constructor dari class DatabaseSeller */
    /**
     * @param listSeller
     */
    public DatabaseSeller(String listSeller)
    {
        this.listSeller = listSeller;
    }

    
    /* Bagian ini adalah bagian method dari class DatabaseSeller. */
    /**
     * Boolean hanya memiliki dua value datatype, yes atau no, on atau off, true atau false.
     * @param seller
     */
    public boolean addSeller(Seller seller)
    {
        return true;
    }
    
    /**
     * Boolean hanya memiliki dua value datatype, yes atau no, on atau off, true atau false.
     * @param seller
     */
    public boolean removeSeller(Seller seller)
    {
        return true;
    }
    
    /**
     * Method ini tidak memiliki value datatype, jadi return null, bukan return 0.
     * @param getSeller
     */
    public Seller getSeller()
    {
        return null;
    }
    
    /**
     * Method untuk mengambil dan menyimpan list makanan yang ada.
     * @param listSeller
     */
    public String getListSeller()
    {
        return listSeller;
    }
}