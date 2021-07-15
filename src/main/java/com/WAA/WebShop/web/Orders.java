package com.WAA.WebShop.web;

import com.WAA.WebShop.domain.Order;


import java.util.ArrayList;
import java.util.Collection;

public class Orders {
    private Collection<Order> orders =new ArrayList<>();

    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }
}
