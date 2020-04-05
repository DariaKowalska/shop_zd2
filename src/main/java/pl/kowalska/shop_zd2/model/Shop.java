package pl.kowalska.shop_zd2.model;


import java.math.BigDecimal;

public class Shop {

    private String productName;
    private BigDecimal productPrice;


    public Shop(String productName, BigDecimal productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}