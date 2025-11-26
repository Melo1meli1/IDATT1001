package Project;

/**
 * Enum class, Category
 * Holds the values and operations associated with category.
 */
public enum Category {

  /**
   * The Floor laminate.
   */
  FLOOR_LAMINATE(1, "Floor Laminate"),

  /**
   * Windows category.
   */
  WINDOWS(2, "Windows"),

  /**
   * Doors category.
   */
  DOORS(3, "Doors"),

  /**
   * Lumber category.
   */
  LUMBER(4, "Lumber");
  private int categoryNumber;
  private String categoryName;

  /**
   * Category constructor Creates a new Category with the given numerical value and name.
   *
   * @param categoryNumber The numerical value of the Category.
   * @param categoryName   The name of the Category.
   */
  Category(int categoryNumber, String categoryName) {
    this.categoryNumber = categoryNumber;
    this.categoryName = categoryName;
  }

  /**
   * Gets category number, that represents a category.
   *
   * @return category number
   */
  public int getCategoryNumber() {
    return categoryNumber;
  }

  /**
   * Gets category name.
   *
   * @return the string that represents category name.
   */
  public String getCategoryName() {
    return categoryName;
  }

  /**
   * Returns the Category constant associated with the given category number.
   *
   * @param categoryNumber The numerical value of the Category to look up.
   * @return Category constant associated with the given category number
     or null if no matching Category is found.
   */
  public static Category getCategory(int categoryNumber) {
    for (Category category : Category.values()) {
      if (categoryNumber == category.getCategoryNumber()) {
        return category;
      }
    }
    return null;
  }

  /**
   * Sets category number.
   *
   * @param categoryNumber the category number
   */
  private void setCategoryNumber(int categoryNumber) {
    this.categoryNumber = categoryNumber;
  }

  /**
   * Sets category name.
   *
   * @param categoryName the category name
   */
  private void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
}
