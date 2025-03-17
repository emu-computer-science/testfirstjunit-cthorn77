import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class DateSetDateTest {

    @Test
    public void testLegalDateChange() {
        Date bob = new Date(3, 10, 2025);
        bob.setDate(5, 15, 2026);
        assertEquals("May 15, 2026", bob.toString());
    }

    @Test
    public void testIllegalDateChange_DayTooHigh() {
        Date bob = new Date(4, 10, 2025);
        bob.setDate(4, 31, 2025);
        assertNotEquals("April 31, 2025", bob.toString());
        assertEquals("April 10, 2025", bob.toString());
    }

    @Test
    public void testIllegalDateChange_MonthTooHigh() {
        Date bob = new Date(6, 15, 2025);
        bob.setDate(13, 5, 2025);
        assertNotEquals("13 5, 2025", bob.toString());
        assertEquals("June 15, 2025", bob.toString());
    }

    @Test
    public void testIllegalDateChange_YearOutOfRange() {
        Date bob = new Date(8, 20, 2025);
        bob.setDate(8, 20, 999);
        assertNotEquals("August 20, 999", bob.toString());
        assertEquals("August 20, 2025", bob.toString());
    }

    @Test
    public void testLeapYearValidDate() {
        Date bob = new Date(2, 28, 2024);
        bob.setDate(2, 29, 2024);
        assertEquals("February 29, 2024", bob.toString());
    }

    @Test
    public void testNonLeapYearInvalidDate() {
        Date bob = new Date(2, 28, 2023);
        bob.setDate(2, 29, 2023);
        assertNotEquals("February 29, 2023", bob.toString());
        assertEquals("February 28, 2023", bob.toString());
    }
}
