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

import com.diskord.diskord.model.Member;
import com.diskord.diskord.service.MemberService;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // Create a new member
    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        Member savedMember = memberService.saveMember(member);
        return ResponseEntity.ok(savedMember);
    }

    // Get all members
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        List<Member> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    // Get member by userId and groupId
    @GetMapping("/{userId}/{groupId}")
    public ResponseEntity<Member> getMemberById(@PathVariable int userId, @PathVariable int groupId) {
        Member member = memberService.getMemberById(userId, groupId);
        return ResponseEntity.ok(member);
    }

    // Delete member by userId and groupId
    @DeleteMapping("/{userId}/{groupId}")
    public ResponseEntity<Void> deleteMember(@PathVariable int userId, @PathVariable int groupId) {
        memberService.deleteMember(userId, groupId);
        return ResponseEntity.noContent().build();
    }
}
