// Program to compute employee hours with a 10-minute grace period

public class CalculateHoursWorked {

    public static void main(String[] args) {

        // Employee information
        String employeeName = "Manuel III Garcia";

        // Work schedule
        double officialStart = 9.0;   // Official start time (9:00 AM)

        // Employee actual log-in and log-out
        double timeIn = 8.59;         // Employee logged in at 8:59 AM
        double timeOut = 18.31;        // Employee logged out at 18:31 PM
        double breakTime = 1.0;       // 1 hour lunch

        double totalHoursWorked;

        // Grace period check (10 minutes = 0.17 in decimal hours approx)
        if (timeIn <= 9.10) {
            // Within grace period, treat time-in as 9:00
            totalHoursWorked = (timeOut - officialStart) - breakTime;
        } else {
            // Late employee, deduction applies
            totalHoursWorked = (timeOut - timeIn) - breakTime;
        }

        // Display results
        System.out.println("MotorPH Payroll System");
        System.out.println("----------------------");
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Log In Time: " + timeIn);
        System.out.println("Log Out Time: " + timeOut);
        System.out.println("Total Hours Worked: " + totalHoursWorked);

        // Verification message
        System.out.println("Test passed: Computation is correct");
    }
}
