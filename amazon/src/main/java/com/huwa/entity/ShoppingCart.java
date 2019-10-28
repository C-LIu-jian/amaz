package com.huwa.entity;

import com.huwa.serviceImpl.ProductServiceImpl;

import java.util.*;

/**
 * 购物车类
 */
public class ShoppingCart {
    Map<Long,CartItem> cart = new LinkedHashMap<Long,CartItem>();

    //获取购物车容器对象
    public Map<Long, CartItem> getCart() {
        return cart;
    }

    //添加商品
    public boolean productAdd(Long id, int num) {
        //通过商品编号或得指定的购物车条目
        CartItem cartItem = cart.get(id);
        if (cartItem != null) {
            //添加商品数量
            cartItem.setQuantity(cartItem.getQuantity() + num);
        } else {
            try {
                Product product = new ProductServiceImpl().productOne(id); //根据id获取商品
                cartItem = new CartItem(num, product);     //封装成购物车条目
                cart.put(id, cartItem);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
         return  true;
    }

    //修改购物车中对应的商品数量
    public void cartProNum(Long id, int num) {
        //获取指定购物想
        CartItem item = cart.get(id);
        if (num == 0) {
            clearItem(id);  //删除购物项
        } else {
            item.setQuantity(num); //修改数量
        }

    }

    //删除指定购物车的购物项
    public void clearItem(long id) {
        cart.remove(id);
    }

    //清空购物车
    public void clear() {
        if (cart != null) {
            cart.clear();
        }
    }

    //总计
    public Double getTotal() {
        double total = 0;
        Set<Map.Entry<Long, CartItem>> entries = cart.entrySet();
        for (Map.Entry<Long, CartItem> entry : entries) {
            CartItem item = entry.getValue();//获取购物项
            total += item.getSubTotal();//小计累加
        }

        return total;
    }
   //或得所有值
    public Collection<CartItem> getCartItems(){
        return cart.values();
    }

}
