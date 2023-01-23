package com.example.readingroom.member.controller;

import com.example.readingroom.member.model.MemberRequestDto;
import com.example.readingroom.member.model.MemberResponseDto;
import com.example.readingroom.member.repository.MemberRepository;
import com.example.readingroom.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @PostMapping("/api/member")
    public ResponseEntity<?> signUp(@RequestBody MemberRequestDto requestDto) {
        return ResponseEntity.ok(memberService.signup(requestDto));
    }

    @GetMapping("/api/member/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.findById(id));
    }

    @DeleteMapping("/api/member/{id}")
    public ResponseEntity<?> withdraw(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.deleteMember(id));
    }


}
