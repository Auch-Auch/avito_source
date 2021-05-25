package hu.akarnokd.rxjava3.debug.validator;
public abstract class ProtocolNonConformanceException extends IllegalStateException {
    private static final long serialVersionUID = -6096755460680899745L;

    public ProtocolNonConformanceException() {
    }

    public ProtocolNonConformanceException(String str, Throwable th) {
        super(str, th);
    }

    public ProtocolNonConformanceException(String str) {
        super(str);
    }

    public ProtocolNonConformanceException(Throwable th) {
        super(th);
    }
}
