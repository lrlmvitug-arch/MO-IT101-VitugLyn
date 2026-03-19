package com.mycompany.motorphpayroll;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class MotorPHPayroll {

    public static void main(String[] args) {
        // Path to the text file
        String filePath = "employee_data.txt";
        File file = new File(filePath);

        // Validation: Check if file exists
        if (!file.exists()) {
            System.out.println("Error: The file '" + filePath + "' was not found.");
            return;
        }

        // Use try-with-resources to automatically close the reader
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("=========================================");
            System.out.println("       MotorPH BATCH PAYROLL SYSTEM");
            System.out.println("=========================================\n");

            // Read the file line by line
            while ((line = br.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) continue;

                try {
                    // Split the line by comma
                    String[] data = line.split(",");
                    
                    // Basic Validation: Ensure we have both Name and Salary
                    if (data.length < 2) {
                        System.out.println("Skipping invalid record format: " + line);
                        continue;
                    }

                    String name = data[0].trim();
                    double grossSalary = Double.parseDouble(data[1].trim());

                    // Validation: Ensure salary is positive
                    if (grossSalary < 0) {
                        System.out.println("Skipping " + name + ": Salary cannot be negative ($" + grossSalary + ")");
                        continue;
                    }

                    // Process Payroll using existing methods
                    processAndDisplayEmployee(name, grossSalary);

                } catch (NumberFormatException e) {
                    System.out.println("Error parsing salary for line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    // Helper method to bridge the file data with your existing display logic
    public static void processAndDisplayEmployee(String name, double grossSalary) {

        double rice = 1500, phone = 2000, clothing = 1000;
        double totalAllowances = rice + phone + clothing;

        double sss = computeSSS(grossSalary);
        double philHealth = computePhilHealth(grossSalary);
        double pagIbig = computePagIbig(grossSalary);
        double tax = computeIncomeTax(grossSalary);
        double totalDeductions = sss + philHealth + pagIbig + tax;
        double netPay = computeNetPay(grossSalary, totalAllowances);

        // Display structure
        System.out.println("Employee Name: " + name);
        System.out.printf("Gross Salary:  PHP %.2f%n", grossSalary);
        System.out.printf("Deductions:    SSS: %.2f | PhilHealth: %.2f | Pag-IBIG: %.2f | Tax: %.2f%n", 
                          sss, philHealth, pagIbig, tax);
        System.out.printf("Total Deductions: PHP %.2f%n", totalDeductions);
        System.out.printf("NET PAY:       PHP %.2f%n", netPay);
        System.out.println("-------------------------------------------------\n");
    }

    // --- EXISTING METHODS (TASK 9) ---

    public static double computeSSS(double salary) {
        return salary * 0.045;
    }

    public static double computePhilHealth(double salary) {
        return (salary * 0.03) / 2;
    }

    public static double computePagIbig(double salary) {
        double contribution = salary * 0.02;
        return (contribution > 100) ? 100 : contribution;
    }

    public static double computeIncomeTax(double salary) {
        if (salary <= 20833) return 0;
        else if (salary <= 33333) return (salary - 20833) * 0.15;
        else return (salary - 33333) * 0.20 + 1875;
    }

    public static double computeNetPay(double salary, double allowances) {
        double deductions = computeSSS(salary) + computePhilHealth(salary) + 
                            computePagIbig(salary) + computeIncomeTax(salary);
        return salary + allowances - deductions;
    }
}
