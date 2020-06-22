package vn.edu.ntu.fragmentapp.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Product")
public class Product {

    @PrimaryKey(autoGenerate = true)
    int id;
    @NonNull
    String Name;
    @NonNull
    int Price;
    String Desc;

    public Product() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return Name;
    }

    public void setName(@NonNull String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public Product(int id, @NonNull String name, int price, String desc) {
        this.id = id;
        Name = name;
        Price = price;
        Desc = desc;
    }
}
