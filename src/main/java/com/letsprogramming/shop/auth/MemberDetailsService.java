package com.letsprogramming.shop.auth;

import com.letsprogramming.shop.domain.Member;
import com.letsprogramming.shop.exception.NotFoundException;
import com.letsprogramming.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findMemberById(username);
        if (null == member) {
            throw new NotFoundException("Cannot found member by username : " + username);
        }
        return MemberDetails.of(member);
    }
}
