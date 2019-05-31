package com.task.bottask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CmdRunner implements CommandLineRunner {

    private final Facade facade;

    public CmdRunner(Facade facade) {
        this.facade = facade;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Supported commands are: " + "\n" +
                "Who is head of department {department name}" + "\n" +
                "Show {department name} statistic" + "\n" +
                "Show the average salary for department {department name}" + "\n" +
                "Show count of employee for {department name}" + "\n" +
                "Global search by {template}" + "\n" +
                "exit");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();

            try {
                System.out.println(facade.getAnswer(line));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
