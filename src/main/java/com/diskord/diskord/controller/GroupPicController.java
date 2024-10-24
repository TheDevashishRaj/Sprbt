package com.diskord.diskord.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diskord.diskord.model.GroupPic;
import com.diskord.diskord.service.GroupPicService;

@RestController
@RequestMapping("/api/grouppics")
public class GroupPicController {
    private final GroupPicService groupPicService;

    public GroupPicController(GroupPicService groupPicService) {
        this.groupPicService = groupPicService;
    }

    @PostMapping
    public ResponseEntity<Void> createGroupPic(@RequestBody GroupPic groupPic) {
        groupPicService.addGroupPic(groupPic);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{fileId}/{groupId}")
    public ResponseEntity<Void> deleteGroupPic(@PathVariable int fileId, @PathVariable int groupId) {
        groupPicService.removeGroupPic(fileId, groupId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/group/{groupId}")
    public ResponseEntity<List<GroupPic>> getGroupPicsByGroupId(@PathVariable int groupId) {
        List<GroupPic> groupPics = groupPicService.getGroupPicsByGroupId(groupId);
        return new ResponseEntity<>(groupPics, HttpStatus.OK);
    }

    @GetMapping("/file/{fileId}")
    public ResponseEntity<List<GroupPic>> getGroupPicsByFileId(@PathVariable int fileId) {
        List<GroupPic> groupPics = groupPicService.getGroupPicsByFileId(fileId);
        return new ResponseEntity<>(groupPics, HttpStatus.OK);
    }
}