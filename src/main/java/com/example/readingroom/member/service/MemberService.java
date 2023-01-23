package com.example.readingroom.member.service;

import com.example.readingroom.member.model.MemberRequestDto;
import com.example.readingroom.member.model.MemberResponseDto;

public interface MemberService {
    String signup(MemberRequestDto requestDto);

    String deleteMember(Long id);

    MemberResponseDto findById(Long id);
}


