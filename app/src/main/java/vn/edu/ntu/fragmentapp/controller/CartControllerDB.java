package vn.edu.ntu.fragmentapp.controller;

import android.content.Context;

import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.fragmentapp.model.AppDatabase;
import vn.edu.ntu.fragmentapp.model.DAOProduct;
import vn.edu.ntu.fragmentapp.model.Product;

public class CartControllerDB implements IController {
    AppDatabase database;
    List<Product> shoppingCart = new ArrayList<>();

    DAOProduct daoProduct;

    public CartControllerDB(Context context) {
        database = Room.databaseBuilder(context,AppDatabase.class,"tuan")
                .allowMainThreadQueries()
                .build();
        daoProduct = database.getProDuctDAO();
    }

    @Override
    public void getProduct(Context context, Product product) {

    }

    @Override
    public List<Product> getAllProduct(Context context) {
        return daoProduct.getListProduct();
    }

    @Override
    public List<Product> getShopping() {
        return shoppingCart;
    }

    @Override
    public boolean addShoopingCart(Product product) {
        if (shoppingCart.contains(product))
        {
            return false;
        }
        shoppingCart.add(product);
        return true;
    }

    @Override
    public void clearShopping() {
      shoppingCart.clear();
    }

    @Override
    public void addProduct(Product p) {
        daoProduct.insertProduct(p);
    }

    @Override
    public void deleteProduct(Product p) {
        daoProduct.deleteProduct(p);
    }

    @Override
    public void updateProduct(Product p) {
        daoProduct.updateProduct(p);
    }
}
