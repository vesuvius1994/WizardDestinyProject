/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities.DynamicEntities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author letga
 */
public class MainCharacterTest {
    
    public MainCharacterTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getMoveForwardKey method, of class MainCharacter.
     */
    @Test
    public void testGetMoveForwardKey() {
        System.out.println("getMoveForwardKey");
        MainCharacter instance = null;
        int expResult = 0;
        int result = instance.getMoveForwardKey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMoveBackwardKey method, of class MainCharacter.
     */
    @Test
    public void testGetMoveBackwardKey() {
        System.out.println("getMoveBackwardKey");
        MainCharacter instance = null;
        int expResult = 0;
        int result = instance.getMoveBackwardKey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJumpKey method, of class MainCharacter.
     */
    @Test
    public void testGetJumpKey() {
        System.out.println("getJumpKey");
        MainCharacter instance = null;
        int expResult = 0;
        int result = instance.getJumpKey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBasicAttackKey method, of class MainCharacter.
     */
    @Test
    public void testGetBasicAttackKey() {
        System.out.println("getBasicAttackKey");
        MainCharacter instance = null;
        int expResult = 0;
        int result = instance.getBasicAttackKey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpecialAttackKey method, of class MainCharacter.
     */
    @Test
    public void testGetSpecialAttackKey() {
        System.out.println("getSpecialAttackKey");
        MainCharacter instance = null;
        int expResult = 0;
        int result = instance.getSpecialAttackKey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of specialAttack method, of class MainCharacter.
     */
    @Test
    public void testSpecialAttack() {
        System.out.println("specialAttack");
        MainCharacter instance = null;
        instance.specialAttack();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnergy method, of class MainCharacter.
     */
    @Test
    public void testGetEnergy() {
        System.out.println("getEnergy");
        MainCharacter instance = null;
        int expResult = 0;
        int result = instance.getEnergy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decreaseEnergy method, of class MainCharacter.
     */
    @Test
    public void testDecreaseEnergy() {
        System.out.println("decreaseEnergy");
        MainCharacter instance = null;
        instance.decreaseEnergy();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of attack method, of class MainCharacter.
     */
    @Test
    public void testAttack() {
        System.out.println("attack");
        MainCharacter instance = null;
        instance.attack();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
