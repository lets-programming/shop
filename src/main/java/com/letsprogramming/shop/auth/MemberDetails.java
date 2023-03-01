package com.letsprogramming.shop.auth;

import com.letsprogramming.shop.domain.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class MemberDetails extends Member implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return MemberRoles.ROLE_USER;
    }

    @Override
    public String getUsername() {
        return getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static MemberDetails of(Member member) {
        MemberDetails memberDetails = new MemberDetails();
        memberDetails.setMemberIndex(member.getMemberIndex());
        memberDetails.setName(member.getName());
        memberDetails.setId(member.getId());
        memberDetails.setPassword(member.getPassword());
        memberDetails.setJoinDatetime(member.getJoinDatetime());
        memberDetails.setUpdateDatetime(member.getUpdateDatetime());
        return memberDetails;
    }
}
