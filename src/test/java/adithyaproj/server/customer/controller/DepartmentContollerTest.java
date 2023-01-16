package adithyaproj.server.customer.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import adithyaproj.server.customer.enitity.Department;
import adithyaproj.server.customer.service.DepartmentService;

@WebMvcTest(DepartmentContoller.class)
public class DepartmentContollerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private DepartmentService departmentService;
        private Department department;

        @BeforeEach
        void setUp() {
                department = Department.builder()
                                .departmentAddress("ahmedabad")
                                .departmentCode("IT-06")
                                .departmentName("IT")
                                .departmentId(1L)
                                .build();
        }

        @Test
        void testSaveDepartment() throws Exception {
                Department inputDepartment = Department.builder()
                                .departmentAddress("ahmedabad")
                                .departmentCode("IT-06")
                                .departmentName("IT")
                                .build();

                Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

                mockMvc.perform(MockMvcRequestBuilders.post("/department")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{" +
                                                "\"departmentName\": \"IT\",\n" +
                                                "\"departmentAddress\": \"ahmedabad\",\n" +
                                                "\"departmentCode\":\"IT-06\"\n" +
                                                "}"))
                                .andExpect(MockMvcResultMatchers.status().isOk());

        }

        @Test
        void testGetDepartmentById() throws Exception {
                Mockito.when(departmentService.getDepartmentById(1L))
                                .thenReturn(department);

                // mockMvc.perform(get("/department/1")
                // .contentType(MediaType.APPLICATION_JSON))
                // .andExpect(status().isOk())
                // .andExpect(jsonPath("$.departmentName").Value(department.getDepartmentName()));

                mockMvc.perform(MockMvcRequestBuilders.get("/department/1")
                                .contentType(MediaType.APPLICATION_JSON))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName")
                                                .value(department.getDepartmentName()));
        }
}
