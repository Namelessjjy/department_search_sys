package scu.stomatology.departmentsearchsys.db.repository;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import scu.stomatology.departmentsearchsys.db.entity.HealthKnowledge;
import scu.stomatology.departmentsearchsys.db.entity.Image;
import scu.stomatology.departmentsearchsys.dto.HealthKnowledgeDTO;
import scu.stomatology.departmentsearchsys.dto.ImageDTO;
import scu.stomatology.departmentsearchsys.util.Response;
import scu.stomatology.departmentsearchsys.util.ResponseStatusEnum;
import scu.stomatology.departmentsearchsys.vo.ImageVO;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class HealthKnowledgeRepository {

    @Resource
    private HealthKnowledgeJpaRepository healthKnowledgeJpaRepository;

    @Resource
    private ImageRepository imageRepository;


    public Response<List<HealthKnowledgeDTO>> getHealthKnowledge() {
        List<HealthKnowledge> list = healthKnowledgeJpaRepository.findAll();
        List<HealthKnowledgeDTO> healthKnowledgeDTOS = list.stream().map(healthKnowledge -> {
            HealthKnowledgeDTO healthKnowledgeDTO = new HealthKnowledgeDTO();
            healthKnowledgeDTO.setId(healthKnowledge.getId());
            healthKnowledgeDTO.setIcon(healthKnowledge.getIcon());
            healthKnowledgeDTO.setColor(healthKnowledge.getColor());
            healthKnowledgeDTO.setInfo(healthKnowledge.getInfo());
            healthKnowledgeDTO.setName(healthKnowledge.getName());
            if (healthKnowledge.getImg() != null && !"".equals(healthKnowledge.getImg())) {
                String[] idsStr = healthKnowledge.getImg().split(",");
                List<Long> ids = new ArrayList<>();
                for (String s : idsStr) {
                    ids.add(Long.valueOf(s));
                }

                List<Image> images = imageRepository.getPictureListByIds(ids);
                List<ImageDTO> imageDTOS = images.stream().map(image -> {
                    ImageDTO imageDTO = new ImageDTO();
                    BeanUtils.copyProperties(imageDTO, image);
                    return imageDTO;
                }).collect(Collectors.toList());
                healthKnowledgeDTO.setImages(imageDTOS);

            } else {
                healthKnowledgeDTO.setImages(new ArrayList<>());
            }
            return healthKnowledgeDTO;
        }).collect(Collectors.toList());
        return Response.valueOf(ResponseStatusEnum.OK, healthKnowledgeDTOS);
    }
}
