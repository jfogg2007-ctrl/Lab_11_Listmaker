import java.util.ArrayList;
import java.util.Scanner;

public class Lab_11_Listmaker {

    private static ArrayList<String> list = new ArrayList<>();
    private static boolean needsSaving = false;


    private static final String INPUT_PROMPT = "Enter your choice [A, D, I, P, Q]: ";

    public static void main(String[] args) {
        String menuChoice = "";
        final String MENU_REGEX = "[AaDdIiPpQq]";

        System.out.println("Welcome to the Simple List Maker!");

        do {
            displayList();
            System.out.println("\n--- Menu Options ---");
            System.out.println("A - Add an item");
            System.out.println("D - Delete an item");
            System.out.println("I - Insert an item");
            System.out.println("P - Print (Display) the list");
            System.out.println("Q - Quit the program");
            System.out.println("--------------------");

            menuChoice = SafeInput.getRegExString(System.in, INPUT_PROMPT, MENU_REGEX);
            menuChoice = menuChoice.toUpperCase();

            switch (menuChoice) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":

                    System.out.println("List display refreshed.");
                    break;
                case "Q":
                    quitProgram();
                    break;
                default:
                    System.out.println("Invalid menu choice. Please try again.");
                    break;
            }

            System.out.println("\n--- Press Enter to Continue ---");
            new Scanner(System.in).nextLine();

        } while (!menuChoice.equals("Q"));


    }


    private static void displayList() {
        if (list.isEmpty()) {
            System.out.println("\n*** The list is currently EMPTY ***");
        } else {
            System.out.println("\n*** Current List ***");
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%3d. %s\n", i + 1, list.get(i));
            }
            System.out.println("********************");
        }
    }


    private static void addItem() {
        String item = SafeInput.getString(System.in, "Enter the item to add: ");
        list.add(item);
        needsSaving = true;
        System.out.println("Item added successfully to the end of the list.");
    }


    private static void deleteItem() {
        if (list.isEmpty()) {
            System.out.println("Cannot delete: The list is empty.");
            return;
        }

        displayList();

        int indexToDelete = SafeInput.getRangedInt(
                System.in,
                "Enter the item number to delete [1-" + list.size() + "]: ",
                1,
                list.size()
        );

        String removedItem = list.remove(indexToDelete - 1);
        needsSaving = true;
        System.out.println("🗑️ Successfully deleted item " + indexToDelete + ": " + removedItem);
    }


    private static void insertItem() {
        int maxInsertIndex = list.size() + 1;

        int indexToInsert = SafeInput.getRangedInt(
                System.in,
                "Enter the location number to insert at [1-" + maxInsertIndex + "]: ",
                1,
                maxInsertIndex
        );

        String item = SafeInput.getString(System.in, "Enter the item to insert: ");

        list.add(indexToInsert - 1, item);
        needsSaving = true;
        System.out.println("➕ Item inserted successfully at position " + indexToInsert);
    }

    private static void quitProgram() {
        boolean confirmed = SafeInput.getYNConfirm(System.in, "Are you sure you want to quit? (Y/N): ");

        if (confirmed) {
            System.out.println("Program terminated. Goodbye!");
            System.exit(0);
        } else {
            System.out.println("Quit cancelled. Returning to the main menu.");
        }
    }
}