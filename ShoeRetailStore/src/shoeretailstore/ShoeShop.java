/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoeretailstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoeShop {
    private String name;
    private ShoeInventory inventory;
    private List<Customer> customers;
    private Scanner scanner;

    public ShoeShop(String name) {
        this.name = name;
        this.inventory = new ShoeInventory();
        this.customers = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
     //setters and getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShoeInventory getInventory() {
        return inventory;
    }

    public void setInventory(ShoeInventory inventory) {
        this.inventory = inventory;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
     
    public void addShoeToInventory(String brand, String model, int size, double price) {
    if (isValidShoeData(brand, model, size, price)) {
        Shoe shoe = new Shoe(brand, model, size, price);
        inventory.addShoe(shoe);
        System.out.println(brand + " " + model + " added to " + name + "'s inventory.");
    } else {
        System.out.println("Invalid shoe data. The shoe was not added to the inventory.");
    }
}

private boolean isValidShoeData(String brand, String model, int size, double price) {
    //  data validation 
    if (brand.isEmpty() || model.isEmpty() || size <= 0 || price <= 0) {
        return false;
    }
    return true;
}

    public void removeShoeFromInventory(String brand) {
        Shoe shoeToRemove = inventory.findShoeByBrand(brand);
        if (shoeToRemove != null) {
            inventory.removeShoe(shoeToRemove);
            System.out.println(brand + " removed from " + name + "'s inventory.");
        } else {
            System.out.println("Shoe with brand '" + brand + "' not found in the inventory.");
        }
    }

    public void displayShopInventory() {
        System.out.println(name + "'s Inventory:");
        inventory.displayInventory();
    }

    public void addCustomer() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();
        Customer customer = new Customer(name, email);
        customers.add(customer);
        System.out.println("Customer " + name + " added.");
    }

    public Customer findCustomerByName(String name) {
         for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

    public void createOrder() {
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        Customer customer = findCustomerByName(customerName);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.println("Available Shoes:");
        inventory.displayInventory();

        Order order = new Order(customer);
        String addShoeBrand;
        while (true) {
            System.out.print("Enter shoe brand to add to the order (or 'done' to finish): ");
            addShoeBrand = scanner.nextLine();
            if (addShoeBrand.equalsIgnoreCase("done")) {
                break;
            }
            Shoe shoe = inventory.findShoeByBrand(addShoeBrand);
            if (shoe != null) {
                order.addShoeToOrder(shoe);
                System.out.println(addShoeBrand + " added to the order.");
            } else {
                System.out.println("Shoe not found.");
            }
        }

        customer.addOrder(order);
        System.out.println("Order for " + customerName + " created.");
    }
}
