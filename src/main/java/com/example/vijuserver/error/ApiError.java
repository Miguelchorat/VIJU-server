package com.example.vijuserver.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * Clase usada para mandar los datos de error que son mínimamente necesarios
 */
@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder

public class ApiError {
    @NonNull
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime date = LocalDateTime.now();
    @NonNull
    private String message;
}