package scu.stomatology.departmentsearchsys.db.repository;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import scu.stomatology.departmentsearchsys.db.entity.Image;
import scu.stomatology.departmentsearchsys.dto.ImageDTO;
import scu.stomatology.departmentsearchsys.util.Response;
import scu.stomatology.departmentsearchsys.util.ResponseStatusEnum;
import scu.stomatology.departmentsearchsys.vo.ImageVO;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ImageRepository {

    @Resource
    private ImageJpaRepository imageJpaRepository;


    public Response<List<ImageDTO>> getPictureList() {
        List<Image> list = imageJpaRepository.findAll();
        List<ImageDTO> imageDTOS = list.stream().map(image -> {
            ImageDTO imageDTO = new ImageDTO();
            BeanUtils.copyProperties(imageDTO, image);
            return imageDTO;
        }).collect(Collectors.toList());
        return Response.valueOf(ResponseStatusEnum.OK, imageDTOS);
    }

    public List<Image> getPictureListByIds(List<Long> ids) {
        return imageJpaRepository.findByIdIn(ids);
    }
}
