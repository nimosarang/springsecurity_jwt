package com.jellybeanserver.api.account.controller;


import com.jellybeanserver.api.account.dto.TokenDto;
import com.jellybeanserver.api.account.dto.request.MemberRequest;
import com.jellybeanserver.api.account.dto.request.TokenRequest;
import com.jellybeanserver.api.account.dto.response.MemberResponse;
import com.jellybeanserver.api.account.service.AuthService;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MemberResponse> signup(@RequestBody MemberRequest memberRequest) {
        return ResponseEntity.ok(authService.signup(memberRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberRequest memberRequest) {
        return ResponseEntity.ok(authService.login(memberRequest));
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequest tokenRequest) {
        return ResponseEntity.ok(authService.reissue(tokenRequest));
    }
}