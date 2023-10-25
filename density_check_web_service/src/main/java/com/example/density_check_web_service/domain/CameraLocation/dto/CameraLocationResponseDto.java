package com.example.density_check_web_service.domain.CameraLocation.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class CameraLocationResponseDto {
    private Long id;
    private String ip;

    @Builder
    public CameraLocationResponseDto(String ip) {
        this.ip = ip;
    }
}
