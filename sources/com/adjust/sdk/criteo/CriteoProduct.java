package com.adjust.sdk.criteo;
public class CriteoProduct {
    public float price;
    public String productID;
    public int quantity;

    public CriteoProduct(float f, int i, String str) {
        this.price = f;
        this.quantity = i;
        this.productID = str;
    }
}
