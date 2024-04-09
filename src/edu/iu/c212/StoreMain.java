public class StoreMain {
    public static void main(String[] args) {
        try {
            Store store = new Store(); // Create a new Store instance, which initiates the loading and command processing
            System.out.println("Store management system has finished processing. Please check the output files for results.");
        } catch (Exception e) {
            System.err.println("An error occurred during the store management process: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
