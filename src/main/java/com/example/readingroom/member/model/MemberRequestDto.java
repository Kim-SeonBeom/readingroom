package com.example.readingroom.member.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberRequestDto {
    private String email;
    private String name;
    private String password;
    private String phone;
}


