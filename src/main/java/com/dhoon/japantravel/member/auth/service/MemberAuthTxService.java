package com.dhoon.japantravel.member.auth.service;

import com.dhoon.japantravel.global.security.jwt.JwtTokenProvider;
import com.dhoon.japantravel.member.auth.dto.request.MemberCreateRequestDto;
import com.dhoon.japantravel.member.auth.dto.request.MemberLoginRequestDto;
import com.dhoon.japantravel.member.auth.dto.response.MemberCreateResponseDto;
import com.dhoon.japantravel.member.auth.dto.response.MemberLoginResponseDto;
import com.dhoon.japantravel.member.auth.exception.DuplicateUsernameException;
import com.dhoon.japantravel.member.domain.Member;
import com.dhoon.japantravel.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MemberAuthTxService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public MemberCreateResponseDto signup(MemberCreateRequestDto requestDto) {

        if (memberRepository.existsByUsername(requestDto.getUsername())) {
            throw new DuplicateUsernameException();
        }

        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());

        Member member = memberRepository.save(Member.signup(requestDto.getUsername(), encodedPassword));

        return MemberCreateResponseDto.of(member);
    }

    public MemberLoginResponseDto login(MemberLoginRequestDto requestDto) {
        Authentication authenticate = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken.unauthenticated(
                        requestDto.getUsername(),
                        requestDto.getPassword()
                )
        );

        String accessToken = jwtTokenProvider.createAccessToken(authenticate);

        return MemberLoginResponseDto.of(accessToken);
    }


}
