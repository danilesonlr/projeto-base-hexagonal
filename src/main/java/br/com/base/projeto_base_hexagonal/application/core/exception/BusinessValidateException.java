package br.com.base.projeto_base_hexagonal.application.core.exception;

public class BusinessValidateException extends RuntimeException {

    private String code;

    public BusinessValidateException(String message) {
        super(message);
    }

    public BusinessValidateException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessValidateException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getCode() {
        return code;
    }
}
