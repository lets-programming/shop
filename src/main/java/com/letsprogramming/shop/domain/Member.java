package com.letsprogramming.shop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "member")
public class Member {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "member_index", nullable = false)
    private long memberIndex;
    @Basic
    @Column(name = "id", nullable = false)
    private String id;
    @Basic
    @Column(name = "password", nullable = false, length = 72)
    private String password;
    @Basic
    @Column(name = "name", nullable = false)
    private String name;
    @Basic
    @Column(name = "join_datetime", nullable = false)
    @Convert(converter = DateTimeConverter.class)
    private OffsetDateTime joinDatetime;
    @Basic
    @Column(name = "update_datetime", nullable = false)
    @Convert(converter = DateTimeConverter.class)
    private OffsetDateTime updateDatetime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return memberIndex == member.memberIndex && Objects.equals(id, member.id) && Objects.equals(password, member.password) && Objects.equals(name, member.name) && Objects.equals(joinDatetime, member.joinDatetime) && Objects.equals(updateDatetime, member.updateDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberIndex, id, password, name, joinDatetime, updateDatetime);
    }
}
