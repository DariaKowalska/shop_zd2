package pl.kowalska.shop_zd2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.kowalska.shop_zd2.model.Shop;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Profile("Pro")
public class ShopProService {


    @Value("${shop.vat}")
    private double vat;
    @Value("${shop.discount}")
    private double discount;
    private List<Shop> productList;

    public ShopProService() {
        int min = 50;
        int max = 300;
        Shop product1 = new Shop("masło", randomPrice(min, max));
        Shop product2 = new Shop("chleb", randomPrice(min, max));
        Shop product3 = new Shop("bułka", randomPrice(min, max));
        Shop product4 = new Shop("ser", randomPrice(min, max));
        Shop product5 = new Shop("mleko", randomPrice(min, max));


        productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
    }

    private BigDecimal randomPrice(int min, int max) {
        int randomInt = new Random().nextInt(((max - min) + 1) + min);
        BigDecimal productPrice = new BigDecimal(BigInteger.valueOf(randomInt));
        return productPrice;
    }

    public List<Shop> getProducts() {
        return productList;
    }

    public String cartPrice() {
        double totalPrice = 0;
        for (Shop product : productList) {
            totalPrice += product.getProductPrice().doubleValue();
        }

        return "Lista produktów:" + productList + "koszt" + new BigDecimal((totalPrice * vat) * (1 - discount));
    }

    @EventListener(ApplicationReadyEvent.class)
    public void displayPrice() {
        System.out.println(cartPrice());
    }
}
