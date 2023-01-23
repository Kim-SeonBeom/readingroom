package com.example.readingroom.member.service;

import com.example.readingroom.member.entity.Member;
import com.example.readingroom.member.model.MemberRequestDto;
import com.example.readingroom.member.model.MemberResponseDto;
import com.example.readingroom.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Override
    public String signup(MemberRequestDto requestDto) {
        Optional<Member> optionalMember = memberRepository.findByEmail(requestDto.getEmail());
        if(optionalMember.isPresent()){
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }
        String password = passwordEncoder.encode(requestDto.getPassword());

        Member member = Member.builder()
                .email(requestDto.getEmail())
                .phone(requestDto.getPhone())
                .password(password)
                .name(requestDto.getName())
                .memberStatus("REG")
                .regDate(LocalDateTime.now())
                .build();

        memberRepository.save(member);

        return member.getEmail();
    }

    @Override
    public String deleteMember(Long id) {
        Member member = memberRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        memberRepository.delete(member);
        return member.getName();
    }

    @Override
    public MemberResponseDto findById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        return MemberResponseDto.builder()
                .email(member.getEmail())
                .name(member.getName())
                .phone(member.getPhone())
                .build();
    }
}

