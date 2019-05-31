package com.task.bottask.service;

import com.task.bottask.domain.Department;
import com.task.bottask.domain.Lector;
import com.task.bottask.repository.DepartmentRepository;
import com.task.bottask.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class SolutionService implements SolService {

    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;

    @Autowired
    public SolutionService(DepartmentRepository departmentRepository, LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
        this.departmentRepository = departmentRepository;
    }

    public Lector headOfDepartment(String department) {
        return lectorRepository
                .headOfDepartment(department)
                .orElseThrow(() -> new NoSuchElementException("Department does not exist"));
    }

    private List<Lector> lectorsByDepartment(String departmentName) {
        Department department =
                departmentRepository
                        .findByName(departmentName)
                        .orElseThrow(() -> new NoSuchElementException("Department does not exist"));
        return department.getLectors();
    }

    public Map<String, Long> departmentStatistics(String departmentName) {
        List<Lector> lectors = lectorsByDepartment(departmentName);

        Map<String, Long> degreeName_Count =
                lectors.stream()
                        .collect(Collectors.groupingBy
                                (lector -> lector.getDegree().getTitle(), Collectors.counting()));

        return degreeName_Count;
    }

    public String averageSalary(String departmentName) {
        List<Lector> lectors = lectorsByDepartment(departmentName);

        BigDecimal totalSalary =
                lectors.stream()
                        .map(lector -> new BigDecimal(lector.getSalary()))
                        .reduce(new BigDecimal("0"), BigDecimal::add);

        BigDecimal averageSalary = totalSalary.divide(new BigDecimal(lectors.size()), MathContext.DECIMAL32);

        return averageSalary.toPlainString();
    }

    public int lectorsCount(String departmentName) {
        Department department = departmentRepository
                .findByName(departmentName)
                .orElseThrow(() -> new NoSuchElementException("Department does not exist"));

        return department.getLectors().size();
    }

    public List<Lector> findByTemplate(String template) {
        return lectorRepository.findByTemplate(template);
    }
}
