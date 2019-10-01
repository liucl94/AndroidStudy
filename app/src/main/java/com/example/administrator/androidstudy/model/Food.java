package com.example.administrator.androidstudy.model;

public class Food {
    private String name;
    private int price;
    private int picture;
    private boolean hot;
    private boolean fish;
    private boolean sour;

    public Food(String name, int price, int picture, boolean hot, boolean fish, boolean sour) {
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.hot = hot;
        this.fish = fish;
        this.sour = sour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public boolean isFish() {
        return fish;
    }

    public void setFish(boolean fish) {
        this.fish = fish;
    }

    public boolean isSour() {
        return sour;
    }

    public void setSour(boolean sour) {
        this.sour = sour;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", picture=" + picture +
                ", hot=" + hot +
                ", fish=" + fish +
                ", sour=" + sour +
                '}';
    }
}
