package com.dhoon.japantravel.member.auth.dto.response;

import com.dhoon.japantravel.member.domain.Member;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access =  AccessLevel.PRIVATE)
@Getter
public class MemberCreateResponseDto {

    private Long memberId;
    private String username;

    public static MemberCreateResponseDto of(Member member) {
        return new MemberCreateResponseDto(member.getId(), member.getUsername());
    }
}
