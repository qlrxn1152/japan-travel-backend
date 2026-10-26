package com.dhoon.japantravel.member.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_MEMBER_USERNAME", columnNames = "username"
                )
        }
)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_grade", nullable = false)
    private MemberGrade memberGrade;

    private Member(String username, String password) {
        this.username = username;
        this.password = password;
        this.memberGrade = MemberGrade.MEMBER;
    }

    public static Member signup(String username, String password) {
        return new Member(username, password);
    }
}
