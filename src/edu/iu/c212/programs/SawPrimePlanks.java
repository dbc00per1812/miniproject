package edu.iu.c212.programs;

import edu.iu.c212.models.Item;
import edu.iu.c212.utils.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SawPrimePlanks {

    public static void main(String[] args) {
        try {
            List<Item> inventory = FileUtils.readInventoryFromFile();
            List<Item> updatedInventory = performSawingOnInventory(inventory);
            FileUtils.writeInventoryToFile(updatedInventory);
        } catch (IOException e) {
            System.err.println("Error processing inventory for sawing planks: " + e.getMessage());
        }
    }

    private static List<Item> performSawingOnInventory(List<Item> inventory) {
        List<Item> updatedInventory = new ArrayList<>(inventory);
        List<Item> sawedPlanks = new ArrayList<>();

        for (Item item : inventory) {
            if (item.getName().contains("Plank") && !isPrime(item.getQuantity())) {
                List<Integer> sawedPlanksLengths = getPlankLengths(item.getQuantity());
                for (Integer length : sawedPlanksLengths) {
                    String newName = "Plank-" + length;
                    double newPrice = Math.pow(length, 2);
                    sawedPlanks.add(new Item(newName, newPrice, 1, item.getAisle()));
                }
                updatedInventory.remove(item); // Remove the original long plank from inventory
            }
        }

        updatedInventory.addAll(sawedPlanks); // Add all sawed planks to the inventory
        return updatedInventory;
    }

    public static List<Integer> getPlankLengths(int longPlankLength) {
        List<Integer> primePlanks = new ArrayList<>();
        sawPlank(longPlankLength, primePlanks);
        return primePlanks;
    }

    private static void sawPlank(int plankLength, List<Integer> primePlanks) {
        if (isPrime(plankLength)) {
            primePlanks.add(plankLength);
            return;
        }

        for (int divisor = 2; divisor <= plankLength / 2; divisor++) {
            if (plankLength % divisor == 0 && isPrime(divisor)) {
                int newLength = plankLength / divisor;
                for (int i = 0; i < divisor; i++) {
                    sawPlank(newLength, primePlanks);
                }
                break;
            }
        }
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
