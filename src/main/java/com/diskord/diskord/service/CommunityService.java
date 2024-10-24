package com.diskord.diskord.service;


import com.diskord.diskord.model.Community;
import com.diskord.diskord.repository.CommunityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityService {

    private final CommunityRepository communityRepository;

    public CommunityService(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    public void createCommunity(Community community) {
        communityRepository.save(community);
    }

    public Community getCommunityById(int id) {
        return communityRepository.findById(id);
    }

    public List<Community> getAllCommunities() {
        return communityRepository.findAll();
    }

    public void updateCommunity(Community community) {
        communityRepository.update(community);
    }

    public void deleteCommunity(int id) {
        communityRepository.deleteById(id);
    }
}
