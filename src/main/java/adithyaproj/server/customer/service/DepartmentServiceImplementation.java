package adithyaproj.server.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adithyaproj.server.customer.enitity.Department;
import adithyaproj.server.customer.repository.DepartmentRepository;

@Service
public class DepartmentServiceImplementation implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

}
