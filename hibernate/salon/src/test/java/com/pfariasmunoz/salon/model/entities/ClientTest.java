/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfariasmunoz.salon.model.entities;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pablo
 */
public class ClientTest {
    
    public ClientTest() {
    }

    /**
     * Test of getmId method, of class Client.
     */
    @Test
    public void testGetmId() {
        System.out.println("getmId");
        Client instance = new Client();
        Long expResult = null;
        Long result = instance.getmId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setmId method, of class Client.
     */
    @Test
    public void testSetmId() {
        System.out.println("setmId");
        Long mId = null;
        Client instance = new Client();
        instance.setmId(mId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getmClientName method, of class Client.
     */
    @Test
    public void testGetmClientName() {
        System.out.println("getmClientName");
        Client instance = new Client();
        String expResult = "";
        String result = instance.getmClientName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setmClientName method, of class Client.
     */
    @Test
    public void testSetmClientName() {
        System.out.println("setmClientName");
        String mClientName = "";
        Client instance = new Client();
        instance.setmClientName(mClientName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getmContactPhone method, of class Client.
     */
    @Test
    public void testGetmContactPhone() {
        System.out.println("getmContactPhone");
        Client instance = new Client();
        String expResult = "";
        String result = instance.getmContactPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setmContactPhone method, of class Client.
     */
    @Test
    public void testSetmContactPhone() {
        System.out.println("setmContactPhone");
        String mContactPhone = "";
        Client instance = new Client();
        instance.setmContactPhone(mContactPhone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getmContactMail method, of class Client.
     */
    @Test
    public void testGetmContactMail() {
        System.out.println("getmContactMail");
        Client instance = new Client();
        String expResult = "";
        String result = instance.getmContactMail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setmContactMail method, of class Client.
     */
    @Test
    public void testSetmContactMail() {
        System.out.println("setmContactMail");
        String mContactMail = "";
        Client instance = new Client();
        instance.setmContactMail(mContactMail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
