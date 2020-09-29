package scu.stomatology.departmentsearchsys;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import scu.stomatology.departmentsearchsys.db.repository.DepartmentRepository;

import javax.annotation.Resource;

@SpringBootTest
class DepartmentsearchsysApplicationTests {

    @Resource
    DepartmentRepository departmentRepository;
    @Test
    void contextLoads() {
        departmentRepository.search("牙痛");
    }

}
