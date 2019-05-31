package com.task.bottask;

import com.task.bottask.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.regex.Pattern;

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
            String ln = scanner.nextLine();

        }
    }
}
