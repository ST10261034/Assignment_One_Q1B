/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shoeretailstore;
import java.util.Scanner;

public class ShoeRetailStore {
    public static void main(String[] args) {
        ShoeShop myShop = new ShoeShop("Shoe Store");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPlease choose one the follwoing:");
            System.out.println("1. Add Shoe to Inventory");
            System.out.println("2. Remove Shoe from Inventory");
            System.out.println("3. Display Shop Inventory");
            System.out.println("4. Add Customer");
            System.out.println("5. Create Order");
            System.out.println("6. Exit");
           

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Enter model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter size: ");
                    int size = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    myShop.addShoeToInventory(brand, model, size, price);
                    break;
                case 2:
                    System.out.print("Enter the brand of the shoe to remove: ");
                    String brandToRemove = scanner.nextLine();
                    myShop.removeShoeFromInventory(brandToRemove);
                    break;
                case 3:
                    myShop.displayShopInventory();
                    break;
                case 4:
                    myShop.addCustomer();
                    break;
                case 5:
                    myShop.createOrder();
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
