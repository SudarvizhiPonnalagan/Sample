package com.user.rights.service;

import com.user.rights.dto.RightsDTO;

import java.util.List;

public interface RightsService {

    List<RightsDTO> getAllRights();

    RightsDTO getRight(Long rightId);

    RightsDTO create(RightsDTO rightsDTO);

    RightsDTO update(RightsDTO rightsDTO);

    Boolean delete(Long rightId);
}
