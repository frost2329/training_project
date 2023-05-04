package entity;

public class Laptop extends  Device{
    private Integer displaySize;
    private MatrixType matrixType;
    public Laptop(Brand model, Integer price, Integer displaySize, MatrixType matrixType) {
        super(model, price);
        this.displaySize = displaySize;
        this.matrixType = matrixType;
    }

    @Override
    public void turnOn() {
        System.out.println("Ноутбук включен");
    }

    public Integer getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(Integer displaySize) {
        this.displaySize = displaySize;
    }

    public MatrixType getMatrixType() {
        return matrixType;
    }

    public void setMatrixType(MatrixType matrixType) {
        this.matrixType = matrixType;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "displaySize=" + displaySize +
                ", matrixType=" + matrixType +
                '}';
    }
}
