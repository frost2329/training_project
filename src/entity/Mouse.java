package entity;


import java.util.Objects;

public class Mouse extends Device  {
    private Color colorOfMouse;

    public Mouse(Brand model, Integer price, Color colorOfMouse) {
        super(model, price);
        this.colorOfMouse = colorOfMouse;
    }

    @Override
    public void turnOn() {
        System.out.println("Мышка подключена");
    }

    public Color getColorOfMouse() {
        return colorOfMouse;
    }

    public void setColorOfMouse(Color colorOfMouse) {
        this.colorOfMouse = colorOfMouse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Mouse mouse = (Mouse) o;
        return colorOfMouse == mouse.colorOfMouse;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), colorOfMouse);
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "colorOfMouse=" + colorOfMouse +
                '}';
    }
}
