package com.user.rights.controller;


import com.user.rights.dto.RightsDTO;
import com.user.rights.service.RightsService;
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
@RequestMapping("/rights")
public class RightsController {

    private final RightsService rightsService;

    @Autowired
    RightsController (RightsService rightsService) {
        this.rightsService = rightsService;
    }

    @GetMapping("/getrights/{id}")
    public RightsDTO getRight(@PathVariable("id") Long rightId){
        return rightsService.getRight(rightId);
    }

    @GetMapping("/all")
    public List<RightsDTO> getAllRights() {
        return rightsService.getAllRights();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long rightId) {
        if (!rightsService.delete(rightId)) {
            return "Deleted";
        } else
            return "Unable to Delete";
    }

    @PostMapping(value = "/create")
    public RightsDTO create(@RequestBody RightsDTO rightsDTO) {
        return rightsService.create(rightsDTO);
    }

    @PutMapping(value = "/update")
    public RightsDTO update(@RequestBody RightsDTO rightsDTO) {
        return rightsService.update(rightsDTO);
    }
}
