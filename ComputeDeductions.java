/*
 * MotorPH Payroll System
 * Task 9: Compute Government Deductions and Net Pay
 *
 * This program computes payroll deductions (SSS, PhilHealth,
 * Pag-IBIG, and Income Tax) and calculates the employee's net pay.
 */

public class MotorPHPayroll {

    public static void main(String[] args) {

        // -----------------------------------
        // 1. Employee Information
        // -----------------------------------
        int employeeID = 10001;
        String employeeName = "Manuel III Garcia";
        String position = "Chief Executive Officer";

        // -----------------------------------
        // 2. Salary Information (From Database)
        // -----------------------------------
        double grossSalary = 45000.00;

        double riceSubsidy = 1500;
        double phoneAllowance = 2000;
        double clothingAllowance = 1000;

        double totalAllowances = riceSubsidy + phoneAllowance + clothingAllowance;

        // -----------------------------------
        // 3. Compute Deductions
        // -----------------------------------
        double sss = computeSSS(grossSalary);
        double philHealth = computePhilHealth(grossSalary);
        double pagIbig = computePagIbig(grossSalary);
        double incomeTax = computeIncomeTax(grossSalary);

        double totalDeductions = sss + philHealth + pagIbig + incomeTax;

        // -----------------------------------
        // 4. Compute Net Pay
        // -----------------------------------
        double netPay = computeNetPay(grossSalary, totalAllowances);

        // -----------------------------------
        // 5. Payroll Summary Output
        // -----------------------------------
        displayPayrollSummary(
                employeeID,
                employeeName,
                position,
                grossSalary,
                riceSubsidy,
                phoneAllowance,
                clothingAllowance,
                totalAllowances,
                sss,
                philHealth,
                pagIbig,
                incomeTax,
                totalDeductions,
                netPay
        );
    }

    // -----------------------------------
    // Deduction Methods
    // -----------------------------------

    // Compute SSS Contribution
    public static double computeSSS(double salary) {
        return salary * 0.045;
    }

    // Compute PhilHealth Contribution
    public static double computePhilHealth(double salary) {
        return (salary * 0.03) / 2;
    }

    // Compute Pag-IBIG Contribution
    public static double computePagIbig(double salary) {

        double contribution = salary * 0.02;

        if (contribution > 100) {
            contribution = 100;
        }

        return contribution;
    }

    // Compute Income Tax using simplified TRAIN brackets
    public static double computeIncomeTax(double salary) {

        if (salary <= 20833) {
            return 0;
        }
        else if (salary <= 33333) {
            return (salary - 20833) * 0.15;
        }
        else {
            return (salary - 33333) * 0.20 + 1875;
        }
    }

    // -----------------------------------
    // Net Pay Method
    // -----------------------------------
    public static double computeNetPay(double salary, double allowances) {

        double sss = computeSSS(salary);
        double philHealth = computePhilHealth(salary);
        double pagIbig = computePagIbig(salary);
        double tax = computeIncomeTax(salary);

        double totalDeductions = sss + philHealth + pagIbig + tax;

        return salary + allowances - totalDeductions;
    }

    // -----------------------------------
    // Display Payroll Summary Method
    // -----------------------------------
    public static void displayPayrollSummary(
            int id,
            String name,
            String position,
            double grossSalary,
            double rice,
            double phone,
            double clothing,
            double allowances,
            double sss,
            double philHealth,
            double pagIbig,
            double tax,
            double totalDeductions,
            double netPay
    ) {

        System.out.println("=================================");
        System.out.println("        MotorPH Payroll System");
        System.out.println("=================================");

        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Position: " + position);

        System.out.println("---------------------------------");
        System.out.printf("Gross Salary: PHP %.2f%n", grossSalary);

        System.out.println("\nAllowances:");
        System.out.printf("Rice Subsidy: PHP %.2f%n", rice);
        System.out.printf("Phone Allowance: PHP %.2f%n", phone);
        System.out.printf("Clothing Allowance: PHP %.2f%n", clothing);
        System.out.printf("Total Allowances: PHP %.2f%n", allowances);

        System.out.println("\nDeductions:");
        System.out.printf("SSS: PHP %.2f%n", sss);
        System.out.printf("PhilHealth: PHP %.2f%n", philHealth);
        System.out.printf("Pag-IBIG: PHP %.2f%n", pagIbig);
        System.out.printf("Income Tax: PHP %.2f%n", tax);

        System.out.println("---------------------------------");
        System.out.printf("Total Deductions: PHP %.2f%n", totalDeductions);
        System.out.printf("Net Pay: PHP %.2f%n", netPay);

        System.out.println("=================================");
    }
}
