package com.diskord.diskord.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diskord.diskord.model.CommunityPic;
import com.diskord.diskord.service.CommunityPicService;

@RestController
@RequestMapping("/api/community_pics")
public class CommunityPicController {

    private final CommunityPicService communityPicService;

    public CommunityPicController(CommunityPicService communityPicService) {
        this.communityPicService = communityPicService;
    }

    // Create a new community picture
    @PostMapping
    public ResponseEntity<CommunityPic> createCommunityPic(@RequestBody CommunityPic communityPic) {
        CommunityPic savedCommunityPic = communityPicService.saveCommunityPic(communityPic);
        return ResponseEntity.ok(savedCommunityPic);
    }

    // Get all community pictures
    @GetMapping
    public ResponseEntity<List<CommunityPic>> getAllCommunityPics() {
        List<CommunityPic> communityPics = communityPicService.getAllCommunityPics();
        return ResponseEntity.ok(communityPics);
    }

    // Get community picture by fileId and communityId
    @GetMapping("/{fileId}/{communityId}")
    public ResponseEntity<CommunityPic> getCommunityPicById(@PathVariable int fileId, @PathVariable int communityId) {
        CommunityPic communityPic = communityPicService.getCommunityPicById(fileId, communityId);
        return ResponseEntity.ok(communityPic);
    }

    // Delete community picture by fileId and communityId
    @DeleteMapping("/{fileId}/{communityId}")
    public ResponseEntity<Void> deleteCommunityPic(@PathVariable int fileId, @PathVariable int communityId) {
        communityPicService.deleteCommunityPic(fileId, communityId);
        return ResponseEntity.noContent().build();
    }
}
