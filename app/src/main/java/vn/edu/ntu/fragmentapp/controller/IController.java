package vn.edu.ntu.fragmentapp.controller;

import android.content.Context;

import java.util.List;

import vn.edu.ntu.fragmentapp.model.Product;

public interface IController {
    public void getProduct(Context context, Product product);
    public List<Product> getAllProduct(Context context);
    public List<Product> getShopping();
    public boolean addShoopingCart(Product product);
    public void clearShopping();
    public void addProduct(Product p);
    public void deleteProduct(Product p);

    public void updateProduct(Product p);
}
