package com.example.hobbytat.controller;

import com.example.hobbytat.controller.dto.request.*;
import com.example.hobbytat.controller.dto.response.*;
import com.example.hobbytat.domain.HobbyType;
import com.example.hobbytat.domain.Member;
import com.example.hobbytat.security.UserAdaptor;
import com.example.hobbytat.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signin")
    public PostSignInResponseDto signIn(@RequestBody SignInRequestDto signInRequestDto) {
        // 로그인
        String accessToken = memberService.makeToken(signInRequestDto.getUsername(), signInRequestDto.getPassword());

        return PostSignInResponseDto.builder()
                .status(200)
                .isSuccess(true)
                .accessToken(accessToken)
                .build();
    }

    @PostMapping("/signup")
    public PostSignUpResponseDto signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
        // 회원가입
        return memberService.save(signUpRequestDto.toEntity());
    }

    @PostMapping("/check-nickname")
    public PostCheckNicknameResponseDto checkNickname(@RequestBody CheckNicknameRequestDto checkNicknameRequestDto) {
        // 닉네임 중복 체크
        boolean isAvailable = memberService.checkNickname(checkNicknameRequestDto.getNickname());
        return PostCheckNicknameResponseDto.builder()
                .status(200)
                .isSuccess(true)
                .isAvailable(isAvailable)
                .build();
    }

    @PostMapping("/check-username")
    public PostCheckUsernameResponseDto checkUsername(@RequestBody CheckUsernameRequestDto checkUsernameRequestDto) {
        // 아이디 중복 체크
        boolean isAvailable = memberService.checkUsername(checkUsernameRequestDto.getUsername());
        return PostCheckUsernameResponseDto.builder()
                .status(200)
                .isSuccess(true)
                .isAvailable(isAvailable)
                .build();
    }

    @PostMapping("/hobby-test")
    public GetHobbyTypeResponseDto getHobbyType(@RequestBody GetHobbyTypeRequestDTO getHobbyTypeRequestDTO) {
        // Hobby Type 연산 후 반환 로직
        HobbyType hobbyType = memberService.getHobbyType(getHobbyTypeRequestDTO.getData());
        return GetHobbyTypeResponseDto.builder()
                .status(200)
                .isSuccess(true)
                .hobbyType(hobbyType)
                .build();
    }

    @GetMapping("/profile")
    public GetMyProfileResponseDto getMyProfile(@AuthenticationPrincipal UserAdaptor userAdaptor) {
        // 내 프로필 정보
        return GetMyProfileResponseDto.toDto(userAdaptor.getMember());
    }

    @GetMapping("/profile/{memberId}")
    public GetProfileResponseDto getProfile(@PathVariable Long memberId) {
        // 내 프로필 정보
        Member member = memberService.findMemberById(memberId);
        return GetProfileResponseDto.toDto(member);
    }



}
