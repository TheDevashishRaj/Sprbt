package com.diskord.diskord.controller;

import com.diskord.diskord.model.Community;
import com.diskord.diskord.service.CommunityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/communities")
public class CommunityController {

    private final CommunityService communityService;

    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @PostMapping
    public ResponseEntity<String> createCommunity(@RequestBody Community community) {
        communityService.createCommunity(community);
        return new ResponseEntity<>("Community created successfully.", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Community> getCommunityById(@PathVariable int id) {
        Community community = communityService.getCommunityById(id);
        if (community != null) {
            return new ResponseEntity<>(community, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Community>> getAllCommunities() {
        List<Community> communities = communityService.getAllCommunities();
        return new ResponseEntity<>(communities, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCommunity(@PathVariable int id, @RequestBody Community community) {
        community.setCommunityId(id);
        communityService.updateCommunity(community);
        return new ResponseEntity<>("Community updated successfully.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCommunity(@PathVariable int id) {
        communityService.deleteCommunity(id);
        return new ResponseEntity<>("Community deleted successfully.", HttpStatus.OK);
    }
}
