package scu.stomatology.departmentsearchsys.dto;

import lombok.Data;

import java.util.List;

@Data
public class DepartmentDTO {

    private Long id;

    private String name;

    private String info;

    private List<String> symptom;

    private String subDepartment;

}
