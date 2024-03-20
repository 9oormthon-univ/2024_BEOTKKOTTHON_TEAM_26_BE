package com.example.sixpack.api.v1;


import com.example.sixpack.config.exception.response.Response;
import com.example.sixpack.dto.sign.LoginRequestDto;
import com.example.sixpack.dto.sign.SignUpRequestDto;
import com.example.sixpack.dto.sign.TokenRequestDto;
import com.example.sixpack.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.example.sixpack.config.exception.response.Response.success;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class AuthController {
    private final AuthService authService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/sign-up")
    public Response register(@Valid @RequestBody SignUpRequestDto signUpRequestDto) {
        authService.signup(signUpRequestDto);
        return success();
    }

    @PostMapping("/sign-in")
    @ResponseStatus(HttpStatus.OK)
    public Response signIn(@Valid @RequestBody LoginRequestDto req) {
        return success(authService.signIn(req));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/reissue")
    public Response reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return success(authService.reissue(tokenRequestDto));
    }
}