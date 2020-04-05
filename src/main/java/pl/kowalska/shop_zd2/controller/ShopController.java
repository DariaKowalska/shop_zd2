package pl.kowalska.shop_zd2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import pl.kowalska.shop_zd2.service.ShopService;

@RestController
@Profile("Start")
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public String get() {

        return shopService.cartPrice();
    }

}
