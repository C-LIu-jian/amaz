package com.huwa.entity;

/**
 * 购物车条目类
 */
public class CartItem {
    private Product product;
    private int     quantity;

    public CartItem(int quantity,Product product) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
     //小计
    public  Double getSubTotal(){
        return quantity * product.getPrice();
    }
}
