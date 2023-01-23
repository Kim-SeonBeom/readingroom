package com.example.readingroom.admin.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberStatusChangeResponseDto {
    private String email;
    private String name;
    private String memberStatus;
}
