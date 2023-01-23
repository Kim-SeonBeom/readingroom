package com.example.readingroom.admin.service;

import com.example.readingroom.admin.model.MemberStatusChangeResponseDto;

public interface AdminMemberService {
    MemberStatusChangeResponseDto changeStatusIng(Long id);
    MemberStatusChangeResponseDto changeStatusStop(Long id);
}
