package buildToTestLab;

import java.util.Scanner;

public class Date {
    private String month;
    private int day;
    private int year;

    public Date() {
        this("January", 1, 1000);
    }

    public Date(int monthInt, int day, int year) {
        setDate(monthInt, day, year);
    }

    public Date(String monthString, int day, int year) {
        setDate(monthString, day, year);
    }

    public Date(int year) {
        month = "January";
        day = 1;
        this.year = year;
    }

    public Date(Date aDate) {
        if (aDate == null) {
            System.out.println("Fatal Error in Date(Date).");
            System.exit(0);
        }
        month = aDate.month;
        day = aDate.day;
        year = aDate.year;
    }

    public void setDate(int monthInt, int day, int year) {
        if (dateOK(monthInt, day, year)) {
            this.month = monthString(monthInt);
            this.day = day;
            this.year = year;
        } else {
            System.out.println("Fatal Error in setDate(int, int, int)");
            System.exit(0);
        }
    }

    public void setDate(String monthString, int day, int year) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            daysInMonth[1] = 29;
        }
        int monthIndex = getMonthIndex(monthString);
        if (monthIndex == -1 || day < 1 || day > daysInMonth[monthIndex] || year < 1000 || year > 9999) {
            return;
        }
        this.month = monthString;
        this.day = day;
        this.year = year;
    }

    public void setDate(int year) {
        setDate(1, 1, year);
    }

    public void setYear(int year) {
        if ((year < 1000) || (year > 9999)) {
            System.out.println("Fatal Error in setYear(int)");
            System.exit(0);
        } else {
            this.year = year;
        }
    }

    public void setMonth(int monthNumber) {
        if ((monthNumber <= 0) || (monthNumber > 12)) {
            System.out.println("Fatal Error in setMonth(int)");
            System.exit(0);
        } else {
            month = monthString(monthNumber);
        }
    }

    public void setDay(int day) {
        if ((day <= 0) || (day > 31)) {
            System.out.println("Fatal Error in setDay(int)");
            System.exit(0);
        } else {
            this.day = day;
        }
    }

    public int getMonth() {
        return getMonthIndex(month) + 1;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return (month + " " + day + ", " + year);
    }

    public boolean equals(Date otherDate) {
        return (month.equals(otherDate.month) && day == otherDate.day && year == otherDate.year);
    }

    public boolean precedes(Date otherDate) {
        return (year < otherDate.year || 
               (year == otherDate.year && getMonth() < otherDate.getMonth()) ||
               (year == otherDate.year && month.equals(otherDate.month) && day < otherDate.day));
    }

    public void readInput() {
        boolean tryAgain = true;
        Scanner keyboard = new Scanner(System.in);
        while (tryAgain) {
            System.out.println("Enter month, day, and year.");
            System.out.println("Do not use a comma.");
            String monthInput = keyboard.next();
            int dayInput = keyboard.nextInt();
            int yearInput = keyboard.nextInt();
            if (dateOK(monthInput, dayInput, yearInput)) {
                setDate(monthInput, dayInput, yearInput);
                tryAgain = false;
            } else {
                System.out.println("Illegal date. Reenter input.");
            }
        }
    }

    private boolean dateOK(int monthInt, int dayInt, int yearInt) {
        return (monthInt >= 1 && monthInt <= 12 &&
                dayInt >= 1 && dayInt <= 31 &&
                yearInt >= 1000 && yearInt <= 9999);
    }

    private boolean dateOK(String monthString, int dayInt, int yearInt) {
        return (monthOK(monthString) &&
                dayInt >= 1 && dayInt <= 31 &&
                yearInt >= 1000 && yearInt <= 9999);
    }

    private boolean monthOK(String month) {
        return getMonthIndex(month) != -1;
    }

    private int getMonthIndex(String month) {
        String[] months = {"January", "February", "March", "April", "May", "June",
                           "July", "August", "September", "October", "November", "December"};
        for (int i = 0; i < months.length; i++) {
            if (months[i].equalsIgnoreCase(month)) {
                return i;
            }
        }
        return -1;
    }

    private String monthString(int monthNumber) {
        switch (monthNumber) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default:
                System.out.println("Fatal Error in monthString");
                System.exit(0);
                return "Error";
        }
    }

    public void addOneDay() {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            daysInMonth[1] = 29;
        }
        if (day < daysInMonth[getMonth() - 1]) {
            day++;
        } else {
            day = 1;
            if (getMonth() == 12) {
                month = "January";
                year++;
            } else {
                month = monthString(getMonth() + 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Main in Date.");
        Date tester = new Date();
        System.out.println("tester is " + tester);
    }
}
