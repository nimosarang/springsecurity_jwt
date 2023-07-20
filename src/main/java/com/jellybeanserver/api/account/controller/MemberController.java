package com.jellybeanserver.api.account.controller;

import com.jellybeanserver.api.account.dto.response.MemberResponse;
import com.jellybeanserver.api.account.service.MemberService;
import com.jellybeanserver.api.account.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/me")
    public ResponseEntity<MemberResponse> findMemberInfoById() {
        return ResponseEntity.ok(
            memberService.findMemberInfoById(SecurityUtil.getCurrentMemberId()));
    }

    @GetMapping("/{email}")
    public ResponseEntity<MemberResponse> findMemberInfoByEmail(@PathVariable String email) {
        return ResponseEntity.ok(memberService.findMemberInfoByEmail(email));
    }
}