package Exceptions;

public class ClientException extends RuntimeException {


    public class InvalidInputException extends RuntimeException {
        public InvalidInputException(String errorMessage) {
            super(errorMessage);
        }
    }

    public class CouponNotFoundException extends RuntimeException {
        public CouponNotFoundException(String errorMessage) {
            super(errorMessage);
        }
    }
}
