package entity;

import java.io.Serializable;
import java.util.Objects;

public class Phone extends Device implements Serializable {
    private Integer displaySize;

    public Phone(Brand brand, Integer price, Integer displaySize) {
        super(brand, price);
        this.displaySize = displaySize;
    }

    @Override
    public void turnOn() {
        System.out.println("Телефон включен");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Phone phone = (Phone) o;
        return Objects.equals(displaySize, phone.displaySize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), displaySize);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "displaySize=" + displaySize +
                " brand=" + super.getBrand() +
                " price=" + super.getPrice() +
                '}';
    }

    public Integer getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(Integer displaySize) {
        this.displaySize = displaySize;
    }
}
