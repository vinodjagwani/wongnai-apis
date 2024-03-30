package th.wongnai.fdelivery.order.exception.dto;

import org.springframework.http.HttpStatus;
import th.wongnai.fdelivery.order.exception.ErrorPrinter;

public enum ErrorCodeEnum implements ErrorPrinter {

    INVALID_PARAM(HttpStatus.BAD_REQUEST),
    INVALID_DATA(HttpStatus.BAD_REQUEST),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED);

    ErrorCodeEnum(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    private final HttpStatus httpStatus;

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
