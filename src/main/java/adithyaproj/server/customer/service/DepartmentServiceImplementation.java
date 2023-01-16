package adithyaproj.server.customer.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adithyaproj.server.customer.enitity.Department;
import adithyaproj.server.customer.error.departmentNotFoundException;
import adithyaproj.server.customer.repository.DepartmentRepository;

@Service
public class DepartmentServiceImplementation implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws departmentNotFoundException {
        // TODO Auto-generated method stub
        Optional<Department> department = departmentRepository.findById(departmentId);

        if (!department.isPresent()) {
            throw new departmentNotFoundException("Department Not Available");

            // throw new departmentNotFoundException("Department Not Available");
        }

        return department.get();
    }

    @Override
    public void deletedepartmentById(Long departmentId) {
        // TODO Auto-generated method stub
        departmentRepository.deleteById(departmentId);

    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {

        Department depDb = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDb.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDb.setDepartmentCode(department.getDepartmentCode());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDb.setDepartmentName(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDb);

    }

    @Override
    public Department FetchDepartmentByName(String departmentname) {

        return departmentRepository.findByDepartmentNameIgnoreCase(departmentname);
    }

}
