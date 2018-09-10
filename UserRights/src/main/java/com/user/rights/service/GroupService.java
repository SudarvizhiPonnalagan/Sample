package com.user.rights.service;

import com.user.rights.dto.GroupDTO;

import java.util.List;

public interface GroupService {

    List<GroupDTO> getAllGroups();

    GroupDTO getGroup(Long groupId);

    GroupDTO create(GroupDTO groupDTO);

    GroupDTO update(GroupDTO groupDTO);

    Boolean delete(Long groupId);
}
