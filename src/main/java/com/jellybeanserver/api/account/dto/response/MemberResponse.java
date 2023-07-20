package com.jellybeanserver.api.account.dto.response;

import com.jellybeanserver.api.account.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponse {

    private String email;

    public static MemberResponse memberResponse(Member member) {
        return new MemberResponse(member.getEmail());
    }
}
