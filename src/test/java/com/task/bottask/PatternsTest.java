package com.task.bottask;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class PatternsTest {

    /**
     * 1.Who is head of department {department_name}
     * Answer: Head of {department_name} department is
     * {head_of_department_name}
     */
    @Test
    public void head_of_department_pattern() {
        Pattern case1 = Pattern.compile("(?<=Who is head of department ).+");
        String input = "Who is head of department dep";

        Matcher matcher = case1.matcher(input);

        assertThat(matcher.find()).isTrue();
        assertThat(matcher.group()).isEqualTo("dep");
    }

    /**
     * 2.Show {department_name} statistic.
     * Answer: assistans - {assistams_count}.
     * associate professors - {associate_professors_count}
     * professors -{professors_count}
     */
    @Test
    public void department_statistic_pattern() {
        Pattern case2 = Pattern.compile("(?<=Show ).*(?= statistic)");
        String input = "Show dep statistic";

        Matcher matcher = case2.matcher(input);

        assertThat(matcher.find()).isTrue();
        assertThat(matcher.group()).isEqualTo("dep");
    }

    /**
     * 3. Show the average salary for department {department_name}.
     * Answer: The average salary of {department_name} is
     * {average_salary}
     */
    @Test
    public void average_salary_pattern() {
        Pattern case3 = Pattern.compile("(?<=Show the average salary for department ).*");
        String input = "Show the average salary for department dep";

        Matcher matcher = case3.matcher(input);

        assertThat(matcher.find()).isTrue();
        assertThat(matcher.group()).isEqualTo("dep");
    }

    /**
     * 4. Show count of employee for {department_name}.
     * Answer: {employee_count}
     */
    @Test
    public void employee_count_pattern() {
        Pattern case4 = Pattern.compile("(?<=Show count of employee for ).*");
        String input = "Show count of employee for dep";

        Matcher matcher = case4.matcher(input);

        assertThat(matcher.find()).isTrue();
        assertThat(matcher.group()).isEqualTo("dep");
    }

    /**
     * 5. Global search by {template}.
     * Example: Global search by van
     * Answer: Ivan Petrenko, Petro Ivanov
     */
    @Test
    public void global_search_pattern() {
        Pattern case5 = Pattern.compile("(?<=Global search by ).*");
        String input = "Global search by temp";

        Matcher matcher = case5.matcher(input);

        assertThat(matcher.find()).isTrue();
        assertThat(matcher.group()).isEqualTo("temp");
    }
}
