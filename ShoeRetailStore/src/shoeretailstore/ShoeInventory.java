/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoeretailstore;

import java.util.ArrayList;
import java.util.List;

public class ShoeInventory {
    private List<Shoe> inventory;

    public ShoeInventory() {
        inventory = new ArrayList<>();
    }

    public void addShoe(Shoe shoe) {
        inventory.add(shoe);
    }

    public void removeShoe(Shoe shoe) {
        inventory.remove(shoe);
    }

    public List<Shoe> getInventory() {
        return inventory;
    }

    public Shoe findShoeByBrand(String brand) {
        for (Shoe shoe : inventory) {
            if (shoe.getBrand().equalsIgnoreCase(brand)) {
                return shoe;
            }
        }
        return null;
    }

    public double calculateInventoryValue() {
        double totalValue = 0;
        for (Shoe shoe : inventory) {
            totalValue += shoe.getPrice();
        }
        return totalValue;
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (Shoe shoe : inventory) {
            shoe.display();
        }
    }
}
