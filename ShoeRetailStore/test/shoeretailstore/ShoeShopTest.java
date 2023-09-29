/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package shoeretailstore;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ameer
 */
public class ShoeShopTest {
    
    public ShoeShopTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Start test");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Testing complete");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testAddShoeToInventory() {
        ShoeShop myShop = new ShoeShop("My Shoe Store");
        myShop.addShoeToInventory("Nike", "Air Max", 10, 129.99);
        ShoeInventory inventory = myShop.getInventory();

        // Test if the shoe was added to the inventory
        assertEquals(1, inventory.getInventory().size());
    }
    
    @Test
    public void testAddInvalidShoeToInventory() {
        ShoeShop myShop = new ShoeShop("My Shoe Store");
        
        // Attempt to add a shoe with invalid data
        myShop.addShoeToInventory("InvalidBrand", "", 0, -10.0);
        
        ShoeInventory inventory = myShop.getInventory();
        
        // Test if the invalid shoe was not added to the inventory
        assertEquals(0, inventory.getInventory().size());
    }

    @Test
    public void testRemoveShoeFromInventory() {
        ShoeShop myShop = new ShoeShop("My Shoe Store");
        myShop.addShoeToInventory("Nike", "Air Max", 10, 129.99);
        myShop.removeShoeFromInventory("Nike");
        ShoeInventory inventory = myShop.getInventory();

        // Test if the shoe was removed from the inventory
        assertEquals(0, inventory.getInventory().size());
    }
    
   
    

}