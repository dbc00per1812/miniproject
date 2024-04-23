package edu.iu.c212.utils;

import edu.iu.c212.models.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.List;

public class FileUtils {
    private static File inputFile = new File("../resources/input.txt");
    private static File outputFile = new File("../resources/output.txt");
    private static File inventoryFile = new File("../resources/inventory.txt");
    private static File staffFile = new File("../resources/staff.txt");
    private static File staffAvailabilityFile = new File("../resources/staff_availability_IN.txt");
    private static File shiftSchedulesFile = new File("../resources/shift_schedules_IN.txt");
    private static File storeScheduleFile = new File("../resources/store_schedule_OUT.txt");

    public static List<Item> readInventoryFromFile() throws IOException {
        System.out.println(inventoryFile/*.toURI()*/.getPath() + "\n" + inventoryFile.exists());
        // depending on your OS, toURI() may need to be used when working with paths
        // TODO
        List<Item> itemList = new ArrayList<>();
        try (Scanner scanner = new Scanner(inventoryFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Item item = parseItem(line);
                itemList.add(item);
            }
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
        return itemList;
    }


    public List<Staff> readStaffFromFile() throws IOException {
        // TODO
        List<Staff> staffList = new ArrayList<>();
        try (Scanner scanner = new Scanner(staffFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Staff staff = parseStaff(line);
                staffList.add(staff);
            }
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
        return staffList;
    }

    public void writeInventoryToFile(List<Item> items) {
        // TODO

    }

    public void writeStaffToFile(List<Staff> employees) {
        // TODO
    }

    public static List<String> readCommandsFromFile() throws IOException {
        // TODO
        List<String> commands = new ArrayList<>();
        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine();
                commands.add(command);
            }
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
        return commands;
    }

    public static void writeStoreScheduleToFile(List<String> lines) {
        // TODO
    }

    public static void writeLineToOutputFile(String line) {
        // TODO
    }

    private static Item parseItem(String s) {
        String[] line = s.split(",");
        String name = line[0].trim();
        int cost = Integer.parseInt(line[1].trim());
        int quantity = Integer.parseInt(line[2].trim());
        int aisle = Integer.parseInt(line[3].trim());
        return new Item(name, cost, quantity, aisle);
    }

    private static Staff parseStaff(String s) {
        String[] line = s.split(",");
        String name = line[0].trim();
        int age = Integer.parseInt(line[1].trim());
        String role = line[2].trim();
        String availability = line[3].trim();
        return new Staff(name, age, role, availability);
    }

}
