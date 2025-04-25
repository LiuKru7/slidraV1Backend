package com.slidra.slidraV1.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private String message;
    private Timestamp timestamp;
}
