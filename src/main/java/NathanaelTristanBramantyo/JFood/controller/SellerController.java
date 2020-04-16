package NathanaelTristanBramantyo.JFood.controller;

import NathanaelTristanBramantyo.JFood.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RequestMapping("/seller")
@RestController
public class SellerController
{
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Seller> getAllSeller()
    {
        return DatabaseSeller.getSellerDatabase();
    }

    @RequestMapping(value = "/seller/{id}", method = RequestMethod.GET)
    public Seller getSellerById(int id)
    {
        Seller seller = null;
        try
        {
            seller = DatabaseSeller.getSellerById(id);
        }
        catch (SellerNotFoundException nf)
        {
            System.out.println(nf.getMessage());
        }
        return seller;
    }

    @RequestMapping(value = "/seller", method = RequestMethod.POST)
    public Seller addSeller(@RequestParam(value = "name") String name,
                            @RequestParam(value = "email") String email,
                            @RequestParam(value = "phoneNumber") String phoneNumber,
                            @RequestParam(value = "province") String province,
                            @RequestParam(value = "description") String description,
                            @RequestParam(value = "city") String city)
    {
        Location location = new Location(province, description, city);
        Seller newSeller = new Seller(DatabaseSeller.getLastId()+1, name, email, phoneNumber, location);
        DatabaseSeller.addSeller(newSeller);
        return newSeller;
    }
}
