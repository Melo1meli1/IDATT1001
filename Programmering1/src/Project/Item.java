package Project;

/**
 * Class that represents an item and the values and methods associated with it.
 */
public class Item {
  private final int category;
  private int inStock;
  private int price;
  private int discount;
  private final double weight;
  private final double length;
  private final double height;
  private final String color;
  private String itemName;
  private String itemNumber;
  private String brand;
  private String description;

  /**
   * Deep copy constructor that instantiates a new Item,
   * that is a copy of the original item. .
   *
   * @param item original item
   */
  public Item(Item item) {
    this(item.getItemNumber(), item.getItemName(), item.getBrand(), item.getDescription(),
        item.getPrice(), item.getDiscount(), item.getCategoryNumber(), item.getLeftInStock(),
        item.getWeight(), item.getLength(), item.getHeight(), item.getColor());
  }

  /**
   * Constructs a new `Item` object with the given properties.
   *
   * @param itemNumber number.
   * @param itemName name.
   * @param brand brand.
   * @param description description.
   * @param price price.
   * @param discount discount
   * @param category category.
   * @param inStock The number of items in stock.
   * @param weight weight.
   * @param length length.
   * @param height height.
   * @param color color.
   *
   * @throws IllegalArgumentException if any of the input parameters are invalid.
   */
  public Item(String itemNumber, String itemName, String brand, String description,
              int price, int discount, int category, int inStock,
              double weight, double length, double height, String color) {

    if (itemNumber.length() != 5) {
      throw new IllegalArgumentException("Item number does not contain the right amount of digits");
    }
    if (category < 1 || category > Category.values().length) {
      throw new IllegalArgumentException("Category has to be between 1 and 4.");
    }
    if (weight <= 0 || length <= 0 || height <= 0) {
      throw new IllegalArgumentException("Input can not be negative or zero.");
    }
    if (itemName.isBlank() || brand.isBlank() || description.isBlank() || color.isBlank()) {
      throw new IllegalArgumentException("Name, brand, description and color, cannot be blank.");
    }
    if (discount < 0 || discount > 100) {
      throw new IllegalArgumentException("""
          Discount can not be less than zero, or greater than 100,
          and should not contain any symbols or letters""");
    }
    if (price < 0) {
      throw new IllegalArgumentException("Price can not be negative");
    }

    this.category = category;
    setLeftInStock(inStock);
    this.price = price;
    this.discount = discount;

    this.weight = weight;
    this.length = length;
    this.height = height;

    this.itemName = itemName;
    this.itemNumber = itemNumber;
    this.description = description;
    this.brand = brand;
    this.color = color;
  }

  /**
   * Sets the name of an item.
   *
   * @param itemName The item's name.
   * @throws IllegalArgumentException if the item name is blank.
   */
  public void setItemName(String itemName) {
    if (itemName.isBlank()) {
      throw new IllegalArgumentException("Item name can not be blank.");
    }
    this.itemName = itemName;
  }

  /**
   * Sets the number of an item.
   *
   * @param itemNumber The item's number.
   * @throws IllegalArgumentException if the item number is
     anything else but five digits long, or blank.
   */
  public void setItemNumber(String itemNumber) {
    if (itemNumber.length() != 5 || itemNumber.isBlank()) {
      throw new IllegalArgumentException("Item number has to contain "
          + itemNumber.length() + " digits.");
    }
    this.itemNumber = itemNumber;
  }

  /**
   * Sets the price of an item.
   *
   * @param price The item's price.
   * @throws IllegalArgumentException if the price is negative.
   */
  public void setPrice(int price) {
    if (price < 0) {
      throw new IllegalArgumentException("Price can not be less than zero.");
    }
    this.price = price;
  }

  /**
   * Sets the number of items in stock.
   *
   * @param inStock The number of items in stock.
   * @throws IllegalArgumentException if the number of items in stock is negative.
   */
  public void setLeftInStock(int inStock) {
    if (inStock < 0) {
      throw new IllegalArgumentException("Invalid stock size");
    }
    this.inStock = inStock;
  }

  /**
   * Sets the description of an item.
   *
   * @param description The item's description.
   * @throws IllegalArgumentException if the description is blank.
   */
  public void setDescription(String description) {
    if (description.isBlank()) {
      throw new IllegalArgumentException("Description can not be blank");
    }
    this.description = description;
  }

  /**
   * Sets the brand of an item.
   *
   * @param brand The item's brand.
   * @throws IllegalArgumentException if the brand is blank.
   */
  public void setBrand(String brand) {
    if (brand.isBlank()) {
      throw new IllegalArgumentException("Brand can not be blank");
    }
    this.brand = brand;
  }

  /**
   * Sets the discount of an item as an int that symbolises percentage.
   *
   * @param discount discount
   * @throws IllegalArgumentException if the discount is less than zero or greater than 100.
   */
  public void setDiscount(int discount) {
    if (discount < 0 || discount > 100) {
      throw new IllegalArgumentException("Discount can not be less than zero, or greater than 100");
    }
    this.discount = discount;
  }

  /**
   * Returns the number of the category from the Category Enum class to which an item belongs.
   *
   * @return The number of the item's category.
   */
  public int getCategoryNumber() {
    return category;
  }

  /**
   * Gets the category from the Category Enum class to which an item belongs.
   *
   * @return The item's category.
   */
  public Category getCategoryEnum() {
    return Category.getCategory(category);
  }

  /**
   * Gets the category name from the Category Enum class to which an item belongs.
   *
   * @return The name of the item's category as string.
   */
  public String getCategoryName() {
    return getCategoryEnum().getCategoryName();
  }

  /**
   * Gets the price of an item.
   *
   * @return price of that item
   */
  public int getPrice() {
    return price;
  }

  /**
   * Gets amount of items left in stock.
   *
   * @return items left in stock
   */
  public int getLeftInStock() {
    return inStock;
  }

  /**
   * Gets the weight of an item.
   *
   * @return The item's weight.
   */
  public double getWeight() {
    return weight;
  }

  /**
   * Gets the length of an item.
   *
   * @return The item's length.
   */
  public double getLength() {
    return length;
  }

  /**
   * Gets the height of an item.
   *
   * @return The item's height.
   */
  public double getHeight() {
    return height;
  }

  /**
   * Gets the name of an item.
   *
   * @return The item's name.
   */
  public String getItemName() {
    return itemName;
  }

  /**
   * Gets the item number of an item.
   *
   * @return The item's number.
   */
  public String getItemNumber() {
    return itemNumber;
  }

  /**
   * Gets the description of an item.
   *
   * @return The item's description.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the brand of an item.
   *
   * @return The item's brand.
   */
  public String getBrand() {
    return brand;
  }

  /**
   * Gets the color of an item.
   *
   * @return The item's color.
   */
  public String getColor() {
    return color;
  }

  /**
   * Gets the discount of an item as an int that represents a percentage.
   *
   * @return discount
   */
  public int getDiscount() {
    return discount;
  }

  /**
   * Calculates and gets the discounted price of an item.
   *
   * @return The discounted price, rounded to the nearest integer.
   */
  public int getDiscountedPrice() {
    double discountedPrice = price * (1 - (discount / 100.0));
    return (int) Math.round(discountedPrice);
  }

  /**
   * Method that overrides the toString, in two cases.
   * The first contains all variables except discount.
   * The second contains all the variables in addition to discountedPrice.
   *
   * @return Item as string in one of two ways.
   */
  @Override
  public String toString() {
    if (discount == 0) {
      return " Item name : " + itemName
          + "\n ItemNumber : " + itemNumber
          + "\n Category : " + getCategoryEnum().getCategoryName()
          + "\n In stock : " + inStock + " units"
          + "\n Price : " + price + " €"
          + "\n Description : " + description
          + "\n Weight : " + weight + " kg"
          + "\n Length : " + length + " cm"
          + "\n Height : " + height + " cm"
          + "\n Brand : " + brand
          + "\n Color : " + color
          + "\n ";
    } else {
      return " Item name : " + itemName
          + "\n ItemNumber : " + itemNumber
          + "\n Category : " + getCategoryEnum().getCategoryName()
          + "\n In stock : " + inStock + " units"
          + "\n Original price : " + price + " €"
          + "\n Discounted price : " + getDiscountedPrice() + " €"
          + "\n Discount : " + discount + " %"
          + "\n Description : " + description
          + "\n Weight : " + weight + " kg"
          + "\n Length : " + length + " cm"
          + "\n Height : " + height + " cm"
          + "\n Brand : " + brand
          + "\n Color : " + color
          + "\n ";
    }
  }
}




