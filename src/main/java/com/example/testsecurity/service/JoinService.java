package com.example.testsecurity.service;

import com.example.testsecurity.dto.JoinDto;
import com.example.testsecurity.entity.UserEntity;
import com.example.testsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDto joinDto){

        // 기존 회원 존재 유무
        boolean isUser = userRepository.existsByUsername(joinDto.getUsername());
        if (isUser){
            return;
        }


        UserEntity userEntity = UserEntity.builder()
                .username(joinDto.getUsername())
                .password(bCryptPasswordEncoder.encode(joinDto.getPassword()))
                .role("ROLE_ADMIN")
                .build();

        userRepository.save(userEntity);
    }
}
