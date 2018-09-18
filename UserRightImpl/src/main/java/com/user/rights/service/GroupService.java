package com.user.rights.service;

import com.user.rights.dto.GroupsDTO;

import java.util.List;

public interface GroupService {

    List<GroupsDTO> getAllGroups();

    GroupsDTO getGroup(Long groupId);

    GroupsDTO create(GroupsDTO groupDTO);

    GroupsDTO update(GroupsDTO groupDTO);

    Boolean delete(Long groupId);
}
