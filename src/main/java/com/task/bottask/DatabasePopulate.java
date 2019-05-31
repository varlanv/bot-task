package com.task.bottask;

import com.task.bottask.repository.DegreeRepository;
import com.task.bottask.repository.DepartmentRepository;
import com.task.bottask.repository.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DatabasePopulate {

    @Autowired
    private LectorRepository lectorRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DegreeRepository degreeRepository;

    public void populateLectors() {
    }

    public void populateDegrees() {

    }

    public void populateDepartment() {

    }
}
