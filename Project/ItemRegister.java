package Project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Class that represents a register and the values and methods associated with it.
 */
public class ItemRegister {
  private List<Item> items;

  /**
   * Creates a new item register with the given list of items.
   *
   * @param item the list of items to initialize the item register with
   */
  public ItemRegister(List<Item> item) {
    this.items = item;
  }

  /**
   * Registers a new item with the following values.
   *
   * @param itemNumber  the item number of the new item
   * @param itemName    the name of the new item
   * @param brand       the brand of the new item
   * @param description a description of the new item
   * @param price       the price of the new item
   * @param discount    the discount applied to the new item
   * @param category    the category of the new item
   * @param inStock     the number of units of the new item in stock
   * @param weight      the weight of the new item
   * @param length      the length of the new item
   * @param height      the height of the new item
   * @param color       the color of the new item
   * @throws IllegalArgumentException if an item with the given item number already exists
   **/
  public void registerNewItem(String itemNumber, String itemName, String brand, String description,
                              int price, int discount, int category, int inStock,
                              double weight, double length, double height, String color) {

    Item newItem = new Item(itemNumber, itemName, brand, description, price, discount,
        category, inStock, weight, length, height, color);

    for (Item item : items) {
      if (item.getItemNumber().equals(newItem.getItemNumber())) {
        throw new IllegalArgumentException("An item with that number already exists.");
      }
    }
    items.add(newItem);
  }

  /**
   * Returns the number of different items in the list/register.
   *
   * @return the number of different items in the register/storage
   * @throws IllegalArgumentException if the number of items exceeds the allowed limit
   */
  public int numDifferentItems() {
    int itemLimit = 6000;
    if (items.size() > itemLimit) {
      throw new IllegalArgumentException("""
          You have exceeded the allowed amount of items in your warehouse.
          If you want to add more items, you have to remove an item.""");
    }
    return deepCopyListOfItems(items).size();
  }

  /**
   * Deletes the given item from the list/register.
   *
   * @param item the item to delete
   */
  public void deleteItem(Item item) {
    items.removeIf(i -> i.getItemNumber().equals(item.getItemNumber()));
  }

  /**
   * Returns a list of all the items in the register.
   *
   * @return a list of all the items in the register.
   */
  public List<Item> displayAllItems() {
    return deepCopyListOfItems(items);
  }

  /**
   * Returns a list of words that represent a paragraph.
   *
   * @param text the string to split into words
   * @return a list of words in the given string
   */
  public List<String> splitText(String text) {
    String regex = "([^a-zA-ZÆæØøÅå']+)'*\\1*";
    String[] splitText = text.split(regex);
    return List.of(splitText);
  }

  /**
   * Returns the total value of the items in the given list, as a currency.
   *
   * @param list the list of items to calculate the total value of
   * @return the total value of items in the given list
   */
  public int totalValueInStock(List<Item> list) {
    int sumPrices = 0;

    for (Item item : list) {
      int priceX = item.getPrice();
      sumPrices += priceX;
    }
    return sumPrices;
  }

  /**
   * Returns a string representation of the given list.
   *
   * @param listInput the list to convert to a string
   * @return a string representation of the given list
   */
  public StringBuilder listToString(List listInput) {
    StringBuilder str = new StringBuilder();

    for (Object o : listInput) {
      str.append(o.toString()).append("\n");
    }
    return str;
  }

  /**
   * Returns a deep copy of the given list of items.
   *
   * @param listToCopy the list of items to copy
   * @return a deep copy of the given list of items
   */
  private List<Item> deepCopyListOfItems(List<Item> listToCopy) {
    ArrayList<Item> deepCopy = new ArrayList<>();
    for (Item i : listToCopy) {
      deepCopy.add(new Item(i));
    }
    return deepCopy;
  }

  /**
   * Returns the item matching the given item number.
   *
   * @param itemNumber item number to search for
   * @return the item matching the given item number
   * @throws IllegalArgumentException if the item number is blank or no match is found
   */
  public Item findItemByNumber(String itemNumber) {
    if (itemNumber.isBlank()) {
      throw new IllegalArgumentException("Item number can not be blank");
    }
    for (Item item : items) {
      if (item.getItemNumber().equals(itemNumber)) {
        return new Item(item);
      }
    }
    throw new IllegalArgumentException("Item does not exist, or item number may be wrong.");
  }

  /**
   * Private method that returns the original item matching the given item number.
   *
   * @param itemNumber the item number to search for
   * @return the item matching the given item number
   * @throws IllegalArgumentException if the item number is blank or no match is found
   */
  private Item findItemByNumberOrg(String itemNumber) {   //BEDRE NAVN
    if (itemNumber.isBlank()) {
      throw new IllegalArgumentException("Item number can not be blank");
    }
    Item item = items.stream()
        .filter(item1 -> itemNumber.equals(item1.getItemNumber()))
        .findAny()
        .orElse(null);
    if (item == null) {
      throw new IllegalArgumentException("Item does not exist, or item number may be wrong.");
    }
    return item;
  }

  /**
   * Returns a list of items that match the given item name.
   *
   * @param itemName item name to search for
   * @return a list of items matching the given item name
   * @throws IllegalArgumentException if the item name is empty or no matches are found
   */
  public List<Item> findItemByName(String itemName) {
    List<Item> itemsNames = new ArrayList<>();
    if (itemName.isEmpty()) {
      throw new IllegalArgumentException("Item name can not be blank/empty");
    }
    for (Item item : items) {
      if (itemName.equalsIgnoreCase(item.getItemName())) {
        itemsNames.add(item);
      }
    }
    if (itemsNames.isEmpty()) {
      throw new IllegalArgumentException("Item with item name "
          + itemName + " does not exist, or is wrong");
    }
    return deepCopyListOfItems(itemsNames);
  }

  /**
   * Returns a list of items that match the given category number.
   *
   * @param category category number to search for
   * @return a list of items matching the given category number
   * @throws IllegalArgumentException if the category number is invalid or no matches are found
   */
  public List<Item> findItemByCategory(int category) {
    List<Item> itemsCategories = new ArrayList<>();
    if (category < 0 || category > Category.values().length) {
      throw new IllegalArgumentException("Category has to be between 1 and 4.");
    }
    for (Item item : items) {
      if (category == item.getCategoryNumber()) {
        itemsCategories.add(item);
      }
    }
    if (itemsCategories.isEmpty()) {
      throw new IllegalArgumentException("No matches found for your category");
    }
    return deepCopyListOfItems(itemsCategories);
  }

  /**
   * Finds items within a given price range.
   *
   * @param lowerLimit the lower limit of the price range (inclusive)
   * @param upperLimit the upper limit of the price range (inclusive)
   * @return a list of items within the specified price range, sorted by price
   */
  public List<Item> findItemInPriceRange(int lowerLimit, int upperLimit) {
    List<Item> itemsPriceRange = new ArrayList<>();
    if (lowerLimit < 0 || upperLimit < 0) {
      throw new IllegalArgumentException("Both upper and lower limit cannot be less than zero.");
    }
    for (Item item : items) {
      if (item.getPrice() >= lowerLimit && item.getPrice() <= upperLimit) {
        itemsPriceRange.add(item);
      }
    }
    if (itemsPriceRange.size() <= 0) {
      throw new IllegalArgumentException("No items were found in that price range");
    }
    return deepCopyListOfItems(itemsPriceRange);
  }

  /**
   * Searches for items with descriptions containing the
   * given keywords, and returns a list of matching items.
   *
   * @param keyWordSearch A string containing the keywords to search for in the items' descriptions.
   * @return A list of items with descriptions containing one or more of the given keywords.
   * @throws IllegalArgumentException if the given string is blank, or if no matches are found.
   */
  public List<Item> findItemsByDescription(String keyWordSearch) {
    ArrayList<Item> itemsDesMatch = new ArrayList<>();
    Collection<String> keyWords = splitText(keyWordSearch.toUpperCase());

    if (keyWordSearch.isBlank()) {
      throw new IllegalArgumentException("Description can not be blank");
    }

    for (Item item : items) {
      Collection<String> itemDescriptions = splitText(item.getDescription().toUpperCase());

      Collection<String> hashKeyWordList = new HashSet<>(keyWords);
      hashKeyWordList.retainAll(itemDescriptions);

      int matches = hashKeyWordList.size();

      if (matches > 0) {
        itemsDesMatch.add(item);
      }
    }
    if (itemsDesMatch.isEmpty()) {
      throw new IllegalArgumentException("No match/es found for your search");
    }
    return deepCopyListOfItems(itemsDesMatch);
  }

  /**
   * Sorts the given list of items by their item number in ascending order.
   *
   * @param list list of items to sort.
   * @return sorted list of items.
   */
  public List<Item> sortByItemNumber(List list) {
    list.sort(Comparator.comparing(Item::getItemNumber));
    return list;
  }

  /**
   * Sorts the given list of items by their name in ascending order.
   *
   * @param list list of items to sort.
   * @return sorted list of items.
   */
  public List<Item> sortByItemName(List list) {
    list.sort(Comparator.comparing(Item::getItemName));
    return list;
  }

  /**
   * Sorts the given list of items by their category name in ascending order.
   *
   * @param list list of items to sort.
   * @return The sorted list of items.
   * @throws IllegalArgumentException if the list is empty.
   */
  public List<Item> sortByCategoryName(List list) {
    if (list.isEmpty()) {
      throw new IllegalArgumentException("There is no item in that given category");
    }
    list.sort(Comparator.comparing(Item::getCategoryName));
    return deepCopyListOfItems(list);
  }

  /**
   * Sorts the given list of items by their discounted price in ascending order.
   *
   * @param list The list of items to sort.
   * @return The sorted list of items.
   */
  public List<Item> sortByPrice(List list) {
    list.sort(Comparator.comparing(Item::getDiscountedPrice));
    return list;
  }

  /**
   * Changes the description of the item with the given number to the new description.
   *
   * @param itemNumber     The number of the item to update.
   * @param newDescription The new description for the item.
   * @throws IllegalArgumentException if the new description is blank.
   */
  public void changeDescription(String itemNumber, String newDescription) {
    Item item = findItemByNumberOrg(itemNumber);
    item.setDescription(newDescription);
  }

  /**
   * Changes the name of the item with the given number to the new name.
   *
   * @param itemNumber  The number of the item to update.
   * @param newItemName The new name for the item.
   * @throws IllegalArgumentException if the new item name is blank.
   */
  public void changeItemName(String itemNumber, String newItemName) {
    Item item = findItemByNumberOrg(itemNumber);
    item.setItemName(newItemName);
  }

  /**
   * Changes the discount of the item with the given number to the new discount.
   *
   * @param itemNumber  The number of the item to update.
   * @param newDiscount The new discount for the item.
   * @throws IllegalArgumentException if the new discount is less than zero or greater than 100.
   */
  public void changeDiscount(String itemNumber, int newDiscount) {
    Item item = findItemByNumberOrg(itemNumber);
    item.setDiscount(newDiscount);
  }

  /**
   * Changes the brand of the item with the given number to the new brand.
   *
   * @param itemNumber The number of the item to update.
   * @param newBrand   The new brand for the item.
   * @throws IllegalArgumentException if the new brand is blank.
   */
  public void changeBrand(String itemNumber, String newBrand) {
    Item item = findItemByNumberOrg(itemNumber);
    item.setBrand(newBrand);
  }

  /**
   * Changes the number of the item with the given new number.
   *
   * @param itemNumber    The current number of the item to update.
   * @param newItemNumber The new number for the item.
   * @throws IllegalArgumentException if the new item number is invalid.
   */
  public void changeNumber(String itemNumber, String newItemNumber) {
    Item item = findItemByNumberOrg(itemNumber);
    item.setItemNumber(newItemNumber);
  }

  /**
   * Changes the price of the item with the given number for new price.
   *
   * @param itemNumber The number of the item to update.
   * @param newPrice   The new price for the item.
   */
  public void changePrice(String itemNumber, int newPrice) {
    Item item = findItemByNumberOrg(itemNumber);
    item.setPrice(newPrice);
  }

  /**
   * Increases the number of units of the given item in stock by the given amount.
   *
   * @param item     The item to update.
   * @param increase The number of units to increase the stock by.
   * @throws IllegalArgumentException if the given amount is less than or equal to zero.
   */
  public void increaseInStock(Item item, int increase) {
    if (increase <= 0) {
      throw new IllegalArgumentException("The increase can not be less or equal to zero");
    }
    item.setLeftInStock(item.getLeftInStock() + increase);
  }

  /**
   * Decreases the number of units of the given item in stock by the given amount.
   *
   * @param item     The item to update.
   * @param decrease The number of units to decrease the stock by.
   * @throws IllegalArgumentException if the resulting stock size would be less than zero.
   */
  public void decreaseInStock(Item item, int decrease) {
    int newStock = item.getLeftInStock() - decrease;
    if (newStock < 0) {
      throw new IllegalArgumentException("Stock can not be less than 0");
    }
    item.setLeftInStock(item.getLeftInStock() - decrease);
  }

  /**
   * Sets the number of units of the given item in stock.
   *
   * @param item     The item to update.
   * @param newStock The new number of units in stock.
   * @throws IllegalArgumentException if the new stock size is less than zero.
   */
  public void setStock(Item item, int newStock) {
    if (newStock < 0) {
      throw new IllegalArgumentException("Stock size can not be less than zero.");
    }
    item.setLeftInStock(newStock);
  }
}







