package th.wongnai.fdelivery.driver.exception;

import org.springframework.http.HttpStatus;

public interface ErrorPrinter {

    HttpStatus getHttpStatus();

}
