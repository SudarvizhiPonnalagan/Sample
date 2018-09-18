package com.user.rights.service.Impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.rights.dto.RightsDTO;
import com.user.rights.entity.Rights;
import com.user.rights.repository.RightsRepository;
import com.user.rights.service.RightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RightsServiceImpl implements RightsService {

    protected final ObjectMapper objectMapper;

    private final RightsRepository rightsRepository;

    @Autowired
    RightsServiceImpl (RightsRepository rightsRepository) {
        this.rightsRepository = rightsRepository;
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    @Override
    public List<RightsDTO> getAllRights() {
        return objectMapper.convertValue(rightsRepository.findAll(), new TypeReference<List<RightsDTO>>(){});
    }

    @Override
    public RightsDTO getRight(Long rightId) {
        return objectMapper.convertValue(rightsRepository.getOne(rightId), RightsDTO.class);
    }

    @Override
    public RightsDTO create(RightsDTO rightsDTO) {
        Rights rights = objectMapper.convertValue(rightsDTO, Rights.class);
        if (rights.getId() != null) {
            // throw new Exception("Create a new branch should not contain id");
        }
        setRightsDefaults(rights);
        return objectMapper.convertValue(rightsRepository.save(rights), RightsDTO.class);
    }

    @Override
    public RightsDTO update(RightsDTO rightsDTO) {
        Rights rights = objectMapper.convertValue(rightsDTO, Rights.class);
        if (rights.getId() == null) {
            // TODO: Custom Exception should thrown
            // throw new Exception("Update an existing branch should contain id");
        }
        setRightsDefaults(rights);
        return objectMapper.convertValue(rightsRepository.save(rights), RightsDTO.class);
    }

    @Override
    public Boolean delete(Long rightId) {
        rightsRepository.deleteById(rightId);
        return rightsRepository.findById(rightId).isPresent();
    }

    private void setRightsDefaults(Rights rights) {
        if (rights.getId() == null) {
            //rights.setCreatedDate(new Date());
            // TODO: This default will be removed once admin_user services available
           // branch.setCreatedBy(1L);
        //} else if (branch.getCreatedDate() == null || branch.getCreatedBy() == null) {
            Rights tempRights = rightsRepository.getOne(rights.getId());
            //rights.setCreatedDate(tempRights.getCreatedDate());
            //rights.setCreatedBy(tempRights.getCreatedBy());
        }
       // rights.setUpdatedDate(new Date());
        // TODO: This default will be removed once admin_user services available
       // rights.setUpdatedBy(1L);
    }
}
