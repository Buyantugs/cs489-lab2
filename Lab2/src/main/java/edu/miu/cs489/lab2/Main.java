package edu.miu.cs489.lab2;
import edu.miu.cs489.lab2.module.Employee;
import edu.miu.cs489.lab2.module.PensionPlan;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Employee[] empList = {
                new Employee(1L, "Daniel", "Agar", LocalDate.parse("2018-01-17"), 105945.50),
                new Employee(2L, "Bernard", "Shaw", LocalDate.parse("2018-10-20"), 90750.00),
                new Employee(3L, "Carly", "Agar", LocalDate.parse("2014-05-16"), 842000.75),
                new Employee(4L, "Wesley", "Schneider", LocalDate.parse("2019-05-02"), 74500.00)
        };

        PensionPlan[] plans={
                new PensionPlan("EX1089", LocalDate.parse("2023-01-17"),100.00),
                new PensionPlan("SM2307", LocalDate.parse("2019-11-04"),1555.50)
        };

        // Employees in JSON format
        printJsonEmployees(empList);

        MonthlyUpcomingEnrollees();


    }

    private static void printJsonEmployees(Employee[] employees) {
        System.out.println("JSON-formatted list of all Employees:");
        System.out.println("[");
        for (Employee employee : employees) {
            System.out.println("  " + employeeToJson(employee) + ",");
        }
        System.out.println("]");
    }

    private static String employeeToJson(Employee employee) {
        return "{\"employeeId\": \"" + employee.employeeId() + "\", \"firstName\": \"" + employee.firstName() + "\", \"lastName\": \"" + employee.lastName() + "\", \"employmentDate\": " + employee.employmentDate() + ", \"yearlySalary\": " + employee.yearlySalary() + "}";
    }

    private static void MonthlyUpcomingEnrollees(){
        System.out.println("Unable to understood 2nd the requirement !!!");
    }
}