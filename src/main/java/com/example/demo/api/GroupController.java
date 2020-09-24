package com.example.demo.api;

import com.example.demo.domain.ChangeGroupNameRequest;
import com.example.demo.domain.Group;
import com.example.demo.entity.GroupEntity;
import com.example.demo.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/groups")
    @ResponseStatus(HttpStatus.OK)
    public List<GroupEntity> getAllGroups() {
        return groupService.getAllGroups();
    }

    @PatchMapping("/groups/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void changeGroupName(@PathVariable long id,@RequestBody ChangeGroupNameRequest request) {
        groupService.changeGroupName(id,request);
    }

}
