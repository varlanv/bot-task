package com.task.bottask;

import com.task.bottask.domain.Lector;
import com.task.bottask.repository.DepartmentRepository;
import com.task.bottask.repository.LectorRepository;
import com.task.bottask.service.SolService;
import com.task.bottask.service.SolutionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(SolutionService.class)
@Sql(scripts = {"classpath:/schema.sql", "classpath:/data.sql"})
@RunWith(SpringRunner.class)
public class SolutionServiceTest {

    @Autowired
    SolService service;
    @Autowired
    LectorRepository lectorRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @Test
    public void context_should_construct() {
        assertThat(service).isNotNull();
    }

    @Test
    public void one() {
        Lector lector = service.headOfDepartment("Biology");
        assertThat(lector.getLastName()).isEqualTo("Dawkings");
    }

    @Test
    public void two() {
        Map<String, Long> chemistry = service.departmentStatistics("Chemistry");

        assertThat(chemistry).extracting("professor", "assistant").containsOnly(1L, 2L);
    }


    @Test
    public void three() {
        String chemistry = service.averageSalary("Chemistry");

        assertThat(chemistry).isEqualTo("10666.67"); //13000+9000+10000 / 3

    }

    @Test
    public void four() {
        int chemistry = service.lectorsCount("Chemistry");

        assertThat(chemistry).isEqualTo(3);
    }

    //
    @Test
    public void five() {
        List<Lector> daw = service.findByTemplate("daw");

        assertThat(daw.size()).isEqualTo(1);
        assertThat(daw).extracting("lastName").containsOnly("Dawkings");
    }
}
