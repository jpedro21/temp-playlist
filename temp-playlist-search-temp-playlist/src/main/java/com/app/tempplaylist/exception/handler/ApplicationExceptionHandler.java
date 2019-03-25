package com.app.tempplaylist.exception.handler;

import com.app.tempplaylist.dto.ErrorDto;
import com.app.tempplaylist.exception.NoResultException;
import com.app.tempplaylist.exception.PlaylistException;
import org.joda.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = PlaylistException.class)
    public ErrorDto playlistExceptionHandler(final PlaylistException exception) {
        return createDto(HttpStatus.BAD_REQUEST, exception);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(value = NoResultException.class)
    public ErrorDto noResultExceptionHandler(final PlaylistException exception) {
        return createDto(HttpStatus.NO_CONTENT, exception);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = NoResultException.class)
    public ErrorDto weatherExceptionHandler(final PlaylistException exception) {
        return createDto(HttpStatus.BAD_REQUEST, exception);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = HttpClientErrorException.class)
    public ErrorDto internalExceptionHandler(final PlaylistException exception) {
        return createDto(HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }

    private ErrorDto createDto(HttpStatus status, Exception e) {
        return new ErrorDto(status.value(), LocalDate.now(), e.getMessage());
    }
}
