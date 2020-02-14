import java.util.Scanner;

/**
 * Driver used to test Soda class for Project 2, CISY 254 Data Structures
 *
 * @author Sohan Patel
 */
public class SohanPatelProject2 {

    public static void main(String[] args) {
        //sodaBag stores, updates, and Links all objects given by user
        LinkedBag<Soda> sodaBag = new LinkedBag<Soda>();

        Scanner input = new Scanner(System.in);
        String userChoice;
        //userName will store user's input for soda's name
        String userName;

        //userPrice will store user's input for soda's price
        double userPrice;

        //userSodaCalories  will store user's input for soda's calories
        int userSodaCalories;
        do {
            // display menu
            System.out.println("\nBag of Sodas");
            System.out.println("\nA - Add 'Soda' to bag");
            System.out.println("R - Remove 'Soda' from Bag");
            System.out.println("F - Find 'Soda' from Bag");
            System.out.println("D - Display 'Soda' from Bag");
            System.out.println("X - Exit\n");
            System.out.println(" ");
            System.out.print("Enter selection: ");
             input.reset();
            userChoice = input.nextLine();

           //Exit closes Menu 
            if (userChoice.equalsIgnoreCase("X")
                    || userChoice.equalsIgnoreCase("x")
                    || userChoice.equalsIgnoreCase("Exit")) {
                System.out.println("\nBye!\n");
            } 
            //Invalid Selction Checker, prints message for invalid menu user inputs
 else if (userChoice.equalsIgnoreCase("A")) {
                System.out.print("Enter name of Soda to add to bag: ");
                 input.reset();
                userName = input.nextLine();
                System.out.print("Enter price of Soda to add to bag: ");
                userPrice = input.nextDouble();
                System.out.print("Enter calories of Soda to add to bag: ");
                userSodaCalories = input.nextInt();
                sodaBag.add(new Soda(userName, userPrice, userSodaCalories));
                System.out.println("");
                displayLinkedBagSoda(sodaBag);
            }
            
            //Remove soda object from sodaBag from user input 
            else if (userChoice.equalsIgnoreCase("R")) {
                System.out.print("Enter name of Soda to remove to bag: ");
                 input.reset();
                userName = input.nextLine();

                System.out.print("Enter price of Soda to remove to bag: ");
                userPrice = input.nextDouble();
                System.out.print("Enter calories of Soda to remove to bag: ");
                userSodaCalories = input.nextInt();

                if (sodaBag.remove(new Soda(userName, userPrice, userSodaCalories))) {
                    System.out.print("Was able to remove " + " from Bag of Soda.");
                } else {
                    System.out.print("Sorry! unable to remove " + " from Bag of Soda!");
                }
                System.out.println("");
                displayLinkedBagSoda(sodaBag);
               

            }
            
            //Finds Soda Object in sodabag from user input 
            else if (userChoice.equalsIgnoreCase("F")) {
                System.out.print("Enter name of Soda to find to bag: ");
                 input.reset();
                userName = input.nextLine();

                System.out.print("Enter price of Soda to find to bag: ");
                userPrice = input.nextDouble();
                System.out.print("Enter calories of Soda to find to bag: ");
                userSodaCalories = input.nextInt();

                if (sodaBag.exists(new Soda(userName, userPrice, userSodaCalories))) {
                    System.out.print(userName + " with " + userSodaCalories + " calories" + " @ $" + userPrice + " is in Bag of Soda.");
                } else {
                    System.out.print(userName + " with " + userSodaCalories + " calories" + " @ $" + userPrice + " is not in Bag of Soda.");
                }

            }
            //Display prints sodaBag and size of SodaBag(number of objects in the bag)
            else if (userChoice.equalsIgnoreCase("D")) {
                System.out.print("Soda Bag: ");
                displayLinkedBagSoda(sodaBag);
                 displaySize(sodaBag);
                System.out.println("");
            }
            //Invalid Selction Checker, prints message for invalid menu user inputs
            else{
                System.out.println("\nInvalid Selction");
            }
        } while (!(userChoice.equalsIgnoreCase("X")
                || userChoice.equalsIgnoreCase("x")
                || userChoice.equalsIgnoreCase("Exit")));
    
    }
/**
     * displaySize method displays Soda objects from a LinkedBag<Soda> size
     * @param bagToDisplay the LinkedBag<Soda> to display
     */
    public static void displaySize(LinkedBag bagToDisplay) {
        System.out.print(" \tSize: " + bagToDisplay.getSize());
    }
    
 /**
     * displayLinkedBagSoda method displays Soda objects from a LinkedBag<Soda>
     * using an iterator
     * @param bagToDisplay the LinkedBag<Soda> to display
     */
    public static void displayLinkedBagSoda(LinkedBag<Soda> bagToDisplay) {

        if (bagToDisplay.getSize() == 0) {
            System.out.println("--Empty--");
        }
        Lister<Soda> sodaList = bagToDisplay.iterator();
        while (sodaList.hasNext()) {
            Soda displaySoda = sodaList.next();
            System.out.print("{" + displaySoda.getSodaName() + " " + displaySoda.getSodaPrice() + " " + displaySoda.getSodaCalories() + "}");
            if (sodaList.hasNext()) {
                System.out.print(", ");
            }
        }
    }
 /**
     * makeStringOfSoda method makes a String from a Soda
     * @param sodaToConvert is the soda to be made into a String
     * return a String representation of a Soda
     */
    public static String makeStringOfSoda(Soda sodaToConvert) {
        return "[Soda " + sodaToConvert.getSodaName() + " " + sodaToConvert.getSodaPrice() + " " + sodaToConvert.getSodaCalories() + "]";
    }
}
