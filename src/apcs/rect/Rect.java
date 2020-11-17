package apcs.rect;

public class Rect {
    private double width;
    private double height;

    public Rect() {
        this.width = 0.0;
        this.height = 0.0;
    }

    public Rect(double w, double h) {
        this.width = w;
        this.height = h;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getDiagonal() {
        return Math.sqrt(Math.pow(this.width, 2) + Math.pow(this.height, 2));
    }

    public double getPerimeter() {
        return 2 * this.width + 2 * this.height;
    }

    @Override
    public String toString() {
        return "Rect{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rect rect = (Rect) o;
        return Double.compare(rect.width, width) == 0 &&
                Double.compare(rect.height, height) == 0;
    }
}
