package com.task.bottask;

import com.task.bottask.domain.Lector;
import com.task.bottask.service.SolutionService;
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

    public String getAnswer(String line) {
        Matcher matcher;

        StringBuilder answer = new StringBuilder();

        if (line.equals("exit")) {
            System.exit(0);
        } else if ((matcher = case1.matcher(line)).find()) {
            Lector lector = service.headOfDepartment(matcher.group());
            answer.append("Head of ")
                    .append(matcher.group())
                    .append(" department is ")
                    .append(lector.getFirstName())
                    .append(" ")
                    .append(lector.getLastName());

        } else if ((matcher = case2.matcher(line)).find()) {
            Map<String, Long> stringLongMap = service.departmentStatistics(matcher.group());
            answer.append(stringLongMap);

        } else if ((matcher = case3.matcher(line)).find()) {
            String avgSalary = service.averageSalary(matcher.group());
            answer.append(avgSalary);

        } else if ((matcher = case4.matcher(line)).find()) {
            int lectorsCount = service.lectorsCount(matcher.group());
            answer.append(lectorsCount);

        } else if ((matcher = case5.matcher(line)).find()) {
            List<Lector> lectorsByTemplate = service.findByTemplate(matcher.group());

            lectorsByTemplate.forEach(lect -> answer
                    .append(lect.getFirstName())
                    .append(" ")
                    .append(lect.getLastName())
                    .append("\n"));
        } else {
            throw new UnsupportedOperationException("Unknown command");
        }

        return answer.toString();
    }
}
