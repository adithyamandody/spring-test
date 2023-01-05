package adithyaproj.server.customer.service;

import java.util.List;

import adithyaproj.server.customer.enitity.Department;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> getDepartment();

    public Department getDepartmentById(Long departmentId);

    public void deletedepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

}
