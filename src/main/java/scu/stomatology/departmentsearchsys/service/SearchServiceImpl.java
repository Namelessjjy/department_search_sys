package scu.stomatology.departmentsearchsys.service;

import org.springframework.stereotype.Service;
import scu.stomatology.departmentsearchsys.db.repository.DepartmentRepository;
import scu.stomatology.departmentsearchsys.db.repository.HealthKnowledgeRepository;
import scu.stomatology.departmentsearchsys.db.repository.ImageRepository;
import scu.stomatology.departmentsearchsys.dto.DepartmentDTO;
import scu.stomatology.departmentsearchsys.dto.HealthKnowledgeDTO;
import scu.stomatology.departmentsearchsys.dto.ImageDTO;
import scu.stomatology.departmentsearchsys.util.Response;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService{

    @Resource
    private ImageRepository imageRepository;

    @Resource
    private HealthKnowledgeRepository healthKnowledgeRepository;

    @Resource
    private DepartmentRepository departmentRepository;


    @Override
    public Response<List<ImageDTO>> getPictures(String type) {
        return imageRepository.getPictureList(type);
    }

    @Override
    public Response<List<HealthKnowledgeDTO>> getHealthKnowledge() {
        return healthKnowledgeRepository.getHealthKnowledge();
    }

    @Override
    public Response<List<DepartmentDTO>> getAllDepartments() {
        return departmentRepository.getAllDepartments();
    }

    @Override
    public Response<List<DepartmentDTO>> search(String keywords) {
        return departmentRepository.search(keywords);
    }
}
