package com.upperwings.planningroutime.api.controllers;

import com.upperwings.planningroutime.api.dtos.UserAuthDto;
import com.upperwings.planningroutime.api.dtos.tokenJWTDto;
import com.upperwings.planningroutime.api.models.UserModel;
import com.upperwings.planningroutime.api.configs.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneOffset;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid UserAuthDto userAuthDto){
        var authToken = new UsernamePasswordAuthenticationToken(userAuthDto.username(), userAuthDto.password());
        var auth = authenticationManager.authenticate(authToken);

        var tokenJWT = tokenService.generateToken((UserModel) auth.getPrincipal());
        var tokenExpiresDate = tokenService.getExpireAt(tokenJWT).atOffset(ZoneOffset.of("-03:00"));
        return ResponseEntity.ok(new tokenJWTDto(tokenJWT, tokenExpiresDate));
    }
}
