package de.ailis.pherialize.exceptions;
public class SerializeException extends PherializeException {
    private static final long serialVersionUID = 5304443329670892370L;

    public SerializeException() {
    }

    public SerializeException(String str) {
        super(str);
    }

    public SerializeException(String str, Throwable th) {
        super(str, th);
    }

    public SerializeException(Throwable th) {
        super(th);
    }
}
