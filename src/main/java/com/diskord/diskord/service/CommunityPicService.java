package com.diskord.diskord.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.diskord.diskord.model.CommunityPic;
import com.diskord.diskord.repository.CommunityPicRepository;

@Service
public class CommunityPicService {

    private final CommunityPicRepository communityPicRepository;

    public CommunityPicService(CommunityPicRepository communityPicRepository) {
        this.communityPicRepository = communityPicRepository;
    }

    public CommunityPic saveCommunityPic(CommunityPic communityPic) {
        communityPicRepository.save(communityPic);
        return communityPic;
    }

    public List<CommunityPic> getAllCommunityPics() {
        return communityPicRepository.findAll();
    }

    public CommunityPic getCommunityPicById(int fileId, int communityId) {
        return communityPicRepository.findById(fileId, communityId);
    }

    public void deleteCommunityPic(int fileId, int communityId) {
        communityPicRepository.delete(fileId, communityId);
    }
}