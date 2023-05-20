package com.example.vijuserver.error;

import com.example.vijuserver.error.exceptions.NewUserWithDifferentPasswordsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.sql.SQLException;
@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler{
    @ExceptionHandler(NewUserWithDifferentPasswordsException.class)
    public ResponseEntity<ApiError> handleNewUserErrors(Exception ex) {
        return buildErrorResponseEntity(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiError> handleUserNoEncontrado(UserNotFoundException ex){
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
    @ExceptionHandler(VideogameNotFoundException.class)
    public ResponseEntity<ApiError> handleVideogameNoEncontrado(VideogameNotFoundException ex){
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
    @ExceptionHandler(ReviewNotFoundException.class)
    public ResponseEntity<ApiError> handleReviewNoEncontrado(ReviewNotFoundException ex){
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
    @ExceptionHandler(LikeNotFoundException.class)
    public ResponseEntity<ApiError> handleLikeNoEncontrado(LikeNotFoundException ex){
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
    @ExceptionHandler(FavoriteNotFoundException.class)
    public ResponseEntity<ApiError> handleFavoriteNoEncontrado(FavoriteNotFoundException ex){
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
    @ExceptionHandler({SQLException.class})
    public ResponseEntity<Object> handleSQLException(SQLException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }

    @Override
    public ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError apiError = new ApiError(status, ex.getMessage());
        return ResponseEntity.status(status).body(apiError);
    }
    private ResponseEntity<ApiError> buildErrorResponseEntity(HttpStatus status, String message) {
        return ResponseEntity.status(status)
                .body(ApiError.builder()
                        .status(status)
                        .message(message)
                        .build());

    }
}
