package com.junghwan.jwt.controller;

import com.junghwan.jwt.dto.JoinDto;
import com.junghwan.jwt.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/join")
    public String joinProcess(@RequestBody JoinDto joinDto) {
        joinService.joinProcess(joinDto);
        
        return "ok";
    }
}
