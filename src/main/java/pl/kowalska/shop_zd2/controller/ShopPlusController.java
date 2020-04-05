package pl.kowalska.shop_zd2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kowalska.shop_zd2.service.ShopPlusService;

@RestController
@Profile("Plus")
public class ShopPlusController {

    private final ShopPlusService shopPlusService;

    @Autowired
    public ShopPlusController(ShopPlusService shopPlusService) {
        this.shopPlusService = shopPlusService;
    }

    @GetMapping
    public String get() {

        return shopPlusService.cartPrice();
    }

}
