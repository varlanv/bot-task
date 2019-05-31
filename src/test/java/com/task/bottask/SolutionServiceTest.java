package com.task.bottask;

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
import java.util.NoSuchElementException;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    List<String> departments = asList("Biology", "Chemistry", "Art", "History", "Technology");

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

    public void find_by_template_should_throw_exception_on_incorrect_argument() {
        String template = "aksdak";

        assertThatThrownBy(() -> service.findByTemplate(template))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("No matches for given template '" + template + "'");
    }
}
