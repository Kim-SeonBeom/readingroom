package com.example.readingroom.admin.controller;

import com.example.readingroom.admin.model.MemberStatusChangeResponseDto;
import com.example.readingroom.admin.service.AdminMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AdminMemberApiController {

    private final AdminMemberService adminMemberService;

    @PutMapping("/api/admin/member/ing/{id}")
    public ResponseEntity<?> changeStatusIng(@PathVariable Long id){
        MemberStatusChangeResponseDto responseDto = adminMemberService.changeStatusIng(id);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("api/admin/member/stop/{id}")
    public ResponseEntity<?> changeStatusStop(@PathVariable Long id){
        MemberStatusChangeResponseDto responseDto = adminMemberService.changeStatusStop(id);
        return ResponseEntity.ok(responseDto);
    }


}
