package com.apulia.memberservice.service;

import com.apulia.memberservice.exception.MemberNotFoundException;
import com.apulia.memberservice.model.Member;
import com.apulia.memberservice.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Integer id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("Member with ID " + id + " not found"));
    }

    public Member createMember(Member member) {
        if (memberRepository.existsByPhone(member.getPhone())) {
            throw new IllegalArgumentException("Phone number already exists: " + member.getPhone());
        }
        return memberRepository.save(member);
    }

    public Member updateMember(Integer id, Member updatedMember) {
        Member existing = getMemberById(id);

        if (!existing.getPhone().equals(updatedMember.getPhone())
                && memberRepository.existsByPhone(updatedMember.getPhone())) {
            throw new IllegalArgumentException("Phone number already exists: " + updatedMember.getPhone());
        }

        existing.setFirstName(updatedMember.getFirstName());
        existing.setLastName(updatedMember.getLastName());
        existing.setCity(updatedMember.getCity());
        existing.setPhone(updatedMember.getPhone());

        return memberRepository.save(existing);
    }

    public void deleteMember(Integer id) {
        if (!memberRepository.existsById(id)) {
            throw new MemberNotFoundException("Member with ID " + id + " not found");
        }
        memberRepository.deleteById(id);
    }
}
