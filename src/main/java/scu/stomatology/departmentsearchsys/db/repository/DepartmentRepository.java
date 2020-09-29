package scu.stomatology.departmentsearchsys.db.repository;


import org.springframework.stereotype.Repository;
import scu.stomatology.departmentsearchsys.db.entity.Department;
import scu.stomatology.departmentsearchsys.dto.DepartmentDTO;

import scu.stomatology.departmentsearchsys.util.Response;
import scu.stomatology.departmentsearchsys.util.ResponseStatusEnum;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DepartmentRepository {

    @Resource
    private DepartmentJpaRepository departmentJpaRepository;

    public Response<List<DepartmentDTO>> getAllDepartments() {
        List<Department> departments = departmentJpaRepository.findAll();
        List<DepartmentDTO> departmentDTOS = transferToDepartmentDTOs(departments);
        return Response.valueOf(ResponseStatusEnum.OK, departmentDTOS);
    }

    public Response<List<DepartmentDTO>> search(String keywords) {
        StringBuilder sb = new StringBuilder();
        sb.append("%");
        for(Character c : keywords.toCharArray()) {
            sb.append(c).append("%");
        }
        List<Department> departments = departmentJpaRepository.search(sb.toString());
        List<DepartmentDTO> departmentDTOS = transferToDepartmentDTOs(departments);
        return Response.valueOf(ResponseStatusEnum.OK, departmentDTOS);
    }

    private List<DepartmentDTO> transferToDepartmentDTOs(List<Department> departments) {
        List<DepartmentDTO> departmentDTOS = departments.stream().map(department -> {
            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setId(department.getId());
            departmentDTO.setName(department.getName());
            departmentDTO.setInfo(department.getInfo());
            String[] symptoms = department.getSymptom().split(",");
            List<String> list = Arrays.asList(symptoms);
            departmentDTO.setSymptom(list);
            return departmentDTO;
        }).collect(Collectors.toList());
        return departmentDTOS;
    }
}
