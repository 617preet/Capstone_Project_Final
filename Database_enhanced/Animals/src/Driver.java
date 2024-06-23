import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Driver {
    // Instance variables (if needed)
    private static ArrayList<Dog> dogList = new ArrayList<>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize lists from database
        initializeDogList();
        initializeMonkeyList();

        // Controls the menu traversal
        boolean acceptingInput = true;

        do {
            displayMenu();
            String option = scanner.nextLine().trim().toLowerCase();

            switch(option) {
                case "1":
                    // Input a new dog
                    intakeNewDog(scanner);
                    break;

                case "2":
                    // Input a new monkey
                    intakeNewMonkey(scanner);
                    break;

                case "3":
                    // Reserve an animal
                    reserveAnimal(scanner);
                    break;

                case "4":
                    // Print all dogs
                    printAllDogs();
                    break;

                case "5":
                    // Print all monkeys
                    printAllMonkeys();
                    break;

                case "6":
                    // Print all non-reserved animals
                    printAvailableAnimals();
                    break;

                case "q":
                    // Quit
                    acceptingInput = false;
                    break;

                default:
                    System.out.println("Invalid option, please input a valid option");
                    break;
            }
        } while(acceptingInput);

        System.out.println("Goodbye");
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    // Adds dogs to a list from database
    public static void initializeDogList() {
        // Fetch dogs from database and add to dogList
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DatabaseUtil.getConnection();
            String query = "SELECT * FROM Dog";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String breed = rs.getString("breed");
                String gender = rs.getString("gender");
                String age = rs.getString("age");
                String weight = rs.getString("weight");
                String acquisitionDate = rs.getString("acquisitionDate");
                String acquisitionCountry = rs.getString("acquisitionCountry");
                String trainingStatus = rs.getString("trainingStatus");
                boolean reserved = rs.getBoolean("reserved");
                String inServiceCountry = rs.getString("inServiceCountry");

                Dog dog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
                dogList.add(dog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.closeResources(conn, ps, rs);
        }
    }

    // Adds monkeys to a list from database
    public static void initializeMonkeyList() {
        // Fetch monkeys from database and add to monkeyList
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DatabaseUtil.getConnection();
            String query = "SELECT * FROM Monkey";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String species = rs.getString("species");
                String gender = rs.getString("gender");
                String age = rs.getString("age");
                String weight = rs.getString("weight");
                String height = rs.getString("height");
                String bodyLength = rs.getString("bodyLength");
                String tailLength = rs.getString("tailLength");
                String acquisitionDate = rs.getString("acquisitionDate");
                String acquisitionCountry = rs.getString("acquisitionCountry");
                String trainingStatus = rs.getString("trainingStatus");
                boolean reserved = rs.getBoolean("reserved");
                String inServiceCountry = rs.getString("inServiceCountry");

                Monkey monkey = new Monkey(name, species, gender, age, weight, height, bodyLength, tailLength, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
                monkeyList.add(monkey);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.closeResources(conn, ps, rs);
        }
    }

    // Adds a new dog to database and list
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine().trim();

        if (findDogByName(name) != null) {
            System.out.println("\n\nThis dog is already in our system\n\n");
            return;
        }

        System.out.println("What is " + name + "'s breed?");
        String breed = scanner.nextLine().trim();
        System.out.println("What is " + name + "'s gender? (\"male\", \"female\")");
        String gender = scanner.nextLine().trim().toLowerCase();
        System.out.println("What is " + name + "'s age?");
        String age = scanner.nextLine().trim();
        System.out.println("What is " + name + "'s weight? (in pounds)");
        String weight = scanner.nextLine().trim();
        System.out.println("When was " + name + "'s acquired? (MM-DD-YYYY)");
        String acquisitionDate = scanner.nextLine().trim();
        System.out.println("Where was " + name + "'s acquired? (Country)");
        String acquisitionCountry = scanner.nextLine().trim();
        System.out.println("What is " + name + "'s training status? (\"intake\", \"in service\", \"phase I/II/III/IV/V\", \"farm\")");
        String trainingStatus = scanner.nextLine().trim();
        System.out.println("Is " + name + " reserved? (Y/N)");
        boolean reserved = scanner.nextLine().trim().equalsIgnoreCase("Y");
        System.out.println("What is " + name + "'s service country?");
        String inServiceCountry = scanner.nextLine().trim();

        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        addDogToDatabase(newDog);
        dogList.add(newDog);
        System.out.println("Dog " + name + " added successfully.");
    }

    // Adds a new monkey to database and list
    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("What is the monkey's name?");
        String name = scanner.nextLine().trim();

        if (findMonkeyByName(name) != null) {
            System.out.println("\n\nThis monkey is already in our system\n\n");
            return;
        }

        System.out.println("What is " + name + "'s species?");
        String species = scanner.nextLine().trim();
        System.out.println("What is " + name + "'s gender? (\"male\", \"female\")");
        String gender = scanner.nextLine().trim().toLowerCase();
        System.out.println("What is " + name + "'s age?");
        String age = scanner.nextLine().trim();
        System.out.println("What is " + name + "'s weight? (in pounds)");
        String weight = scanner.nextLine().trim();
        System.out.println("What is " + name + "'s height? (head to toe; in inches)");
        String height = scanner.nextLine().trim();
        System.out.println("What is " + name + "'s body length? (head to pelvis; in inches)");
        String bodyLength = scanner.nextLine().trim();
        System.out.println("What is " + name + "'s tail length? (base to tip; in inches)");
        String tailLength = scanner.nextLine().trim();
        System.out.println("When was " + name + "'s acquired? (MM-DD-YYYY)");
        String acquisitionDate = scanner.nextLine().trim();
        System.out.println("Where was " + name + "'s acquired? (Country)");
        String acquisitionCountry = scanner.nextLine().trim();
        System.out.println("What is " + name + "'s training status? (\"intake\", \"in service\", \"phase I/II/III/IV/V\", \"farm\")");
        String trainingStatus = scanner.nextLine().trim();
        System.out.println("Is " + name + " reserved? (Y/N)");
        boolean reserved = scanner.nextLine().trim().equalsIgnoreCase("Y");
        System.out.println("What is " + name + "'s service country?");
        String inServiceCountry = scanner.nextLine().trim();

        Monkey newMonkey = new Monkey(name, species, gender, age, weight, height, bodyLength, tailLength, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        addMonkeyToDatabase(newMonkey);
        monkeyList.add(newMonkey);
        System.out.println("Monkey " + name + " added successfully.");
    }

 // Reserves an animal (by type and country)
    public static void reserveAnimal(Scanner scanner) {
        System.out.println("Enter animal type (dog/monkey):");
        String animalType = scanner.nextLine().trim().toLowerCase();

        if (!animalType.equals("dog") && !animalType.equals("monkey")) {
            System.out.println("Invalid animal type entered.");
            return;
        }

        System.out.println("Enter the name of the " + animalType + " you want to reserve:");
        String animalName = scanner.nextLine().trim();

        boolean animalFound = false;

        if (animalType.equals("dog")) {
            Dog dogToReserve = findDogByName(animalName);
            if (dogToReserve != null) {
                if (!dogToReserve.getReserved()) {
                    dogToReserve.setReserved(true);
                    updateDogReservationStatus(dogToReserve);
                    System.out.println("Reservation for dog " + animalName + " successful.");
                } else {
                    System.out.println("Dog " + animalName + " is already reserved.");
                }
                animalFound = true;
            }
        } else if (animalType.equals("monkey")) {
            Monkey monkeyToReserve = findMonkeyByName(animalName);
            if (monkeyToReserve != null) {
                if (!monkeyToReserve.getReserved()) {
                    monkeyToReserve.setReserved(true);
                    updateMonkeyReservationStatus(monkeyToReserve);
                    System.out.println("Reservation for monkey " + animalName + " successful.");
                } else {
                    System.out.println("Monkey " + animalName + " is already reserved.");
                }
                animalFound = true;
            }
        }

        if (!animalFound) {
            System.out.println("Animal " + animalName + " not found in the system.");
        }
    }
    
    // Helper method to find a dog by name using binary search
    public static Dog findDogByName(String name) {
        // Sort dogList by name using a case-insensitive comparator
        Collections.sort(dogList, Comparator.comparing(Dog::getName, String.CASE_INSENSITIVE_ORDER));
        
        // Perform binary search
        int index = binarySearch(dogList, name);
        
        // If index is valid, return the dog at that index; otherwise, return null
        if (index >= 0) {
            return dogList.get(index);
        }
        return null;
    }

    // Helper method to find a monkey by name using binary search
    public static Monkey findMonkeyByName(String name) {
        // Sort monkeyList by name using a case-insensitive comparator
        Collections.sort(monkeyList, Comparator.comparing(Monkey::getName, String.CASE_INSENSITIVE_ORDER));
        
        // Perform binary search
        int index = binarySearch(monkeyList, name);
        
        // If index is valid, return the monkey at that index; otherwise, return null
        if (index >= 0) {
            return monkeyList.get(index);
        }
        return null;
    }
    
    // Custom binary search method to find an element by name in a sorted list
    private static <T> int binarySearch(ArrayList<T> list, String name) {
    	// Starting index of the search range
    	int low = 0;        
    	 // Ending index of the search range
        int high = list.size() - 1;            

        // Continue searching while the search range is valid
        while (low <= high) {  
        	// Calculate the middle index
            int mid = (low + high) / 2;         
            // Get the name of the element at the middle index
            String midName = ((RescueAnimal) list.get(mid)).getName();  
            // Compare the middle name with the target name
            int cmp = midName.compareToIgnoreCase(name);

            if (cmp < 0) {
                // If the middle name is less than the target name lexicographically,
                // adjust the low index to search the upper half
                low = mid + 1;
            } else if (cmp > 0) {
                // If the middle name is greater than the target name lexicographically,
                // adjust the high index to search the lower half
                high = mid - 1;
            } else {
                // If cmp == 0, it means the middle name matches the target name,
                // so return the index of the element found
                return mid;
            }
        }

        // If the loop exits, the name was not found in the list, so return -1
        return -1;
    }

    // Updates dog's reservation status in the database
    public static void updateDogReservationStatus(Dog dog) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseUtil.getConnection();
            String query = "UPDATE Dog SET reserved = ? WHERE name = ?";
            ps = conn.prepareStatement(query);
            ps.setBoolean(1, dog.getReserved());
            ps.setString(2, dog.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.closeResources(conn, ps, null);
        }
    }

    // Updates monkey's reservation status in the database
    public static void updateMonkeyReservationStatus(Monkey monkey) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseUtil.getConnection();
            String query = "UPDATE Monkey SET reserved = ? WHERE name = ?";
            ps = conn.prepareStatement(query);
            ps.setBoolean(1, monkey.getReserved());
            ps.setString(2, monkey.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.closeResources(conn, ps, null);
        }
    }
    
    // Print all dogs
    public static void printAllDogs() {
        System.out.println("List of all dogs:");
        for (Dog dog : dogList) {
            System.out.println(dog.toString());
        }
    }
    
    // Print all monkeys 
    public static void printAllMonkeys() {
        System.out.println("List of all monkeys:");
        for (Monkey monkey : monkeyList) {
            System.out.println(monkey.toString());
        }
    }
    
    // Print all available animals
    public static void printAvailableAnimals() {
        System.out.println("List of all available animals:");
        System.out.println("Dogs:");
        for (Dog dog : dogList) {
            if (!dog.getReserved()) {
                System.out.println(dog.toString());
            }
        }
        System.out.println("Monkeys:");
        for (Monkey monkey : monkeyList) {
            if (!monkey.getReserved()) {
                System.out.println(monkey.toString());
            }
        }
    }
    
    
    // Adds a new Dog object to the Dog table in the database and updates the local list
    public static void addDogToDatabase(Dog newDog) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseUtil.getConnection();
            
            // SQL query to insert a new dog into the Dog table
            String query = "INSERT INTO Dog (name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            ps = conn.prepareStatement(query);
            
            // Set parameters for the prepared statement from the newDog object
            ps.setString(1, newDog.getName());
            ps.setString(2, newDog.getBreed());
            ps.setString(3, newDog.getGender());
            ps.setString(4, newDog.getAge());
            ps.setString(5, newDog.getWeight());
            ps.setString(6, newDog.getAcquisitionDate());
            ps.setString(7, newDog.getAcquisitionLocation());
            ps.setString(8, newDog.getTrainingStatus());
            ps.setBoolean(9, newDog.getReserved());
            ps.setString(10, newDog.getInServiceLocation());
            
            // Execute the SQL query to insert the new dog
            ps.executeUpdate();
            
            // Add the new dog to the list
            dogList.add(newDog);
            
            System.out.println("Dog " + newDog.getName() + " added to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in the finally block to ensure they are always closed
            DatabaseUtil.closeResources(conn, ps, null);
        }
    }
    
    // Adds a new Monkey object to the Monkey table in the database and updates the local list
    public static void addMonkeyToDatabase(Monkey newMonkey) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseUtil.getConnection();
            
            // SQL query to insert a new monkey into the Monkey table
            String query = "INSERT INTO Monkey (name, species, gender, age, weight, height, bodyLength, tailLength, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            ps = conn.prepareStatement(query);
            
            // Set parameters for the prepared statement from the newMonkey object
            ps.setString(1, newMonkey.getName());
            ps.setString(2, newMonkey.getSpecies());
            ps.setString(3, newMonkey.getGender());
            ps.setString(4, newMonkey.getAge());
            ps.setString(5, newMonkey.getWeight());
            ps.setString(6, newMonkey.getHeight());
            ps.setString(7, newMonkey.getBodyLength());
            ps.setString(8, newMonkey.getTailLength());
            ps.setString(9, newMonkey.getAcquisitionDate());
            ps.setString(10, newMonkey.getAcquisitionLocation());
            ps.setString(11, newMonkey.getTrainingStatus());
            ps.setBoolean(12, newMonkey.getReserved());
            ps.setString(13, newMonkey.getInServiceLocation());
            
            // Execute the SQL query to insert the new monkey
            ps.executeUpdate();
            
            // Add the new monkey to the list
            monkeyList.add(newMonkey);
            
            System.out.println("Monkey " + newMonkey.getName() + " added to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in the finally block to ensure they are always closed
            DatabaseUtil.closeResources(conn, ps, null);
        }
    }
    
    // Checks if a specific animal (Dog or Monkey) with the given name is reserved.
    public static boolean isReserved(String animalName, String animalType) {
        if (animalType.equalsIgnoreCase("dog")) {
            // Find the dog in the dogList by name
            Dog dog = findDogByName(animalName);
            return dog != null && dog.getReserved(); // Return true if dog exists and is reserved
        } else if (animalType.equalsIgnoreCase("monkey")) {
            // Find the monkey in the monkeyList by name
            Monkey monkey = findMonkeyByName(animalName);
            return monkey != null && monkey.getReserved(); // Return true if monkey exists and is reserved
        } else {
            System.out.println("Invalid animal type entered.");
            return false;
        }
    }
}
