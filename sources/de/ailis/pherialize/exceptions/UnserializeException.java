package de.ailis.pherialize.exceptions;
public class UnserializeException extends PherializeException {
    private static final long serialVersionUID = -7127648595193318947L;
    public final int position;

    public UnserializeException(int i) {
        this.position = i;
    }

    public UnserializeException(String str, int i) {
        super(str);
        this.position = i;
    }

    public UnserializeException(String str, Throwable th, int i) {
        super(str, th);
        this.position = i;
    }

    public UnserializeException(Throwable th, int i) {
        super(th);
        this.position = i;
    }
}
