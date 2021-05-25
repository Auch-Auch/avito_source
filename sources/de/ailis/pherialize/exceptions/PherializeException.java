package de.ailis.pherialize.exceptions;
public abstract class PherializeException extends RuntimeException {
    private static final long serialVersionUID = 1479169743443565173L;

    public PherializeException() {
    }

    public PherializeException(String str) {
        super(str);
    }

    public PherializeException(String str, Throwable th) {
        super(str, th);
    }

    public PherializeException(Throwable th) {
        super(th);
    }
}
