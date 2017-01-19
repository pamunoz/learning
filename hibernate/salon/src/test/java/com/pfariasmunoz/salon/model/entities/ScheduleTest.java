/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfariasmunoz.salon.model.entities;

import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pablo
 */
public class ScheduleTest {
    
    public ScheduleTest() {
    }

//    /**
//     * Test of getmId method, of class Schedule.
//     */
//    @Test
//    public void testGetmId() {
//        System.out.println("getmId");
//        Schedule instance = new Schedule();
//        Long expResult = null;
//        Long result = instance.getmId();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setmId method, of class Schedule.
//     */
//    @Test
//    public void testSetmId() {
//        System.out.println("setmId");
//        Long mId = null;
//        Schedule instance = new Schedule();
//        instance.setmId(mId);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getmFrom method, of class Schedule.
     */
    @Test
    public void testGetmFrom() {
        System.out.println("getmFrom");
        LocalDateTime from = LocalDateTime.of(2017, Month.JANUARY, 18, 17, 48);
        LocalDateTime to = LocalDateTime.of(2017, Month.MARCH, 1, 12, 30);
        Schedule instance = new Schedule(from, to);
        LocalDateTime expResult = from;
        LocalDateTime result = instance.getmFrom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of setmFrom method, of class Schedule.
     */
    @Test
    public void testSetmFrom() {
        System.out.println("setmFrom");
        LocalDateTime mFrom = LocalDateTime.of(2017, Month.MARCH, 1, 12, 30);
        Schedule instance = new Schedule();
        instance.setmFrom(mFrom);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getmTo method, of class Schedule.
     */
    @Test
    public void testGetmTo() {
        System.out.println("getmTo");
        Schedule instance = new Schedule();
        LocalDateTime expResult = null;
        LocalDateTime result = instance.getmTo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setmTo method, of class Schedule.
     */
    @Test
    public void testSetmTo() {
        System.out.println("setmTo");
        LocalDateTime mTo = LocalDateTime.of(2017, Month.MARCH, 1, 12, 30);
        Schedule instance = new Schedule();
        instance.setmTo(mTo);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
