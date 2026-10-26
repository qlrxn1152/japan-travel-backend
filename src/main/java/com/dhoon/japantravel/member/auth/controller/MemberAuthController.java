package com.dhoon.japantravel.member.auth.controller;

import com.dhoon.japantravel.member.auth.dto.request.MemberCreateRequestDto;
import com.dhoon.japantravel.member.auth.dto.request.MemberLoginRequestDto;
import com.dhoon.japantravel.member.auth.dto.response.MemberCreateResponseDto;
import com.dhoon.japantravel.member.auth.dto.response.MemberLoginResponseDto;
import com.dhoon.japantravel.member.auth.service.MemberAuthOrchestrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MemberAuthController {

    private final MemberAuthOrchestrationService orchService;

    @PostMapping("/api/members/signup")
    public ResponseEntity<MemberCreateResponseDto> signup(@Valid @RequestBody MemberCreateRequestDto requestDto) {
        MemberCreateResponseDto response = orchService.signup(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<MemberLoginResponseDto> login(@Valid @RequestBody MemberLoginRequestDto requestDto) {
        MemberLoginResponseDto response = orchService.login(requestDto);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
