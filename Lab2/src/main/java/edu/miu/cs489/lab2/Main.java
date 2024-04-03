package edu.miu.cs489.lab2;
import edu.miu.cs489.lab2.module.Employee;
import edu.miu.cs489.lab2.module.PensionPlan;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Employee[] employees = {
                new Employee(1L, "Daniel", "Agar", LocalDate.parse("2018-01-17"), 105945.50,
                        new PensionPlan("EX1089", LocalDate.parse("2023-01-17"),100.00)),
                new Employee(2L, "Bernard", "Shaw", LocalDate.parse("2018-10-20"), 90750.00,
                        null),
                new Employee(3L, "Carly", "Agar", LocalDate.parse("2014-05-16"), 842000.75,
                        new PensionPlan("SM2307", LocalDate.parse("2019-11-04"),1555.50)),
                new Employee(4L, "Wesley", "Schneider", LocalDate.parse("2019-05-02"), 74500.00,
                        null)
        };

//        PensionPlan[] plans={
//                new PensionPlan("EX1089", LocalDate.parse("2023-01-17"),100.00),
//                new PensionPlan("SM2307", LocalDate.parse("2019-11-04"),1555.50)
//        };

        //TASK1 - Employees in JSON format
        printJsonEmployees(employees);

        MonthlyUpcomingEnrollees(employees);


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

    private static void MonthlyUpcomingEnrollees(Employee[] employees) {
        LocalDate currentDate = LocalDate.now();

        // Calculate the date 5 years ago
        LocalDate fiveYearsAgo = currentDate.minusYears(5);

        // Calculate the date of the upcoming month
        LocalDate upcomingMonth = currentDate.plusMonths(1);

        // Count the number of employees who completed 5 years in the upcoming next month
        long count = Arrays.stream(employees)
                .filter(employee -> employee.employmentDate().isBefore(upcomingMonth) &&
                        employee.employmentDate().isAfter(fiveYearsAgo))
                .count();

        // Create a new array to hold filtered employees
        Employee[] filteredEmployees = new Employee[(int) count];
        int index = 0;
        for (Employee employee : employees) {
            if (employee.employmentDate().isBefore(upcomingMonth) &&
                    employee.employmentDate().isAfter(fiveYearsAgo)) {
                filteredEmployees[index++] = employee;
            }
        }

        // Sort the filtered employees array by last name and yearly salary
        Arrays.sort(filteredEmployees, Comparator.comparing(Employee::lastName)
                .thenComparing(Comparator.comparing(Employee::yearlySalary).reversed()));

        // Print the sorted filtered employees array
        printJsonEmployees(filteredEmployees);
    }

}