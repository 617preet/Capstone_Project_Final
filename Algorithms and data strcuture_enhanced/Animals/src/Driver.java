import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Driver {
    // Instance variables
    private static ArrayList<Dog> dogList = new ArrayList<>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<>();

    public static void main(String[] args) {
        initializeDogList();
        initializeMonkeyList();

        // Sort the lists by name for binary search
        Collections.sort(dogList, Comparator.comparing(Dog::getName));
        Collections.sort(monkeyList, Comparator.comparing(Monkey::getName));

        // Controls the menu traversal
        boolean acceptingInput = true;
        Scanner input = new Scanner(System.in);

        do {
            displayMenu();
            String option = input.nextLine().trim().toLowerCase();

            switch (option) {
                case "1":
                    // Input a new dog
                    intakeNewDog(input);
                    break;
                case "2":
                    // Input a new monkey
                    intakeNewMonkey(input);
                    break;
                case "3":
                    // Reserve an animal
                    reserveAnimal(input);
                    break;
                case "4":
                    // Print all of the dogs
                    printAnimals("dog");
                    break;
                case "5":
                    // Print all of the monkeys
                    printAnimals("monkey");
                    break;
                case "6":
                    // Print all non-reserved animals
                    printAnimals("available");
                    break;
                case "q":
                    // Quit
                    acceptingInput = false;
                    break;
                default:
                    System.out.println("Invalid option, please input a valid option");
                    break;
            }
        } while (acceptingInput);

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

    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    // Adds monkeys to a list for testing (optional)
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Cappy", "Capuchin", "male", "1", "5.6", "15", "10", "5", "05-21-2021", "United States", "intake", false, "United States");
        Monkey monkey2 = new Monkey("Max", "Macaque", "male", "3", "15.2", "63", "53", "10", "02-29-2002", "United States", "Phase I", false, "United States");
        Monkey monkey3 = new Monkey("Tammy", "Tamarin", "female", "4", "1.6", "9", "1", "0.6", "12-21-2012", "Canada", "in service", false, "Canada");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
    }

    // Adds a new dog to `dogList`
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine().trim();

        // Ensure the dog isn't a duplicate
        if (findDogByName(name) != null) {
            System.out.println("\n\nThis dog is already in our system\n\n");
            return;
        }

        // Gather information about the new dog
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

        // Create a new dog and add it to the list
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        dogList.add(newDog);
        Collections.sort(dogList, Comparator.comparing(Dog::getName));
    }

    // Adds a new monkey to `monkeyList`
    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("What is the monkey's name?");
        String name = scanner.nextLine().trim();

        // Ensure the monkey isn't a duplicate
        if (findMonkeyByName(name) != null) {
            System.out.println("\n\nThis monkey is already in our system\n\n");
            return;
        }

        // Gather information about the new monkey
        System.out.println("What is " + name + "'s species?");
        String species = scanner.nextLine().trim();

        System.out.println("What is " + name + "'s gender? (\"male\", \"female\")");
        String gender = scanner.nextLine().trim().toLowerCase();

        System.out.println("What is " + name + "'s age?");
        String age = scanner.nextLine().trim();

        System.out.println("What is " + name + "'s weight? (in pounds)");
        String weight = scanner.nextLine().trim();

        System.out.println("What is " + name + "'s height? (inches)");
        String height = scanner.nextLine().trim();

        System.out.println("What is " + name + "'s body length? (inches)");
        String bodyLength = scanner.nextLine().trim();

        System.out.println("What is " + name + "'s tail length? (inches)");
        String tailLength = scanner.nextLine().trim();

        System.out.println("When was " + name + " acquired? (MM-DD-YYYY)");
        String acquisitionDate = scanner.nextLine().trim();

        System.out.println("Where was " + name + " acquired? (Country)");
        String acquisitionCountry = scanner.nextLine().trim();

        System.out.println("What is " + name + "'s training status? (\"intake\", \"in service\", \"phase I/II/III/IV/V\", \"farm\")");
        String trainingStatus = scanner.nextLine().trim();

        System.out.println("Is " + name + " reserved? (Y/N)");
        boolean reserved = scanner.nextLine().trim().equalsIgnoreCase("Y");

        System.out.println("What is " + name + "'s service country?");
        String inServiceCountry = scanner.nextLine().trim();

        // Create a new monkey and add it to the list
        Monkey newMonkey = new Monkey(name, species, gender, age, weight, height, bodyLength, tailLength, acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry);
        monkeyList.add(newMonkey);
        Collections.sort(monkeyList, Comparator.comparing(Monkey::getName));
    }

    // Reserves an animal based on user input
    public static void reserveAnimal(Scanner scanner) {
        System.out.println("Enter animal type (\"dog\" or \"monkey\"):");
        String animalType = scanner.nextLine().trim().toLowerCase();

        System.out.println("Enter " + animalType + "'s name:");
        String name = scanner.nextLine().trim();

        // Reserve the animal if it exists
        if (animalType.equals("dog")) {
            Dog dog = findDogByName(name);
            if (dog != null) {
                if (!dog.getReserved()) {
                    dog.setReserved(true);
                    System.out.println(name + " is now reserved.");
                } else {
                    System.out.println(name + " is already reserved.");
                }
            } else {
                System.out.println("Dog not found.");
            }
        } else if (animalType.equals("monkey")) {
            Monkey monkey = findMonkeyByName(name);
            if (monkey != null) {
                if (!monkey.getReserved()) {
                    monkey.setReserved(true);
                    System.out.println(name + " is now reserved.");
                } else {
                    System.out.println(name + " is already reserved.");
                }
            } else {
                System.out.println("Monkey not found.");
            }
        } else {
            System.out.println("Invalid animal type.");
        }
    }

    // Prints animals based on user input
    public static void printAnimals(String animalType) {
        if (animalType.equals("dog")) {
            System.out.println("List of dogs:");
            for (Dog dog : dogList) {
                System.out.println(dog.getName());
            }
        } else if (animalType.equals("monkey")) {
            System.out.println("List of monkeys:");
            for (Monkey monkey : monkeyList) {
                System.out.println(monkey.getName());
            }
        } else if (animalType.equals("available")) {
            System.out.println("List of available dogs:");
            for (Dog dog : dogList) {
                if (!dog.getReserved()) {
                    System.out.println(dog.getName());
                }
            }
            System.out.println("List of available monkeys:");
            for (Monkey monkey : monkeyList) {
                if (!monkey.getReserved()) {
                    System.out.println(monkey.getName());
                }
            }
        } else {
            System.out.println("Invalid animal type.");
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
}
