package th.wongnai.fdelivery.order.exception;

import org.springframework.http.HttpStatus;

public interface ErrorPrinter {

    HttpStatus getHttpStatus();

}
