package entity;

import java.io.Serializable;
import java.util.Objects;

public abstract class Device implements Serializable {
    private Brand brand;
    private Integer price;

    public Device(Brand model, Integer price) {
        this.brand = model;
        this.price = price;
    }

    abstract public void turnOn();


    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Objects.equals(brand, device.brand) && Objects.equals(price, device.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, price);
    }

    @Override
    public String toString() {
        return "Device{" +
                "brand=" + brand +
                ", price=" + price +
                '}';
    }
}


