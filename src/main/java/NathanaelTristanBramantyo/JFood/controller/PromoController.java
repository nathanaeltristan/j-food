package NathanaelTristanBramantyo.JFood.controller;

import NathanaelTristanBramantyo.JFood.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RequestMapping("/promo")
@RestController
public class PromoController
{
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Promo> getAllPromo()
    {
        return DatabasePromo.getPromoDatabase();
    }

    @RequestMapping(value = "/promo/{code}", method = RequestMethod.GET)
    public Promo getPromoByCode (@RequestParam (value = "code") String code)
    {
        return DatabasePromo.getPromoByCode(code);
    }

    @RequestMapping(value = "/seller", method = RequestMethod.GET)
    public Promo addPromo(@RequestParam(value = "code") String code,
                          @RequestParam(value = "discount") int discount,
                          @RequestParam(value = "minPrice") int minPrice,
                          @RequestParam(value = "active") Boolean active)
    {
        try
        {
            Promo promo = new Promo(DatabasePromo.getLastId() + 1, code, discount, minPrice, active);
            DatabasePromo.addPromo(promo);
            return promo;
        }
        catch(PromoCodeAlreadyExistException p)
        {
            p.getMessage();
            return null;
        }
    }
}
