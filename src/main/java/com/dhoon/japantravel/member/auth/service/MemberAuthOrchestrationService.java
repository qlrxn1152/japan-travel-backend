package com.dhoon.japantravel.member.auth.service;

import com.dhoon.japantravel.member.auth.dto.request.MemberCreateRequestDto;
import com.dhoon.japantravel.member.auth.dto.request.MemberLoginRequestDto;
import com.dhoon.japantravel.member.auth.dto.response.MemberCreateResponseDto;
import com.dhoon.japantravel.member.auth.dto.response.MemberLoginResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberAuthOrchestrationService {

    private final MemberAuthTxService txService;

    public MemberCreateResponseDto signup(MemberCreateRequestDto requestDto) {
        return txService.signup(requestDto);
    }

    public MemberLoginResponseDto login(MemberLoginRequestDto requestDto) {
        return txService.login(requestDto);
    }


}
