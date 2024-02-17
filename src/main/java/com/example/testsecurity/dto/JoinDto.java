package com.example.testsecurity.dto;

import com.example.testsecurity.entity.UserEntity;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JoinDto {

    private String username;
    private String password;

    @Builder
    public JoinDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserEntity toEntity(String role){
        return UserEntity.builder()
                .username(username)
                .password(password)
                .role(role)
                .build();
    }
}
