package NathanaelTristanBramantyo.JFood.controller;

import NathanaelTristanBramantyo.JFood.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RequestMapping("/promo")
@CrossOrigin(origins = " ", allowedHeaders = "*")
@RestController
public class PromoController
{

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Promo> getAllPromo()
    {
        return DatabasePromo.getPromoDatabase();
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public Promo getPromoByCode(@PathVariable String code)
    {
        Promo promo = null;
        promo = DatabasePromo.getPromoByCode(code);
        return promo;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Promo addPromo(@RequestParam(value="code") String code,
                          @RequestParam(value="diskon") int diskon,
                          @RequestParam(value="minPrice") int minPrice,
                          @RequestParam(value="active")  boolean active)
    {
        Promo promo = new Promo(DatabasePromo.getLastId() + 1, code, diskon, minPrice, active);
        try
        {
            DatabasePromo.addPromo(promo);
        }
        catch (PromoCodeAlreadyExistException e)
        {
            e.getMessage();
            return null;
        }
        return promo;
    }

    @RequestMapping(value = "/activate/{id}", method = RequestMethod.POST)
    public Promo activatePromo(@PathVariable int id)
    {
        Promo promo = null;

        try
        {
            DatabasePromo.activePromo(id);
        }
        catch (Exception e)
        {
            e.getMessage();
            return null;
        }

        try
        {
            promo = DatabasePromo.getPromoById(id);
        }
        catch (PromoNotFoundException e)
        {
            e.getMessage();
        }
        return promo;
    }

    @RequestMapping(value = "/deactivate/{id}", method = RequestMethod.POST)
    public Promo deactivatePromo(@PathVariable int id)
    {
        Promo promo = null;

        try
        {
            DatabasePromo.deactivatePromo(id);
        }
        catch (Exception e)
        {
            e.getMessage();
            return null;
        }

        try
        {
            promo = DatabasePromo.getPromoById(id);
        }
        catch (PromoNotFoundException e)
        {
            e.getMessage();
        }
        return promo;
    }


}