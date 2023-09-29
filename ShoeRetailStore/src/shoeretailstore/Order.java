/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoeretailstore;

 import java.util.ArrayList;
 import java.util.List;

 public class Order {
     private List<Shoe> purchasedShoes;
     private Customer customer;

     public Order(Customer customer) {
        this.customer = customer;
        this.purchasedShoes = new ArrayList<>();
    }

      public void addShoeToOrder(Shoe shoe) {
        purchasedShoes.add(shoe);
    }

      public void displayOrder() {
        System.out.println("Order for " + customer.getName() + " (" + customer.getEmail() + "):");
        for (Shoe shoe : purchasedShoes) {
            shoe.display();
        }
    }
}
