package com.example.demo.api;

import com.example.demo.domain.Group;
import com.example.demo.entity.GroupEntity;
import com.example.demo.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:1234")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService){
        this.groupService = groupService;
    }

    @PostMapping("/groups/auto-grouping")
    @ResponseStatus(HttpStatus.OK)
    public List<GroupEntity> autoGrouping(){
        return groupService.autoGrouping();
    }
}
