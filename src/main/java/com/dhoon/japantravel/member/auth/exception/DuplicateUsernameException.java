package com.dhoon.japantravel.member.auth.exception;

public class DuplicateUsernameException extends RuntimeException {
    public DuplicateUsernameException() {
        super("이미 존재하는 아이디입니다.");
    }
}
