package com.task.bottask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CmdRunner implements CommandLineRunner {

    @Autowired
    private final Facade facade;

    @Autowired
    public CmdRunner(Facade facade) {
        this.facade = facade;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();

            facade.exit(line);
            facade.headOfDepartment(line);
            facade.departmentStatistic(line);
            facade.averageSalary(line);
            facade.lectorsByTemplate(line);
            facade.lectorsCount(line);

            System.out.println("Unknown command. Supported commands are: " + "\n" +
                    "- Who is head of department {department name}" + "\n" +
                    "- Show {department name} statistic" + "\n" +
                    "- Show the average salary for department {department name}" + "\n" +
                    "- Show count of employee for {department name}" + "\n" +
                    "- Global search by {template}" + "\n" +
                    "- exit");
        }
    }
}

