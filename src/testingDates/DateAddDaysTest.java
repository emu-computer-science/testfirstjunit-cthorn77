import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;

public class DateAddDaysTest {
	
	@Test
	public void testSameMonth() {
		Date date = new Date("March", 5, 2025);
		date.addOneDay();
		assertEquals("March 6 2025", date.toString());
	}
	
	@Test
	public void testNewMonth() {
		Date date = new Date("March", 31, 2025);
		date.addOneDay();
		assertEquals("April 1 2025", date.toString());
	}
	
	@Test
	public void testNewYear() {
		Date date = new Date("December", 31, 2025);
		date.addOneDay();
		assertEquals("January 1 2026", date.toString());
	}
	
	@Test
	public void testIncrementDay() {
		Date date = new Date("March", 17, 2025);
		int previous = date.getDay();
		date.addOneDay();
		assertEquals(1, date.getDay()-previous);	
	}
}