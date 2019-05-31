package com.task.bottask;

import com.task.bottask.domain.Lector;
import com.task.bottask.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Facade {

    private final SolutionService service;
    private final static Pattern case1 = Pattern.compile("(?<=Who is head of department ).+");
    private final static Pattern case2 = Pattern.compile("(?<=Show ).+(?= statistic)");
    private final static Pattern case3 = Pattern.compile("(?<=Show the average salary for department ).+");
    private final static Pattern case4 = Pattern.compile("(?<=Show count of employee for ).+");
    private final static Pattern case5 = Pattern.compile("(?<=Global search by ).+");

    public Facade(SolutionService service) {
        this.service = service;
    }

    public void headOfDepartment(String line) {
        Matcher matcher = case1.matcher(line);
        if (matcher.find()) {
            Lector lector = service.headOfDepartment(matcher.group());
            System.out.println("Head of " + matcher.group() + " department is " + lector.getFirstName() + " " + lector.getLastName());
        }
    }

    public void departmentStatistic(String line) {
        Matcher matcher = case2.matcher(line);
        if (matcher.find()) {
            Map<String, Long> stringLongMap = service.departmentStatistics(matcher.group());
            System.out.println(stringLongMap);
        }
    }

    public void averageSalary(String line) {
        Matcher matcher = case3.matcher(line);
        if (matcher.find()) {
            String avgSalary = service.averageSalary(matcher.group());
            System.out.println("The average salary of " + line + " is " + avgSalary);


        }
    }

    public void lectorsCount(String line) {
        Matcher matcher = case4.matcher(line);
        if (matcher.find()) {
            int employeeCount = service.lectorsCount(matcher.group());
            System.out.println(employeeCount);
        }
    }

    public void lectorsByTemplate(String line) {
        Matcher matcher = case5.matcher(line);
        if (matcher.find()) {
            List<Lector> lectorsByTemplate = service.findByTemplate(matcher.group());

            if (lectorsByTemplate.isEmpty()) {
                System.out.println("No matches found by given template " + "\"" + matcher.group() + "\"");
            }
            lectorsByTemplate.forEach(lect -> System.out.println(lect.getFirstName() + " " + lect.getLastName()));
        }
    }

    public void exit(String line) {
        if (line.equals("exit")) {
            System.exit(0);
        }
    }
}
