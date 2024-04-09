import edu.iu.c212.models.Item;
import edu.iu.c212.models.Staff;
import edu.iu.c212.utils.FileUtils;

import java.io.IOException;
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
        }

        // After processing all commands, write the final state back to files
        saveItemsToFile(items);
        // Optionally save staff, if staff details are modified
    }
}

