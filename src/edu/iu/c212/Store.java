package edu.iu.c212;

import edu.iu.c212.models.Item;
import edu.iu.c212.models.Staff;
import edu.iu.c212.utils.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Store implements IStore {
    private List<Item> items;
    private List<Staff> staff;

    public Store() throws IOException {
        items = getItemsFromFile();
        staff = getStaffFromFile();
        takeAction();
    }

    @Override
    public List<Item> getItemsFromFile() throws IOException {
        return FileUtils.readInventoryFromFile();
    }

    @Override
    public List<Staff> getStaffFromFile() throws IOException {
        return FileUtils.readStaffFromFile();
    }

    @Override
    public void saveItemsToFile(List<Item> items) throws IOException {
        FileUtils.writeInventoryToFile(items);
    }

    @Override
    public void saveStaffToFile(List<Staff> staff) throws IOException {
        // Implement the method to save staff details back to the file, if needed
    }

    @Override
    public void takeAction() throws IOException {
        // Read commands from the input file using FileUtils
        List<String> commands = FileUtils.readCommandsFromFile();

        for (String commandLine : commands) {
            // Parse the commandLine and execute the corresponding action
            // For example, if the command is ADD, find the item details and add to the inventory
            // Update the inventory or staff list as necessary and write back to the files
            String[] words = commandLine.split(" ");
            switch(words[0]){
                case "ADD":
                {
                    List<Item> list = new ArrayList<Item>();
                    Item item = new Item(words[1], Double.parseDouble(words[2]), Integer.parseInt(words[3]), Integer.parseInt(words[4]));
                    list.add(item);
                    saveItemsToFile(list);
                }
                case "COST":
                {
                    List<Item> items = getItemsFromFile();
                    for(Item i : items) {
                        if(i.getName() == words[1])
                            FileUtils.writeLineToOutputFile(i.getName().replace("'", "") + ": $" + i.getPrice());
                    }
                }
                case "EXIT":
                    FileUtils.writeLineToOutputFile("Thank you for visiting High’s Hardware and Gardening!");
                    System.out.println("Press enter to continue...");
                case "FIND":
                {
                    List<Item> items = getItemsFromFile();
                    for(Item i : items) {
                        if(i.getName() == words[1])
                            FileUtils.writeLineToOutputFile(i.getQuantity() + " " + i.getName() + " are available in " + i.getAisle()); break;
                    }
                }
                case "FIRE":
                    System.out.println("testingn");
                case "HIRE":
                    System.out.println("testingn");
                case "PROMOTE":
                    System.out.println("testingn");
                case "SAW":
                    System.out.println("testingn");
                case "SCHEDULE":
                    System.out.println("testingn");
                case "SELL":
                    System.out.println("testingn");
                case "QUANTITY":
                    System.out.println("testingn");
                default:
                    System.out.println("Invalid command: " + words[0]);

            }
        }

        // After processing all commands, write the final state back to files
        saveItemsToFile(items);
        // Optionally save staff, if staff details are modified
    }
}

