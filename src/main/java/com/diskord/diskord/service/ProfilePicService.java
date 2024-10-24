package com.diskord.diskord.service;

import org.springframework.stereotype.Service;

import com.diskord.diskord.model.ProfilePic;
import com.diskord.diskord.repository.ProfilePicRepository;

import java.util.List;

@Service
public class ProfilePicService {
    private final ProfilePicRepository profilePicRepository;

    public ProfilePicService(ProfilePicRepository profilePicRepository) {
        this.profilePicRepository = profilePicRepository;
    }

    public void addProfilePic(ProfilePic profilePic) {
        profilePicRepository.save(profilePic);
    }

    public void removeProfilePic(int fileId, int userId) {
        profilePicRepository.delete(fileId, userId);
    }

    public List<ProfilePic> getProfilePicsByUserId(int userId) {
        return profilePicRepository.findByUserId(userId);
    }

    public List<ProfilePic> getProfilePicsByFileId(int fileId) {
        return profilePicRepository.findByFileId(fileId);
    }
}
