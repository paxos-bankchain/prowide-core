/* 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 */
package com.prowidesoftware.swift.model.field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.prowidesoftware.swift.io.writer.FINWriterVisitor;

/**
 * Test for Field50F and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field50FTest extends AbstractFieldTest {
	
	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("50F",
				"FFF\nA/B\nC/D\nE/F",
				
				"AAAA/BB/CCCCCCCC/DD1234567\n"+
					"1/JOHN SMITH\n"+
					"2/HIGH STREET 6, APT 6C\n"+
					"3/BE/BRUSSELS",
					
				"/123456\n1/JOHN SMITH",
				
				"CODE/AR\n1/JOHN SMITH",
				
				"/12345678\n"+
				"1/SMITH JOHN\n"+
				"2/299, PARK AVENUE\n"+
				"3/US/NEW YORK, NY 10017",
				
				"/BE30001216371411\n"+
				"1/PHILIPS MARK\n"+
				"4/19720830\n"+
				"5/BE/BRUSSELS",
				
				"DRLC/BE/BRUSSELS/NB0949042\n"+
				"1/DUPONT JACQUES\n"+
				"2/HIGH STREET 6, APT 6C\n"+
				"3/BE/BRUSSELS",
				
				"NIDN/DE/121231234342\n"+
				"1/MANN GEORG\n"+
				"6/DE/ABC BANK/1234578293"
			);
	}
	
	/**
	 * 50F: 
	 * First line can have different formats
	 * <”/”34x> | <4!a”/”<CC>”/”27x><CrLf>
	 */
	@Test
	public void testSerialization2() {
		Field50F f = new Field50F();
		assertEquals("", f.getValue());

		f.setComponent1("/1234567");
		assertEquals("/1234567", f.getValue());

		f.setComponent1("1234567");
		assertEquals("1234567", f.getValue()); //the slash will not be added

		f.setComponent1("1234/AR/ABC");
		assertEquals("1234/AR/ABC", f.getValue());

		f.setComponent2("1");
		f.setComponent3("ABC");
		assertEquals("1234/AR/ABC"+ FINWriterVisitor.SWIFT_EOL + "1/ABC", f.getValue());
	}

	@Test
	public void testParse_01() {
		Field50F f = new Field50F("FFF");
		assertEquals("FFF", f.getComponent1());
		assertNull(f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		assertNull(f.getComponent7());
		assertNull(f.getComponent8());
		assertNull(f.getComponent9());
	}
	
	@Test
	public void testParse_02() {
		Field50F f = new Field50F("FFF\nA");
		assertEquals("FFF", f.getComponent1());
		assertEquals("A", f.getComponent2());
		assertNull(f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		assertNull(f.getComponent7());
		assertNull(f.getComponent8());
		assertNull(f.getComponent9());
	}
	
	@Test
	public void testParse_03() {
		Field50F f = new Field50F("FFF\nA/B");
		assertEquals("FFF", f.getComponent1());
		assertEquals("A", f.getComponent2());
		assertEquals("B", f.getComponent3());
		assertNull(f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		assertNull(f.getComponent7());
		assertNull(f.getComponent8());
		assertNull(f.getComponent9());
	}
	
	@Test
	public void testParse_04() {
		Field50F f = new Field50F("FFF\nA/B\nC");
		assertEquals("FFF", f.getComponent1());
		assertEquals("A", f.getComponent2());
		assertEquals("B", f.getComponent3());
		assertEquals("C", f.getComponent4());
		assertNull(f.getComponent5());
		assertNull(f.getComponent6());
		assertNull(f.getComponent7());
		assertNull(f.getComponent8());
		assertNull(f.getComponent9());
	}

	@Test
	public void testParse_05() {
		Field50F f = new Field50F("FFF\nA/B\nC/D");
		assertEquals("FFF", f.getComponent1());
		assertEquals("A", f.getComponent2());
		assertEquals("B", f.getComponent3());
		assertEquals("C", f.getComponent4());
		assertEquals("D", f.getComponent5());
		assertNull(f.getComponent6());
		assertNull(f.getComponent7());
		assertNull(f.getComponent8());
		assertNull(f.getComponent9());
	}

	@Test
	public void testParse_06() {
		Field50F f = new Field50F("FFF\nA/B\nC/D\nE");
		assertEquals("FFF", f.getComponent1());
		assertEquals("A", f.getComponent2());
		assertEquals("B", f.getComponent3());
		assertEquals("C", f.getComponent4());
		assertEquals("D", f.getComponent5());
		assertEquals("E", f.getComponent6());
		assertNull(f.getComponent7());
		assertNull(f.getComponent8());
		assertNull(f.getComponent9());
	}
	
	@Test
	public void testParse_07() {
		Field50F f = new Field50F("FFF\nA/B\nC/D\nE/F");
		assertEquals("FFF", f.getComponent1());
		assertEquals("A", f.getComponent2());
		assertEquals("B", f.getComponent3());
		assertEquals("C", f.getComponent4());
		assertEquals("D", f.getComponent5());
		assertEquals("E", f.getComponent6());
		assertEquals("F", f.getComponent7());
		assertNull(f.getComponent8());
		assertNull(f.getComponent9());
	}
	
	@Test
	public void testParse_08() {
		Field50F f = new Field50F("FFF\nA/B\nC/D\nE/F\nG");
		assertEquals("FFF", f.getComponent1());
		assertEquals("A", f.getComponent2());
		assertEquals("B", f.getComponent3());
		assertEquals("C", f.getComponent4());
		assertEquals("D", f.getComponent5());
		assertEquals("E", f.getComponent6());
		assertEquals("F", f.getComponent7());
		assertEquals("G", f.getComponent8());
		assertNull(f.getComponent9());
	}
	
	@Test
	public void testParse_09() {
		Field50F f = new Field50F("FFF\nA/B\nC/D\nE/F\nG/H");
		assertEquals("FFF", f.getComponent1());
		assertEquals("A", f.getComponent2());
		assertEquals("B", f.getComponent3());
		assertEquals("C", f.getComponent4());
		assertEquals("D", f.getComponent5());
		assertEquals("E", f.getComponent6());
		assertEquals("F", f.getComponent7());
		assertEquals("G", f.getComponent8());
		assertEquals("H", f.getComponent9());
	}
	
	@Test
	public void testParse_10() {
		Field50F f = new Field50F("AAAA/BB/CCCCCCCC/DD1234567\n"+
		"1/JOHN SMITH\n"+
		"2/HIGH STREET 6, APT 6C\n"+
		"3/BE/BRUSSELS");
		assertEquals("AAAA/BB/CCCCCCCC/DD1234567", f.getComponent1());
		assertEquals("1", f.getComponent2());
		assertEquals("JOHN SMITH", f.getComponent3());
		assertEquals("2", f.getComponent4());
		assertEquals("HIGH STREET 6, APT 6C", f.getComponent5());
		assertEquals("3", f.getComponent6());
		assertEquals("BE/BRUSSELS", f.getComponent7());
		assertNull(f.getComponent8());
		assertNull(f.getComponent9());
	}
	
	@Test
	public void testParse_11() {
		/*
		 * test sample value
		 */
		final String value = "/1234567890\r\n"+
				"1/JOHN SMITH\r\n"+
				"2/HIGH STREET 6, APT 6C\r\n"+
				"3/BE/BRUSSELS";
		
		/*
		 * parse value into components
		 */
		Field50F f = new Field50F(value);
		
		/*
		 * assert each parsed component
		 */
		assertEquals("/1234567890", f.getComponent1());
		assertEquals("1", f.getComponent2());
		assertEquals("JOHN SMITH", f.getComponent3());
		assertEquals("2", f.getComponent4());
		assertEquals("HIGH STREET 6, APT 6C", f.getComponent5());
		assertEquals("3", f.getComponent6());
		assertEquals("BE/BRUSSELS", f.getComponent7());
		assertNull(f.getComponent8());
		assertNull(f.getComponent9());
		
		/*
		 * serialize field components into plain value
		 * and assert match with original value
		 */
		assertEquals(value, f.getValue());
	}

	@Test
	public void testDynamicLabels() {
		Field50F f = new Field50F("/12345678\n"+
				"1/SMITH JOHN\n"+
				"2/299, PARK AVENUE\n"+
				"3/US/NEW YORK, NY 10017");
		assertEquals("Account", f.getComponentLabel(1));
		assertEquals("Name of the Ordering Customer", f.getComponentLabel(3));
		assertEquals("Address Line", f.getComponentLabel(5));
		assertEquals("Country and Town", f.getComponentLabel(7));
				
		f = new Field50F("/BE30001216371411\n"+
				"1/PHILIPS MARK\n"+
				"4/19720830\n"+
				"5/BE/BRUSSELS");
		assertEquals("Account", f.getComponentLabel(1));
		assertEquals("Name of the Ordering Customer", f.getComponentLabel(3));
		assertEquals("Date of Birth", f.getComponentLabel(5));
		assertEquals("Place of Birth", f.getComponentLabel(7));
				
		f = new Field50F("DRLC/BE/BRUSSELS/NB0949042\n"+
				"1/DUPONT JACQUES\n"+
				"2/HIGH STREET 6, APT 6C\n"+
				"3/BE/BRUSSELS");
		assertEquals("Party Identifier", f.getComponentLabel(1));
		assertEquals("Name of the Ordering Customer", f.getComponentLabel(3));
		assertEquals("Address Line", f.getComponentLabel(5));
		assertEquals("Country and Town", f.getComponentLabel(7));
				
		f = new Field50F("NIDN/DE/121231234342\n"+
				"1/MANN GEORG\n"+
				"6/DE/ABC BANK/1234578293");
		assertEquals("Party Identifier", f.getComponentLabel(1));
		assertEquals("Name of the Ordering Customer", f.getComponentLabel(3));
		assertEquals("Customer Identification Number", f.getComponentLabel(5));
	}
	
}