package com.diskord.diskord.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diskord.diskord.model.CommunityGroups;
import com.diskord.diskord.service.CommunityGroupsService;

@RestController
@RequestMapping("/api/community-groups")
public class CommunityGroupsController {

    @Autowired
    private CommunityGroupsService communityGroupsService;

    // Add a community-group relationship
    @PostMapping("/add")
    public ResponseEntity<String> addCommunityGroup(@RequestBody CommunityGroups communityGroup) {
        try {
            communityGroupsService.addCommunityGroup(communityGroup);
            return new ResponseEntity<>("Community-Group relationship added successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add relationship.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete a community-group relationship
    @PostMapping("/delete")
    public ResponseEntity<String> deleteCommunityGroup(@RequestBody CommunityGroups communityGroup) {
        try {
            communityGroupsService.removeCommunityGroup(communityGroup.getGroupId(), communityGroup.getCommunityId());
            return new ResponseEntity<>("Community-Group relationship deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete relationship.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get groups by community ID
    @GetMapping("/groups/{communityId}")
    public ResponseEntity<List<CommunityGroups>> getGroupsByCommunityId(@PathVariable int communityId) {
        try {
            List<CommunityGroups> groups = communityGroupsService.getGroupsByCommunityId(communityId);
            return new ResponseEntity<>(groups, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get communities by group ID
    @GetMapping("/communities/{groupId}")
    public ResponseEntity<List<CommunityGroups>> getCommunitiesByGroupId(@PathVariable int groupId) {
        try {
            List<CommunityGroups> communities = communityGroupsService.getCommunitiesByGroupId(groupId);
            return new ResponseEntity<>(communities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}