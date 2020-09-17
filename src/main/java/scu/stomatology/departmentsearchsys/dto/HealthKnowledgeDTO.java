package scu.stomatology.departmentsearchsys.dto;

import lombok.Data;

import java.util.List;

@Data
public class HealthKnowledgeDTO {

    private Long id;

    private String icon;

    private String color;

    private String name;

    private String info;

    private List<ImageDTO> images;
}
