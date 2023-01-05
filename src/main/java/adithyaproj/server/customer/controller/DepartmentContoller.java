package adithyaproj.server.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import adithyaproj.server.customer.enitity.Department;
import adithyaproj.server.customer.service.DepartmentService;

@RestController
public class DepartmentContoller {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }
}
