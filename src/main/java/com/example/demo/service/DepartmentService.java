package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Department;

public interface DepartmentService {

    Department saveDepartment(Department department);

    List<Department> getAllDepartments();

    void deleteDepartment(int id);
}