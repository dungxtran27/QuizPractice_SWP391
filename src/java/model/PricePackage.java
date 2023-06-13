/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class PricePackage {
    private int priceId;
    private String name;
    private int acessDuration;
    private float price;
    private float salePrice;
    private boolean status;
    private String description;
    
    public PricePackage() {
    }

    public PricePackage(int priceId, String name, int acessDuration, float price, float salePrice, boolean status, String description) {
        this.priceId = priceId;
        this.name = name;
        this.acessDuration = acessDuration;
        this.price = price;
        this.salePrice = salePrice;
        this.status = status;
        this.description = description;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAcessDuration() {
        return acessDuration;
    }

    public void setAcessDuration(int acessDuration) {
        this.acessDuration = acessDuration;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}

