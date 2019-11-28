package ua.com.epam.entity.book.nested;

import java.util.Objects;

public class Additional {
    private int pageCount;
    private Size size;

  public Additional(int pageCount, Size size) {
    this.pageCount = pageCount;
    this.size = size;
  }

  public int getPageCount() {
    return pageCount;
  }

  public void setPageCount(int pageCount) {
    this.pageCount = pageCount;
  }

  public Size getSize() {
    return size;
  }

  public void setSize(Size size) {
    this.size = size;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Additional that = (Additional) o;
    return pageCount == that.pageCount &&
        Objects.equals(size, that.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageCount, size);
  }
}
