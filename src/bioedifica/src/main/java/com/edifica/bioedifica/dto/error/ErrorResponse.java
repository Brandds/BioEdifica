package com.edifica.bioedifica.dto.error;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private int status;
    private String error;
    private String message;
    private String details;
    private LocalDateTime timestamp;
}