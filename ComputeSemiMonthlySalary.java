/*
 * MotorPH Payroll System
 * Task 8: Compute Semi-Monthly Salary
 *
 * Program Description:
 * This program calculates an employee's semi-monthly salary
 * based on total hours worked and hourly rate.
 * It extends Task 7 by using the computed hours worked
 * and multiplying it by the hourly pay rate.
 */

public class ComputeSemiMonthlySalary {

    public static void main(String[] args) {

        // -----------------------------------
        // 1. Employee Information
        // -----------------------------------
        String employeeName = "Manuel III Garcia";
        int employeeID = 10001;

        // -----------------------------------
        // 2. Work Schedule Details (Task 7)
        // -----------------------------------
        double timeIn = 8.59;      // Employee logged in at 8:59 AM
        double timeOut = 18.31;    // Employee logged out at 6:31 PM
        double breakTime = 1.0;   // 1 hour lunch break

        // Compute total hours worked
        double totalHoursWorked = (timeOut - timeIn) - breakTime;

        // -----------------------------------
        // 3. Salary Information
        // -----------------------------------
        double hourlyRate = 535.71;   // Hourly pay rate
        double semiMonthlySalary;    // Variable to store computed salary

        // -----------------------------------
        // 4. Input Validation
        // -----------------------------------
        if (totalHoursWorked <= 0 || hourlyRate <= 0) {

            System.out.println("Invalid data detected.");
            System.out.println("Hours worked and hourly rate must be greater than zero.");

        } else {

            // -----------------------------------
            // 5. Salary Computation
            // -----------------------------------
            semiMonthlySalary = totalHoursWorked * hourlyRate;

            // -----------------------------------
            // 6. Payroll Summary Output
            // -----------------------------------
            System.out.println("=================================");
            System.out.println("        MotorPH Payroll System");
            System.out.println("=================================");

            System.out.println("Employee ID: " + employeeID);
            System.out.println("Employee Name: " + employeeName);

            System.out.println("---------------------------------");
            System.out.println("Time In: " + timeIn);
            System.out.println("Time Out: " + timeOut);
            System.out.println("Break Time: " + breakTime);

            System.out.println("Total Hours Worked: " + totalHoursWorked);
            System.out.println("Hourly Rate: PHP " + hourlyRate);

            System.out.println("---------------------------------");
            System.out.println("Semi-Monthly Salary: PHP " + semiMonthlySalary);
            System.out.println("=================================");

            // Verification message
            System.out.println("Computation verified successfully!");
        }
    }
}
