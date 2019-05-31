package com.task.bottask.service;

import com.task.bottask.domain.Lector;

import java.util.List;
import java.util.Map;

public interface SolutionService {

    Lector headOfDepartment(String department);

    Map<String, Long> departmentStatistics(String departmentName);

    String averageSalary(String departmentName);

    int lectorsCount(String departmentName);

    List<Lector> findByTemplate(String template);


}
