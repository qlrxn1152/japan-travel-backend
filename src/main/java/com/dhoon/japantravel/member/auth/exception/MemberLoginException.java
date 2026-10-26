package com.dhoon.japantravel.member.auth.exception;

public class MemberLoginException extends RuntimeException {
    public MemberLoginException() {
        super("아이디 또는 비밀번호가 맞지 않습니다.");
    }
}
