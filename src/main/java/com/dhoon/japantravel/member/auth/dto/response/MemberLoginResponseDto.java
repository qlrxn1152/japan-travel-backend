package com.dhoon.japantravel.member.auth.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access =  AccessLevel.PRIVATE)
@Getter
public class MemberLoginResponseDto {

    private String accessToken;

    public static MemberLoginResponseDto of(String accessToken) {
        return new MemberLoginResponseDto(accessToken);
    }
}
