package edu.miu.cs489.lab2.module;

import java.time.LocalDate;
import java.util.Date;
public record PensionPlan(String planReferenceNumber, LocalDate enrollmentDate, Double monthlyContribution) {
}
