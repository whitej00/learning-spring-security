package com.example.testsecurity.controller;

import com.example.testsecurity.dto.JoinDto;
import com.example.testsecurity.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @GetMapping("/join")
    public String joinP(){
        return "join";
    }

    @PostMapping("/joinProc")
    public String joinProcess(JoinDto joinDto){

        System.out.println("joinDto = " + joinDto);

        joinService.joinProcess(joinDto);

        return "redirect:/login";
    }
}
