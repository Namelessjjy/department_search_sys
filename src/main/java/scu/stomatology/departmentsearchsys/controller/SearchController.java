package scu.stomatology.departmentsearchsys.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import scu.stomatology.departmentsearchsys.dto.DepartmentDTO;
import scu.stomatology.departmentsearchsys.dto.HealthKnowledgeDTO;
import scu.stomatology.departmentsearchsys.dto.ImageDTO;
import scu.stomatology.departmentsearchsys.service.SearchService;
import scu.stomatology.departmentsearchsys.util.Response;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class SearchController {

    @Resource
    private SearchService searchService;

    @GetMapping("/pictures")
    public Response<List<ImageDTO>> getPictures(@RequestParam("type")String type) {
        return searchService.getPictures(type);
    }

    @GetMapping("/healthknowledge")
    public Response<List<HealthKnowledgeDTO>> getHealthKnowledge() {
        return searchService.getHealthKnowledge();
    }

    @GetMapping("/getDepartments")
    public Response<List<DepartmentDTO>> getDeparments() {
        return searchService.getAllDepartments();
    }

    @GetMapping("/search")
    public Response<List<DepartmentDTO>> search(@RequestParam("keywords")String keywords) {
        return searchService.search(keywords);
    }
}
