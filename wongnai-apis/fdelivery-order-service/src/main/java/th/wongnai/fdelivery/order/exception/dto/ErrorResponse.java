package th.wongnai.fdelivery.order.exception.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Value
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorResponse {

    int code;

    String message;

    List<ErrorInfo> errors;

    @Value
    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class ErrorInfo {

        String domain;

        String reason;

        String message;

    }
}
