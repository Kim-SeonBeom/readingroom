package com.example.readingroom.admin.service;


import com.example.readingroom.admin.model.MemberStatusChangeResponseDto;
import com.example.readingroom.member.entity.Member;
import com.example.readingroom.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AdminMemberServiceImpl implements AdminMemberService {
    private final MemberRepository memberRepository;

    @Override
    public MemberStatusChangeResponseDto changeStatusIng(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        if(member.getMemberStatus().equals("ING")){
            throw new IllegalArgumentException("이미 정상이용중인 회원입니다.");
        }
        member.setMemberStatus("ING");

        memberRepository.save(member);

        return MemberStatusChangeResponseDto.builder()
                .email(member.getEmail())
                .name(member.getName())
                .memberStatus("ING")
                .build();
    }
    @Override
    public MemberStatusChangeResponseDto changeStatusStop(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        if(member.getMemberStatus().equals("STOP")){
            throw new IllegalArgumentException("이미 정지된 회원입니다.");
        }
        member.setMemberStatus("STOP");

        memberRepository.save(member);

        return MemberStatusChangeResponseDto.builder()
                .email(member.getEmail())
                .name(member.getName())
                .memberStatus("STOP")
                .build();
    }
}
