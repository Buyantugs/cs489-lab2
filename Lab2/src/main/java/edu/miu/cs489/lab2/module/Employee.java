package edu.miu.cs489.lab2.module;

import java.time.LocalDate;

public record Employee(Long employeeId, String firstName, String lastName, LocalDate employmentDate, Double yearlySalary) {
}
