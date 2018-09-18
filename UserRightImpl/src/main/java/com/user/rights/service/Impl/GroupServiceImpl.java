package com.user.rights.service.Impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.rights.dto.GroupsDTO;
import com.user.rights.entity.Groups;
import com.user.rights.repository.GroupRepository;
import com.user.rights.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {


    protected final ObjectMapper objectMapper;

    private final GroupRepository groupRepository;

    @Autowired
    GroupServiceImpl (GroupRepository groupRepository){
        this.groupRepository = groupRepository;
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public List<GroupsDTO> getAllGroups() {
        return objectMapper.convertValue(groupRepository.findAll(), new TypeReference<List<GroupsDTO>>(){});
    }

    @Override
    public GroupsDTO getGroup(Long groupId) {
        return objectMapper.convertValue(groupRepository.getOne(groupId), GroupsDTO.class);
    }

    @Override
    public GroupsDTO create(GroupsDTO groupDTO) {
        Groups group = objectMapper.convertValue(groupDTO, Groups.class);
        if (group.getId() != null) {
            // throw new Exception("Create a new branch should not contain id");
        }
        setGroupDefaults(group);
        return objectMapper.convertValue(groupRepository.save(group), GroupsDTO.class);
    }

    @Override
    public GroupsDTO update(GroupsDTO groupDTO) {
        Groups group = objectMapper.convertValue(groupDTO, Groups.class);
        if (group.getId() == null) {
            // TODO: Custom Exception should thrown
            // throw new Exception("Update an existing branch should contain id");
        }
        setGroupDefaults(group);
        return objectMapper.convertValue(groupRepository.save(group), GroupsDTO.class);
    }

    @Override
    public Boolean delete(Long groupId) {
        groupRepository.deleteById(groupId);
        return groupRepository.findById(groupId).isPresent();
    }

    private void setGroupDefaults(Groups group) {
        if (group.getId() == null) {
            //rights.setCreatedDate(new Date());
            // TODO: This default will be removed once admin_user services available
            // branch.setCreatedBy(1L);
            //} else if (branch.getCreatedDate() == null || branch.getCreatedBy() == null) {
            Groups tempGroup = groupRepository.getOne(group.getId());
            //rights.setCreatedDate(tempRights.getCreatedDate());
            //rights.setCreatedBy(tempRights.getCreatedBy());
        }
        // rights.setUpdatedDate(new Date());
        // TODO: This default will be removed once admin_user services available
        // rights.setUpdatedBy(1L);
    }
}
