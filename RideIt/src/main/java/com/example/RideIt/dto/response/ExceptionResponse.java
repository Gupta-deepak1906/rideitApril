package com.example.RideIt.dto.response;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ExceptionResponse {

    String message;
    int status;
}
