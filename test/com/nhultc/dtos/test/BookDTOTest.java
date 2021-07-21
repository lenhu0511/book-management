/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhultc.dtos.test;

import com.nhultc.dtos.BookDTO;
import com.nhultc.dtos.BookDTO;
import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dell
 */
public class BookDTOTest {
    
    public BookDTOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetId() {
        System.out.println("getId");
        BookDTO instance = new BookDTO();
        String expResult = null;
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "PRO192";
        BookDTO instance = new BookDTO();
        instance.setId(id);
        String expResult = "PRO192";
        assertEquals(expResult, instance.getId());
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        BookDTO instance = new BookDTO();
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Java";
        BookDTO instance = new BookDTO();
        instance.setName(name);
        String expResult = "Java";
        assertEquals(expResult, instance.getName());
    }

    @Test
    public void testGetAuthor() {
        System.out.println("getAuthor");
        BookDTO instance = new BookDTO();
        String expResult = null;
        String result = instance.getAuthor();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetAuthor() {
        System.out.println("setAuthor");
        String author = "MS";
        BookDTO instance = new BookDTO();
        instance.setAuthor(author);
        String expResult = "MS";
        assertEquals(expResult, instance.getAuthor());
    }

    @Test
    public void testGetPublisher() {
        System.out.println("getPublisher");
        BookDTO instance = new BookDTO();
        String expResult = null;
        String result = instance.getPublisher();
        assertEquals(expResult, result); 
    }

    @Test
    public void testSetPublisher() {
        System.out.println("setPublisher");
        String publisher = "IBM";
        BookDTO instance = new BookDTO();
        instance.setPublisher(publisher);
        String expResult = "IBM";
        assertEquals(expResult, instance.getPublisher());
    }

    @Test
    public void testGetPublishedYear() {
        System.out.println("getPublishedYear");
        BookDTO instance = new BookDTO();
        int expResult = 0;
        int result = instance.getPublishedYear();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetPublishedYear() {
        System.out.println("setPublishedYear");
        int publisherYear = 2013;
        BookDTO instance = new BookDTO();
        instance.setPublishedYear(publisherYear);
        int expResult = 2013;
        int result = instance.getPublishedYear();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsForRent() {
        System.out.println("isForRent");
        BookDTO instance = new BookDTO();
        boolean expResult = false;
        boolean result = instance.isForRent();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetForRent() {
        System.out.println("setForRent");
        boolean forRent = false;
        BookDTO instance = new BookDTO();
        instance.setForRent(forRent);
        boolean expResult = false;
        boolean result = instance.isForRent();
        assertEquals(expResult, result);
    }

    
}
