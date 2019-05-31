package com.task.bottask;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import com.task.bottask.domain.Lector;
import com.task.bottask.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Component
public class CmdRunner implements CommandLineRunner {

    private final SolutionService service;
    Pattern case1 = Pattern.compile("(?<=Who is head of department ).+");
    Pattern case2 = Pattern.compile("(?<=Show ).+(?= statistic)");
    Pattern case3 = Pattern.compile("(?<=Show the average salary for department ).+");
    Pattern case4 = Pattern.compile("(?<=Show count of employee for ).+");
    Pattern case5 = Pattern.compile("(?<=Global search by ).+");


    @Autowired
    public CmdRunner(SolutionService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            Matcher matcher;

            if ((matcher = case1.matcher(line)).find()) {
                Lector lector = service.headOfDepartment(matcher.group());
                System.out.println("Head of " + matcher.group() + " department is " + lector.getFirstName() + " " + lector.getLastName());

            } else if ((matcher = case2.matcher(line)).find()) {
                Map<String, Long> stringLongMap = service.departmentStatistics(matcher.group());
                System.out.println(stringLongMap);

            } else if ((matcher = case3.matcher(line)).find()) {
                String avgSalary = service.averageSalary(matcher.group());
                System.out.println("The average salary of " + line + " is " + avgSalary);

            } else if ((matcher = case4.matcher(line)).find()) {
                int employeeCount = service.lectorsCount(matcher.group());
                System.out.println(employeeCount);

            } else if ((matcher = case5.matcher(line)).find()) {
                List<Lector> lectorsByTemplate = service.findByTemplate(matcher.group());
                if (lectorsByTemplate.isEmpty()) System.out.println("No matches for given template");
                lectorsByTemplate.forEach(lect -> System.out.println(lect.getFirstName() + " " + lect.getLastName()));

            } else if (line.equals("exit")) {
                System.exit(0);

            } else {
                System.out.println("Unknown command. Supported commands are: " + "\n" +
                        "Who is head of department {department name}" + "\n" +
                        "Show {department name} statistic" + "\n" +
                        "Show the average salary for department {department name}" + "\n" +
                        "Show count of employee for {department name}" + "\n" +
                        "Global search by {template}" + "\n" +
                        "exit");
            }
        }
    }
}
