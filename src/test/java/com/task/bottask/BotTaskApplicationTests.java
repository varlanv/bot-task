//package com.task.bottask;
//
//import com.task.bottask.domain.Degree;
//import com.task.bottask.domain.Department;
//import com.task.bottask.domain.Lector;
//import com.task.bottask.repository.DegreeRepository;
//import com.task.bottask.repository.DepartmentRepository;
//import com.task.bottask.repository.LectorRepository;
//import com.task.bottask.service.SolutionService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//import java.util.Map;
//
//import static java.util.Arrays.asList;
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest()
////@SpringBootTest
////@AutoConfigureTestEntityManager
//public class BotTaskApplicationTests {
//
//    @Autowired
//    LectorRepository lectorRepository;
//    @Autowired
//    DepartmentRepository departmentRepository;
//    @Autowired
//    DegreeRepository degreeRepository;
//    @Autowired
//    TestEntityManager entityManager;
//    SolutionService service;
//
//    @Before
//    public void bef() {
//        service = new SolutionService(departmentRepository, degreeRepository, lectorRepository);
//    }
//
//    @Test
//    public void contextLoads() {
//    }
//
//    @Test
//    public void abc() {
//        Degree degree = new Degree();
//        Department department = new Department();
//        Lector lector = new Lector();
//
//        Lector lector1 = entityManager.persistFlushFind(lector);
//        Department department1 = entityManager.persistFlushFind(department);
//        Degree degree1 = entityManager.persistFlushFind(degree);
//
//        assertThat(lector).isEqualTo(lector1);
//        assertThat(department).isEqualTo(department1);
//        assertThat(degree).isEqualTo(degree1);
//    }
//
//    @Test
//    public void relations() {
//        Degree degree = new Degree();
//        degree.setTitle("associate");
//
//        Degree degree2 = new Degree();
//        degree2.setTitle("professor");
//
//
//        Department department = new Department();
//        department.setTitle("dep");
//
//        Lector lector = new Lector();
//        lector.setDegree(degree);
//        lector.setDepartments(asList(department));
//
//        Lector lector2 = new Lector();
//        lector2.setDegree(degree2);
//        lector2.setDepartments(asList((department)));
//
//        degree.setLectors(asList(lector));
//        degree2.setLectors(asList(lector2));
//
//        department.setLectors(asList(lector, lector2));
//
//        Department foundDepartment = entityManager.persistFlushFind(department);
//        Degree foundDegree = entityManager.persistFlushFind(degree);
//        Degree foundDegree2 = entityManager.persistFlushFind(degree2);
//        Lector foundLector = entityManager.persistFlushFind(lector);
//        Lector foundLector2 = entityManager.persistFlushFind(lector2);
//
//        assertThat(foundDepartment.getLectors()).containsAll(department.getLectors());
//        assertThat(foundLector.getDegree()).isEqualTo(degree);
//        assertThat(foundLector2.getDegree()).isEqualTo(degree2);
//        assertThat(foundDegree.getLectors()).containsOnly(lector);
//        assertThat(foundDegree2.getLectors()).containsOnly(lector2);
//    }
//
//
//    @Test
//    public void n1() {
//        Degree degree = new Degree();
//        degree.setTitle("associate");
//
//        Degree degree2 = new Degree();
//        degree2.setTitle("professor");
//
//
//        Department department = new Department();
//        department.setTitle("dep");
//
//        Lector lector = new Lector();
//        lector.setFirstName("Namae");
//        lector.setLastName("Fandorin");
//        lector.setDegree(degree);
//        lector.setDepartments(asList(department));
//        lector.setSalary("50");
//
//        Lector lector4 = new Lector();
//        lector4.setDegree(degree);
//        lector4.setDepartments(asList(department));
//        lector4.setSalary("10");
//        lector.setFirstName("Taras");
//        lector.setLastName("Pushkin");
//        lector.setHeadOfDepartment(true);
//
//        Lector lector2 = new Lector();
//        lector2.setDegree(degree2);
//        lector2.setDepartments(asList((department)));
//        lector2.setSalary("30");
//        lector.setFirstName("Chelya");
//        lector.setLastName("Kusina");
//
//        degree.setLectors(asList(lector));
//        degree2.setLectors(asList(lector2));
//
//        department.setLectors(asList(lector, lector2));
//
//        Department foundDepartment = entityManager.persistFlushFind(department);
//        Degree foundDegree = entityManager.persistFlushFind(degree);
//        Degree foundDegree2 = entityManager.persistFlushFind(degree2);
//        Lector foundLector = entityManager.persistFlushFind(lector);
//        Lector foundLector2 = entityManager.persistFlushFind(lector2);
//        Lector fondLector4 = entityManager.persistAndFlush(lector4);
//
//
//        Lector lector1 = service.headOfDepartment("dep");
//
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println(lector1);
//    }
//
//    @Test
//    public void n2() {
//        Degree degree = new Degree();
//        degree.setTitle("associate");
//
//        Degree degree2 = new Degree();
//        degree2.setTitle("professor");
//
//
//        Department department = new Department();
//        department.setTitle("dep");
//
//        Lector lector = new Lector();
//        lector.setDegree(degree);
//        lector.setDepartments(asList(department));
//
//        Lector lector4 = new Lector();
//        lector4.setDegree(degree);
//        lector4.setDepartments(asList(department));
//
//        Lector lector2 = new Lector();
//        lector2.setDegree(degree2);
//        lector2.setDepartments(asList((department)));
//
//        degree.setLectors(asList(lector));
//        degree2.setLectors(asList(lector2));
//
//        department.setLectors(asList(lector, lector2));
//
//        Department foundDepartment = entityManager.persistFlushFind(department);
//        Degree foundDegree = entityManager.persistFlushFind(degree);
//        Degree foundDegree2 = entityManager.persistFlushFind(degree2);
//        Lector foundLector = entityManager.persistFlushFind(lector);
//        Lector foundLector2 = entityManager.persistFlushFind(lector2);
//        Lector fondLector4 = entityManager.persistAndFlush(lector4);
//
//        Map<String, Long> dep = service.departmentStatistics("dep");
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//
//
//        System.out.println(dep);
//    }
//
//    @Test
//    public void n3() {
//        Degree degree = new Degree();
//        degree.setTitle("associate");
//
//        Degree degree2 = new Degree();
//        degree2.setTitle("professor");
//
//
//        Department department = new Department();
//        department.setTitle("dep");
//
//        Lector lector = new Lector();
//        lector.setDegree(degree);
//        lector.setDepartments(asList(department));
//        lector.setSalary("50");
//
//        Lector lector4 = new Lector();
//        lector4.setDegree(degree);
//        lector4.setDepartments(asList(department));
//        lector4.setSalary("10");
//
//        Lector lector2 = new Lector();
//        lector2.setDegree(degree2);
//        lector2.setDepartments(asList((department)));
//        lector2.setSalary("30");
//
//        degree.setLectors(asList(lector));
//        degree2.setLectors(asList(lector2));
//
//        department.setLectors(asList(lector, lector2));
//
//        Department foundDepartment = entityManager.persistFlushFind(department);
//        Degree foundDegree = entityManager.persistFlushFind(degree);
//        Degree foundDegree2 = entityManager.persistFlushFind(degree2);
//        Lector foundLector = entityManager.persistFlushFind(lector);
//        Lector foundLector2 = entityManager.persistFlushFind(lector2);
//        Lector fondLector4 = entityManager.persistAndFlush(lector4);
//
//
//        String dep = service.averageSalary("dep");
//
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//
//
//        System.out.println(dep);
//    }
//
//
//    @Test
//    public void n5() {
//        Degree degree = new Degree();
//        degree.setTitle("associate");
//
//        Degree degree2 = new Degree();
//        degree2.setTitle("professor");
//
//
//        Department department = new Department();
//        department.setTitle("dep");
//
//        Lector lector = new Lector();
//        lector.setFirstName("Namae");
//        lector.setLastName("Fandorin");
//        lector.setDegree(degree);
//        lector.setDepartments(asList(department));
//        lector.setSalary("50");
//
//        Lector lector4 = new Lector();
//        lector4.setDegree(degree);
//        lector4.setDepartments(asList(department));
//        lector4.setSalary("10");
//        lector.setFirstName("Taras");
//        lector.setLastName("Pushkin");
//
//        Lector lector2 = new Lector();
//        lector2.setDegree(degree2);
//        lector2.setDepartments(asList((department)));
//        lector2.setSalary("30");
//        lector.setFirstName("Chelya");
//        lector.setLastName("Kusina");
//
//        degree.setLectors(asList(lector));
//        degree2.setLectors(asList(lector2));
//
//        department.setLectors(asList(lector, lector2));
//
//        Department foundDepartment = entityManager.persistFlushFind(department);
//        Degree foundDegree = entityManager.persistFlushFind(degree);
//        Degree foundDegree2 = entityManager.persistFlushFind(degree2);
//        Lector foundLector = entityManager.persistFlushFind(lector);
//        Lector foundLector2 = entityManager.persistFlushFind(lector2);
//        Lector fondLector4 = entityManager.persistAndFlush(lector4);
//
//
//        List<Lector> che = service.findByTemplate("che");
//        System.out.println(che);
//    }
//}
