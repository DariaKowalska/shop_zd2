package pl.kowalska.shop_zd2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kowalska.shop_zd2.service.ShopProService;

@RestController
@Profile("Pro")

public class ShopProController {
    private final ShopProService shopProService;

    @Autowired
    public ShopProController(ShopProService shopProService) {
        this.shopProService = shopProService;
    }

    @GetMapping
    public String get() {

        return shopProService.cartPrice();
    }
}
