package com.task.bottask;

import com.task.bottask.domain.Lector;
import com.task.bottask.repository.DepartmentRepository;
import com.task.bottask.repository.LectorRepository;
import com.task.bottask.service.SolutionService;
import com.task.bottask.service.SolutionServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(SolutionServiceImpl.class)
@Sql(scripts = {"classpath:/schema.sql", "classpath:/data.sql"})
@RunWith(SpringRunner.class)
public class SolutionServiceTest {

    @Autowired
    SolutionService service;
    @Autowired
    LectorRepository lectorRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    final List<String> departments = asList("Biology", "Chemistry", "Art", "History", "Technology");

    @Test
    public void context_should_construct() {
        assertThat(service).isNotNull();
    }

    @Test
    public void department_should_have_head() {
        departments.forEach(d ->
                assertThat(service.headOfDepartment(d)).isNotNull());
    }

    @Test
    public void two() {
        long professors = 1;
        long assistants = 2;
        Map<String, Long> chemistry = service.departmentStatistics("Chemistry");

        assertThat(chemistry).extracting("professor", "assistant").containsOnly(professors, assistants);
    }

    @Test
    public void tt() {
        departments.forEach(d -> service.departmentStatistics(d));
    }

    @Test
    public void three() {
        String chemistry = service.averageSalary("Chemistry");

        assertThat(chemistry).isEqualTo("10666.67"); //13000+9000+10000 / 3
    }

    @Test
    public void thr() {
        departments.forEach(d -> service.averageSalary(d));
    }

    @Test
    public void four() {
        int chemistry = service.lectorsCount("Chemistry");

        assertThat(chemistry).isEqualTo(3);
    }

    @Test
    public void fr() {
        departments.forEach(d -> service.lectorsCount(d));
    }

    @Test
    public void five() {
        List<Lector> daw = service.findByTemplate("daw");

        assertThat(daw.size()).isEqualTo(1);
        assertThat(daw).extracting("lastName").containsOnly("Dawkings");
    }
}
