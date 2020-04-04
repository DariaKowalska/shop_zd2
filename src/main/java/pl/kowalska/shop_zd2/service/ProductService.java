package pl.kowalska.shop_zd2.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.kowalska.shop_zd2.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> productList;

    public ProductService() {
        Product product1 = new Product("masło", 12);
        Product product2 = new Product("chleb", 6);
        Product product3 = new Product("bułka", 1);
        productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
    }
@EventListener(ApplicationReadyEvent.class)
    public void showProduct(){
        productList.forEach(System.out::println);
    }



}
