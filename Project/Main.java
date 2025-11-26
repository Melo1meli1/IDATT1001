package Project;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
* Class represents the user interface.
*/
public class Main {
  /**
   * Constants that each represents actions for the main menu.
   */
  private static final int REGISTER_NEW_ITEM = 1;
  private static final int SEARCH_FOR_ITEM = 2;
  private static final int CHANGE_ITEM = 3;
  private static final int DISPLAY_NUMBER_OF_ARTICLES = 4;
  private static final int DISPLAY_ALL_ITEMS = 5;
  private static final int TOTAL_VALUE_IN_STOCK = 6;
  private static final int DELETE_ITEM = 7;
  private static final int EXIT = 8;

  /**
   * An often used string defined as a constant.
   */
  private static final String CONFIRMATION = "Changes been registered";
  /**
   * A boolean that represents the on/off button for the program.
   */
  private static boolean button = true;
  /**
   * Two seperate scanners to take in user input, for each their datatype.
   */
  private static Scanner intInput = new Scanner(System.in);
  private static Scanner strInput = new Scanner(System.in);
  /**
   * Initiates a new list of items, that represents the register/storage.
   */
  private static final List<Item> itemList = new ArrayList<>();
  /**
   * Initiates the class ItemRegister into this class.
   */
  private static final ItemRegister register = new ItemRegister(itemList);

  /**
   * The actual program that represents a Warehouse Management System.
   */
  public static void main(String[] args) {
    testData();
    runMenu();
    intInput.close();
    strInput.close();
  }

  /**
   * Runs menu.
   */
  private static void runMenu() {
    try {
      while (button) {

        switch (showMainMenu()) {
          case REGISTER_NEW_ITEM -> registerNewItem();
          case SEARCH_FOR_ITEM -> System.out.println(searchForItem());
          case CHANGE_ITEM -> changeItem(searchForItem());
          case DISPLAY_NUMBER_OF_ARTICLES -> totDiffArticles();
          case DISPLAY_ALL_ITEMS -> displayAllItems();
          case TOTAL_VALUE_IN_STOCK -> totalValueInStock();
          case DELETE_ITEM -> deleteItem(searchForItem());
          case EXIT -> exit();
          default -> System.out.println("Invalid input. Please type a number between 1 and 7.");
        }
      }
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage());
      runMenu();
    } catch (InputMismatchException e) {
      System.err.println("invalid input for this field");
      intInput.nextLine();
      runMenu();
    }
  }

  /**
   * Hardcoded data that is to represent items in
   * a register, mainly for the purpose of testing.
   */
  private static void testData() {
    register.registerNewItem("B.202", "Fixed frame windows 1 section, 3 panes", "KLAR",
        """
            A unique window for a unique house, produced in Denmark and Sweden from manufacturers
            such as IPA and ASSA ABLOY (RUKO). The window has aluminum glass strips all the way
            around the glass, free extra protection that extends life and hides nail holes with
            a nice finish. The window is CE marked and has a street resistance of 10 years.
            The paint used is child-friendly without dangerous toxins, and is produced with
            the Furniture Saonara Robot. The quality of our robot is
            without comparison, and is a good reason to choose KLAR windows.""",
        1207, 45, 2, 10, 8.3, 60, 40, "Egg white");

    register.registerNewItem("B.408", "Yolo Jeff", "Helena", """
            Jeff is the newest type of window technology. With enforced frames made of
            titanium and glass that has been tempered in the depth of the Analogous
            volcano, this window is to be considered unbreakable.""",
        1999, 40, 2, 56, 78, 201.2, 100, "red");


    register.registerNewItem("C.202", "Double outer door with 2 glass panes", "KLAR",
        """
            Door frame of slow-growing Estonian pine, with high quality. Grip, lock, valves,
            wind brake is Manufactured in Denmark and Sweden from manufacturers such as IPA
            and ASSA ABLOY (RUKO). The door comes with grey hinges, a 3-point locking box
            and aluminum glass strips all the way around the glass""",
        18798, 20, 3, 178, 481, 120, 175, "Cream White");

    register.registerNewItem("Y.202", "Swedoor Pulse Outer door", "Tore Ligaard",
        """
            Modern front door with a great design that makes the entrance area stand out.
            The glass that is completely free of edging on both sides of the door, and the
            integrated (hidden) hinges underlines the door's clean lines. Solid
            construction provides increased security because the door has high
            security against burglary attempts.""",
        26986, 0, 3, 243, 120, 90, 210, "Black");

    register.registerNewItem("C.208", "Cladding spruce 19x148 rectangular", "XL-BYGG",
        """
            Clothing - rectangular 1. Black spruce 19x148 mm - primed + intermediate coat jotun 1453
            cotton Straight, simple and usable cladding with a rough front and grooved edges. Also
            known as lumberjack cladding. Classic Style. Primed with Jotun Industri Opaque primer
            and intermediate coat with Jotun Industri Drygolin Color expert in the color Jotun
            1453 cotton NCS S 0502 Y. NB! Can stand up to 3 years before further treatment.""",
        440, 0, 4, 4000, 2, 20, 200, "White");

    register.registerNewItem("J.222", "SWEDOOR INTERIOR DOOR, 4 MIRRORS", "Tore Ligaard",
        """
            Style 04N is a lightly molded inner door with four mirrors and a classic design.
            A functional door solution that meets your basic needs and fits the decor of most
            homes. All style 04 door leaves can be supplied as double and sliding doors.
            Supplied without frame.""",
        1141, 10, 3, 455, 4.7, 62.5, 194, "Beige");

    register.registerNewItem("P.942", "Opus laminate 1-stick natural oak", "IKEA",
        """
            The floor looks like real oak, and achieves extra dynamism thanks to longitudinal
            cracks like giving an authentic finish to the interior. The laminate floor is
            practical, has good quality and easy to care for. Equipped with anti-static
            properties reduces electrical charges to a minimum. The wide floor board gives 
            the floor a very elegant appearance. The authentic wooden floor effect is 
            perfectly highlighted thanks to a V-bevel. The laminate floor variant is suitable 
            for all private living areas, as well as for commercial room exposed to normal use.""",
        2000, 40, 1, 10, 8.3, 1.8, 1, "White");

    register.registerNewItem("A.778", "Window", "IKEA",
        """
            Beautiful white window from IKEA, is both the cheapest
            and best quality window on the marked according to no one in 2022.""",
        2000, 40, 2, 10, 8.3, 1.8, 1, "White");
  }

  /**
   * Displays main menu by print function.
   *
   * @holds menu choice
   */
  private static int showMainMenu() {
    System.out.println("""
                        
        What do you wish to do?
        1. Register new item
        2. Search for item
        3. Change item
        4. Display number of articles
        5. Display all items
        6. View total value in stock
        7. Delete item
        8. Exit
        """);
    int choice = intInput.nextInt();
    return choice;
  }

  /**
   * Registeres new item.
   */
  private static void registerNewItem() {
    System.out.println("Item number (EG. X.000) :");
    final String itemNum = strInput.nextLine();

    System.out.println("Item name:");
    final String itemName = strInput.nextLine();

    System.out.println("Brand:");
    final String brand = strInput.nextLine();

    System.out.println("Description:");
    final String description = strInput.nextLine();

    System.out.println("Price (as integer) :");
    final int price = intInput.nextInt();

    System.out.println("Discount as a positive integer :");
    final int discount = intInput.nextInt();

    System.out.println("""
        Category:
        1. Door
        2. Floor laminate
        3. Lumber
        4. Windows""");

    final int category = intInput.nextInt();

    System.out.println("Left in stock:");
    final int leftInStock = intInput.nextInt();

    System.out.println("Weight:");
    final double weight = intInput.nextDouble();

    System.out.println("Length:");
    final double length = intInput.nextDouble();

    System.out.println("Height");
    final double height = intInput.nextDouble();

    System.out.println("Color:");
    String color = strInput.nextLine();

    register.registerNewItem(itemNum, itemName, brand, description, price, discount,
        category, leftInStock, weight, length, height, color);
    System.out.println(CONFIRMATION);
  }

  /**
   * Searches for an item.
   *
   * @holds the value of the item found in search.
   */
  private static Item searchForItem() {
    String wantedItemMessage = "Type in the itemnumber of your wanted item.";

    System.out.println(""" 
                
        How do you wish to find your item?
        1. Item number
        2. Item name
        3. Category
        4. Description
        5. Within price range
        """);
    int choice = intInput.nextInt();

    switch (choice) {
      case 1 -> {
        System.out.println("Type in the item number");
        String itemNumber = strInput.nextLine();
        return register.findItemByNumber(itemNumber);
      }
      case 2 -> {
        System.out.println("Type in the item name");
        String itemName = strInput.nextLine();
        System.out.println(register.sortByItemName(register.findItemByName(itemName)));

        System.out.println(wantedItemMessage);
        String itemNumber = strInput.nextLine();
        return register.findItemByNumber(itemNumber);
      }
      case 3 -> {
        displayCategoryMenu();
        System.out.println("Type in the item category number (1 - 4)");
        int categoryNum = intInput.nextInt();
        System.out.println(register.sortByCategoryName(register.findItemByCategory(categoryNum)));

        System.out.println(wantedItemMessage);
        String itemNumber = strInput.nextLine();
        return register.findItemByNumber(itemNumber);
      }
      case 4 -> {
        System.out.println("Type in some keywords");
        String keyWords = strInput.nextLine();
        System.out.println(register.listToString(register.findItemsByDescription(keyWords)));

        System.out.println("""
            - If you could not find your item, the description does not contain your keywords.
            - Type 'BACK' if you wish to search for you item by something else.
            - Else, if you found the wanted item, """ + wantedItemMessage);
        String itemNumber = strInput.nextLine();
        if (itemNumber.equals("BACK")) {
          System.out.println("You have returned to the main menu.");
        }
        return register.findItemByNumber(itemNumber);
      }
      case 5 -> {
        System.out.println("Minimum price (Integer) :");
        int minPrice = intInput.nextInt();
        System.out.println("Maximum price (Integer) :");
        int maxPrice = intInput.nextInt();
        System.out.println(register.listToString(
            register.sortByPrice(register.findItemInPriceRange(minPrice, maxPrice))));

        System.out.println(wantedItemMessage);
        String itemNumber = strInput.nextLine();
        return register.findItemByNumber(itemNumber);
      }
      default -> throw new IllegalArgumentException("Make sure to choose a number between 1 - 4");
    }
  }

  /**
   * Displays menu of possible changes to an item
   * in a menu, that later changes the chosen value.
   *
   * @param item the item that is to be changes
   */
  private static void changeItem(Item item) {
    System.out.println("""
        What do you wish to change with this item?
        1. Stock
        2. Price
        3. Discount
        4. Description
        5. Brand
        6. Item name
        7. Item number""");
    int choice = intInput.nextInt();

    switch (choice) {
      case 1 -> changeStock(item);
      case 2 -> changePrice(item);
      case 3 -> changeDiscount(item);
      case 4 -> changeDescription(item);
      case 5 -> changeBrand(item);
      case 6 -> changeItemName(item);
      case 7 -> changeItemNumber(item);
      default -> System.err.println("Choice must be in between 1 and 7.");
    }
  }

  /**
   * Displays menu of possible ways to
   * change the stock of an item in a menu, that
   * later changes the number of items in stock.
   * Changes the number of items in stock
   *
   * @param item the item that is to be changed
   */
  private static void changeStock(Item item) {
    System.out.println("""
        Choose an action :
        1. Increase
        2. Decrease
        3. Set new""");
    int choice = intInput.nextInt();

    switch (choice) {
      case 1 -> {
        System.out.println("How much do you want to increase the stock?");
        int stockIncrease = intInput.nextInt();
        register.increaseInStock(item, stockIncrease);
        System.out.println("Action successful");
        System.out.println("Item : " + item.getItemNumber()
            + " -> " + "In stock : " + item.getLeftInStock());
      }
      case 2 -> {
        System.out.println("How much do you want to decrease the stock?");
        int stockDecrease = intInput.nextInt();
        register.decreaseInStock(item, stockDecrease);
        System.out.println("Action successful");
      }
      case 3 -> {
        System.out.println("Current amount in stock : " + item.getLeftInStock());
        System.out.println("Type in the wanted amount in stock.");
        int newStock = intInput.nextInt();
        register.setStock(item, newStock);
        System.out.println(CONFIRMATION);
      }
      default -> {
        System.out.println("Please pick a number between 1 - 3.");
      }
    }
  }

  /**
   * Changes the price of an item, after displaying the current price.
   *
   * @param item the item that is to be designated a new value for price
   */
  private static void changePrice(Item item) {
    System.out.println("The current price of this item is : " + item.getPrice());
    System.out.println("What do you want to change the price to? (whole numbers only!)");
    int priceChoice = intInput.nextInt();

    register.changePrice(item.getItemNumber(), priceChoice);
    System.out.println(CONFIRMATION);
  }

  /**
   * Displays current discount, then
   * changes the discount of the chosen item.
   *
   * @param item item that is to be changed.
   */
  private static void changeDiscount(Item item) {
    if (item.getDiscount() == 0) {
      System.out.println("This item has no previous discount");
    } else if (item.getDiscount() > 0) {
      System.out.println("Current discount : " + item.getDiscount());
      System.out.println("Type in the desired discount in percentage (%)");
      int newDiscount = intInput.nextInt();

      register.changeDiscount(item.getItemNumber(), newDiscount);
      System.out.println(CONFIRMATION);
    }
  }

  /**
   * Displays current description of the chosen item
   * and changes the description of an item.
   *
   * @param item item that is to be changed
   */
  private static void changeDescription(Item item) {
    System.out.println("Current description" + item.getDescription());
    System.out.println("Type the new description : ");
    String newDescription = strInput.nextLine();

    register.changeDescription(item.getItemNumber(), newDescription);
    System.out.println(CONFIRMATION);
  }

  /**
   * Displays current brand of the chosen item,
   * then changes the brand of that item.
   *
   * @param item item that is to be changed.
   */
  private static void changeBrand(Item item) {
    System.out.println("Current brand : " + item.getBrand());
    System.out.println("New brand : ");
    String newBrand = strInput.nextLine();

    register.changeBrand(item.getItemNumber(), newBrand);
    System.out.println(CONFIRMATION);
  }

  /**
   * Displays the current name for the chosen item,
   * then changes the name of that item.
   *
   * @param item item that is to be changed.
   */
  private static void changeItemName(Item item) {
    System.out.println("Current item name : " + item.getItemName());
    System.out.println("New item name");
    String newItemName = strInput.nextLine();

    register.changeItemName(item.getItemNumber(), newItemName);
    System.out.println(CONFIRMATION);
  }

  /**
   * Displays number of the current name of the chosen item,
   * then changes the number of that item.
   *
   * @param item item that is to be changed.
   */
  private static void changeItemNumber(Item item) {
    System.out.println("Current item number : " + item.getItemNumber());
    System.out.println("New item number : ");
    String newItemNumber = strInput.nextLine();

    register.changeNumber(item.getItemNumber(), newItemNumber);
    System.out.println(CONFIRMATION);
  }

  /**
   * Displayes a number that represents the
   * number of different articles/items in storage.
   */
  private static void totDiffArticles() {
    System.out.println("Number of different articles in storage : " + register.numDifferentItems());
  }

  /**
   * Displays a menu asking how or if you want
   * to display all items in the register, and
   * then precives to displaying the items in
   * a suited manner to the answer.
   */
  private static void displayAllItems() {
    System.out.println("""
        Do you wish for the list to be sorted?
        1. By item number
        2. By item name
        3. By category
        4. By price
        5. No
        """);
    int choice = intInput.nextInt();

    switch (choice) {
      case 1 -> System.out.println(register.listToString(
          register.sortByItemNumber(register.displayAllItems())));

      case 2 -> System.out.println(register.listToString(
          register.sortByItemName(register.displayAllItems())));

      case 3 -> System.out.println(register.listToString(
          register.sortByCategoryName(register.displayAllItems())));

      case 4 -> System.out.println(register.listToString(
          register.sortByPrice(register.displayAllItems())));

      case 5 -> register.displayAllItems().forEach(System.out::println);
      default -> throw new IllegalStateException("Unexpected value: " + choice);
    }
  }

  /**
   * Displays an integer value that
   * represents the total currency value
   * off all the items in stock/register.
   */
  private static void totalValueInStock() {
    System.out.println("Total value in stock : "
        + register.totalValueInStock(register.displayAllItems()));
  }

  /**
   * Displays a message to weather the user is
   * sure about the choice of deleting the chosen
   * item, then proceeds to the chosen action.
   *
   * @param item the item that is to be chosen.
   */
  private static void deleteItem(Item item) {
    System.out.println("""
        Are you sure you want to delete this item?
        Yes -> Type : Gyh57T
        No -> Type : NO""");
    String confirmDelete = strInput.nextLine();

    if (confirmDelete.equals("Gyh57T")) {
      register.deleteItem(item);
      System.out.println(CONFIRMATION);
    } else if (confirmDelete.equals("NO")) {
      System.out.println("Item has not been deleted");
    }
  }

  /**
   * Changes the boolean value named "button"
   * to false then exits the program.
   */
  private static void exit() {
    button = false;
    System.out.println("You have now exited the program");
  }

  /**
   * Displayes all categories from enum
   * class with number and name of the category.
   */
  private static void displayCategoryMenu() {
    for (int i = 1; i <= Category.values().length; i++) {
      System.out.println(i + " : " + Category.getCategory(i).getCategoryName());
    }
  }
}



