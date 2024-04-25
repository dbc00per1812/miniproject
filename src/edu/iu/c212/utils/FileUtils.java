package edu.iu.c212.utils;

import edu.iu.c212.models.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileUtils {
    private static File inputFile = new File("../resources/input.txt");
    private static File outputFile = new File("../resources/output.txt");
    private static File inventoryFile = new File("../resources/inventory.txt");
    private static File staffFile = new File("../resources/staff.txt");
    private static File staffAvailabilityFile = new File("src/edu/iu/c212/resources/staff_availability_IN.txt");
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

    public static List<Staff> readStaffFromFile() throws IOException {
        // TODO
        List<Staff> staffList = new ArrayList<>();
        try (Scanner scanner = new Scanner(staffAvailabilityFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Staff staff = parseStaff(line);
                staffList.add(staff);
            }
        } catch (IOException e) {
            System.err.println("Failed to read from file: " + e.getMessage());
            throw e;
        }
        return staffList;
    }

    public static Map<String, String> readShiftSchedulesFromFile() throws IOException {
        // TODO
        Map<String, String> shifts = new LinkedHashMap<String, String>();
        try (Scanner scanner = new Scanner(shiftSchedulesFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                shifts.put(words[0], words[1] + " " + words[2]);
            }
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
        return shifts;
    }

    public static void writeInventoryToFile(List<Item> items) {
        // TODO
        try{
            FileWriter writer = new FileWriter(inventoryFile.getPath());

            for(Item i : items)
            {
                writer.write(i.toString());
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void writeStaffToFile(List<Staff> employees) {
        // TODO
        try{
            FileWriter writer = new FileWriter(staffFile.getPath());

            for(Staff s : employees)
            {
                writer.write(s.toString());
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        try{
            FileWriter writer = new FileWriter(outputFile.getPath());
            writer.write(line);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        String[] line = s.split(" ");
        String name = line[0].trim();
        int age = Integer.parseInt(line[1].trim());
        String role = line[2].trim();
        String availability = line[3].trim();
        return new Staff(name, age, role, availability);
    }

}
