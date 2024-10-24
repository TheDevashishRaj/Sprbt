package com.diskord.diskord.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.diskord.diskord.model.Member;
import com.diskord.diskord.repository.MemberRepository;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member saveMember(Member member) {
        memberRepository.save(member);
        return member;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(int userId, int groupId) {
        return memberRepository.findById(userId, groupId);
    }

    public void deleteMember(int userId, int groupId) {
        memberRepository.delete(userId, groupId);
    }
}
