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

import com.diskord.diskord.model.ProfilePic;
import com.diskord.diskord.service.ProfilePicService;

@RestController
@RequestMapping("/api/profilepics")
public class ProfilePicController {
    private final ProfilePicService profilePicService;

    public ProfilePicController(ProfilePicService profilePicService) {
        this.profilePicService = profilePicService;
    }

    @PostMapping
    public ResponseEntity<Void> createProfilePic(@RequestBody ProfilePic profilePic) {
        profilePicService.addProfilePic(profilePic);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{fileId}/{userId}")
    public ResponseEntity<Void> deleteProfilePic(@PathVariable int fileId, @PathVariable int userId) {
        profilePicService.removeProfilePic(fileId, userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ProfilePic>> getProfilePicsByUserId(@PathVariable int userId) {
        List<ProfilePic> profilePics = profilePicService.getProfilePicsByUserId(userId);
        return new ResponseEntity<>(profilePics, HttpStatus.OK);
    }

    @GetMapping("/file/{fileId}")
    public ResponseEntity<List<ProfilePic>> getProfilePicsByFileId(@PathVariable int fileId) {
        List<ProfilePic> profilePics = profilePicService.getProfilePicsByFileId(fileId);
        return new ResponseEntity<>(profilePics, HttpStatus.OK);
    }
}