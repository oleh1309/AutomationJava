package ua.com.epam.entity.book.nested;

import java.util.Objects;

public class Size {

  private double height;
  private double width;
  private double length;

  public Size(double height, double width, double length) {
    this.height = height;
    this.width = width;
    this.length = length;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    this.length = length;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {return true;}
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Size size = (Size) o;
    return Double.compare(size.height, height) == 0 &&
        Double.compare(size.width, width) == 0 &&
        Double.compare(size.length, length) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(height, width, length);
  }
}
