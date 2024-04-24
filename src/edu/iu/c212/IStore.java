package edu.iu.c212;

import edu.iu.c212.models.Item;
import edu.iu.c212.models.Staff;

import java.io.IOException;
import java.util.List;

public interface IStore {
    List<Item> getItemsFromFile() throws IOException;
    List<Staff> getStaffFromFile() throws IOException;
    void saveItemsToFile(List<Item> items) throws IOException;
    void saveStaffToFile(List<Staff> staff) throws IOException;
    void takeAction() throws IOException;  // Process commands from the input file
}
