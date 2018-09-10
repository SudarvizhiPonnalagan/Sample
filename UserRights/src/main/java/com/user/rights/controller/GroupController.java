package com.user.rights.controller;

import com.user.rights.dto.GroupDTO;
import com.user.rights.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    GroupController (GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/getgroup")
    public GroupDTO getGroup(@PathVariable("id") Long groupId){
        return groupService.getGroup(groupId);
    }

    @GetMapping("/all")
    public List<GroupDTO> getAllGroup() {
        return groupService.getAllGroups();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long groupId) {
        if (!groupService.delete(groupId)) {
            return "Deleted";
        } else
            return "Unable to Delete";
    }

    @PostMapping(value = "/create")
    public GroupDTO create(@RequestBody GroupDTO userDTO) {
        return groupService.create(userDTO);
    }

    @PutMapping(value = "/update")
    public GroupDTO update(@RequestBody GroupDTO groupDTO) {
        return groupService.update(groupDTO);
    }
}
