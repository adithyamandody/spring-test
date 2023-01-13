package adithyaproj.server.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import adithyaproj.server.customer.enitity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentName(String departmentName);

    public Department findByDepartmentNameIgnoreCase(String departmentName);

}
