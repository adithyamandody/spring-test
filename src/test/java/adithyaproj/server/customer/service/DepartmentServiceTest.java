package adithyaproj.server.customer.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import adithyaproj.server.customer.enitity.Department;
import adithyaproj.server.customer.repository.DepartmentRepository;

@SpringBootTest
public class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Ahmmedabad")
                .departmentCode("IT:cs")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);

    }

    @Test
    @DisplayName(" Get Data based on valid Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {

        String departmentName = "IT";
        Department found = departmentService.FetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());

    }
}
