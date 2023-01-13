package adithyaproj.server.customer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import adithyaproj.server.customer.enitity.Department;
import adithyaproj.server.customer.service.DepartmentService;

@RestController
public class DepartmentContoller {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/department")
    public List<Department> getDepartment() {
        return departmentService.getDepartment();
    }

    @GetMapping("/department/{id}")
    public Department getDepartmentById(@PathVariable("id") Long DepartmentId) {
        return departmentService.getDepartmentById(DepartmentId);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long DepartmentId) {
        departmentService.deletedepartmentById(DepartmentId);
        return "depart successfully deleted";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@PathVariable Long DepartmentId, @RequestBody Department department) {
        return departmentService.updateDepartment(DepartmentId, department);
    }

    @GetMapping("/department/name/{name}")
    public Department FetchDepartmentByName(@PathVariable("name") String departmentname) {
        return departmentService.FetchDepartmentByName(departmentname);
    }
}
