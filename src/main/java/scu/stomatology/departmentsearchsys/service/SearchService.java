package scu.stomatology.departmentsearchsys.service;

import org.springframework.stereotype.Service;
import scu.stomatology.departmentsearchsys.dto.DepartmentDTO;
import scu.stomatology.departmentsearchsys.dto.HealthKnowledgeDTO;
import scu.stomatology.departmentsearchsys.dto.ImageDTO;
import scu.stomatology.departmentsearchsys.util.Response;

import java.util.List;

public interface SearchService {

    /**
     * 获取轮播图的url列表
     * @return
     */
    Response<List<ImageDTO>> getPictures(String type);

    Response<List<HealthKnowledgeDTO>> getHealthKnowledge();

    Response<List<DepartmentDTO>> getAllDepartments();

    Response<List<DepartmentDTO>> search(String keywords);
}
