package model.exceptions;

import java.io.Serial;

/* Também pode usar como extensão a class RunTimeException
que não obriga o tratamento, ao contrário da Exception */
public class DomainException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public DomainException(String msg) {
        super(msg);
    }
}
