package vn.edu.ntu.fragmentapp.controller;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vn.edu.ntu.fragmentapp.model.Product;

public class Controller extends Application implements IController {
    List<Product> products = new ArrayList<>();
    List<Product> productsShopping = new ArrayList<>();
    public static final String PRESS_NAME = "Sharepreference";

    public Controller() {

    }

    @Override
    public void getProduct(Context context, Product product)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PRESS_NAME,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> A = sharedPreferences.getStringSet(product.getName(),new HashSet<String>());
        A.add(""+product.getPrice());
        A.add(product.getDesc());
        editor.putStringSet(product.getName(),A);
        editor.commit();
    }

    @Override
    public List<Product> getAllProduct(Context context) {
        Set<String> A = null;
        SharedPreferences sharedPreferences = context.getSharedPreferences(PRESS_NAME,context.MODE_PRIVATE);

return products;
    }

    @Override
    public List<Product> getShopping()
    {
        return productsShopping;
    }

    @Override
    public boolean addShoopingCart(Product product) {
        if(productsShopping.contains(product)){
            return false;
        }
        else
        {
            productsShopping.add(product);
            return true;
        }
    }

    @Override
    public void clearShopping() {
        productsShopping.clear();
    }

    @Override
    public void addProduct(Product p) {
        products.add(p);
    }

    @Override
    public void deleteProduct(Product p) {
        products.remove(p);
    }

    @Override
    public void updateProduct(Product p) {
        products.size();
    }

}
